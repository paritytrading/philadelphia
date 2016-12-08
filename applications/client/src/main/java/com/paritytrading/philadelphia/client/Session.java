package com.paritytrading.philadelphia.client;

import com.paritytrading.philadelphia.FIXConfig;
import com.paritytrading.philadelphia.FIXMessage;
import com.paritytrading.philadelphia.FIXMessageListener;
import com.paritytrading.philadelphia.FIXSession;
import com.paritytrading.philadelphia.FIXStatusListener;
import com.paritytrading.philadelphia.client.message.Message;
import java.io.Closeable;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

public class Session implements Closeable {

    private FIXMessage txMessage;

    private Selector selector;

    private FIXSession transport;

    private volatile boolean closed;

    private Object lock;

    private Session(Selector selector, FIXSession transport) {
        this.txMessage = transport.create();

        this.selector = selector;

        this.transport = transport;

        this.closed = false;

        this.lock = new Object();

        new Thread(new Receiver()).start();
    }

    public static Session open(InetSocketAddress address,
            FIXConfig config, FIXMessageListener listener,
            FIXStatusListener statusListener) throws IOException {
        SocketChannel channel = SocketChannel.open();

        channel.connect(address);
        channel.configureBlocking(false);

        Selector selector = Selector.open();

        channel.register(selector, SelectionKey.OP_READ);

        FIXSession transport = new FIXSession(channel, config, listener, statusListener);

        return new Session(selector, transport);
    }

    @Override
    public void close() {
        closed = true;
    }

    public FIXSession getTransport() {
        return transport;
    }

    public void send(Message message) throws IOException {
        synchronized (lock) {
            transport.updateCurrentTimestamp();
        }

        transport.prepare(txMessage, message.getMsgType());

        message.put(txMessage);

        synchronized (lock) {
            transport.send(txMessage);
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
                            if (transport.receive() < 0)
                                break;
                        }

                        selector.selectedKeys().clear();
                    }

                    synchronized (lock) {
                        transport.updateCurrentTimestamp();

                        transport.keepAlive();
                    }
                }
            } catch (IOException e) {
            }

            try {
                transport.close();
            } catch (IOException e) {
            }

            try {
                selector.close();
            } catch (IOException e) {
            }
        }

    }

}
