/*
 * Copyright 2015 Philadelphia authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.paritytrading.philadelphia.client;

import com.paritytrading.philadelphia.FIXConfig;
import com.paritytrading.philadelphia.FIXConnection;
import com.paritytrading.philadelphia.FIXConnectionStatusListener;
import com.paritytrading.philadelphia.FIXMessage;
import com.paritytrading.philadelphia.FIXMessageListener;
import java.io.Closeable;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

class Session implements Closeable {

    private final FIXMessage txMessage;

    private final Selector selector;

    private final FIXConnection connection;

    private volatile boolean closed;

    private final Object lock;

    private Session(Selector selector, FIXConnection connection) {
        this.txMessage = connection.create();

        this.selector = selector;

        this.connection = connection;

        this.closed = false;

        this.lock = new Object();

        var receiver = new Thread(new Receiver());

        receiver.setDaemon(true);
        receiver.start();
    }

    static Session open(InetSocketAddress address,
            FIXConfig config, FIXMessageListener listener,
            FIXConnectionStatusListener statusListener) throws IOException {
        var channel = SocketChannel.open();

        channel.connect(address);
        channel.configureBlocking(false);

        var selector = Selector.open();

        channel.register(selector, SelectionKey.OP_READ);

        var connection = new FIXConnection(channel, config, listener, statusListener, System.currentTimeMillis());

        return new Session(selector, connection);
    }

    @Override
    public void close() {
        closed = true;
    }

    FIXConnection getConnection() {
        return connection;
    }

    void send(Message message) throws IOException {
        synchronized (lock) {
            connection.setCurrentTimeMillis(System.currentTimeMillis());
        }

        connection.prepare(txMessage, message.getMsgType());

        message.put(txMessage);

        synchronized (lock) {
            connection.send(txMessage);
        }
    }

    private class Receiver implements Runnable {

        private static final long TIMEOUT_MILLIS = 100;

        @Override
        public void run() {
            try {
                while (!closed) {
                    int numKeys = selector.select(TIMEOUT_MILLIS);
                    if (numKeys > 0) {
                        synchronized (lock) {
                            if (connection.receive() < 0)
                                break;
                        }

                        selector.selectedKeys().clear();
                    }

                    synchronized (lock) {
                        connection.setCurrentTimeMillis(System.currentTimeMillis());

                        connection.keepAlive();
                    }
                }
            } catch (IOException e) {
            }

            try {
                connection.close();
            } catch (IOException e) {
            }

            try {
                selector.close();
            } catch (IOException e) {
            }
        }

    }

}
