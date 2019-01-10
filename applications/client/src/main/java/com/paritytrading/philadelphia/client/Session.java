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

        Thread receiver = new Thread(new Receiver());

        receiver.setDaemon(true);
        receiver.start();
    }

    static Session open(InetSocketAddress address,
            FIXConfig config, FIXMessageListener listener,
            FIXConnectionStatusListener statusListener) throws IOException {
        SocketChannel channel = SocketChannel.open();

        channel.connect(address);
        channel.configureBlocking(false);

        Selector selector = Selector.open();

        channel.register(selector, SelectionKey.OP_READ);

        FIXConnection connection = new FIXConnection(channel, config, listener, statusListener);

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
            connection.updateCurrentTimestamp();
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
                        connection.updateCurrentTimestamp();

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
