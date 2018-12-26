package com.paritytrading.philadelphia.initiator;

import com.paritytrading.philadelphia.FIXConfig;
import com.paritytrading.philadelphia.FIXConnection;
import com.paritytrading.philadelphia.FIXConnectionStatusListener;
import com.paritytrading.philadelphia.FIXMessage;
import com.paritytrading.philadelphia.FIXMessageListener;
import java.io.IOException;
import java.net.SocketAddress;
import java.net.StandardSocketOptions;
import java.nio.channels.SocketChannel;
import org.HdrHistogram.Histogram;

class Initiator implements FIXMessageListener {

    private static final FIXConfig CONFIG = new FIXConfig.Builder()
        .setSenderCompID("initiator")
        .setTargetCompID("acceptor")
        .build();

    private FIXConnection connection;

    private Histogram histogram;

    private long sentAtNanoTime;

    private boolean received;

    private Initiator(SocketChannel channel) {
        connection = new FIXConnection(channel, CONFIG, this, new FIXConnectionStatusListener() {

            @Override
            public void close(FIXConnection connection, String message) throws IOException {
                connection.close();
            }

            @Override
            public void sequenceReset(FIXConnection connection) {
            }

            @Override
            public void tooLowMsgSeqNum(FIXConnection connection, long receivedMsgSeqNum, long expectedMsgSeqNum) {
            }

            @Override
            public void heartbeatTimeout(FIXConnection connection) throws IOException {
                connection.close();
            }

            @Override
            public void reject(FIXConnection connection, FIXMessage message) throws IOException {
            }

            @Override
            public void logon(FIXConnection connection, FIXMessage message) throws IOException {
            }

            @Override
            public void logout(FIXConnection connection, FIXMessage message) throws IOException {
                connection.sendLogout();
            }

        });

        histogram = new Histogram(3);
    }

    static Initiator open(SocketAddress address) throws IOException {
        SocketChannel channel = SocketChannel.open();

        channel.setOption(StandardSocketOptions.TCP_NODELAY, true);
        channel.connect(address);
        channel.configureBlocking(false);

        return new Initiator(channel);
    }

    @Override
    public void message(FIXMessage message) {
        histogram.recordValue(System.nanoTime() - sentAtNanoTime);

        received = true;
    }

    Histogram getHistogram() {
        return histogram;
    }

    FIXConnection getTransport() {
        return connection;
    }

    void send(FIXMessage message) throws IOException {
        sentAtNanoTime = System.nanoTime();

        connection.update(message);
        connection.send(message);

        received = false;
    }

    void receive() throws IOException {
        while (!received) {
            if (connection.receive() < 0)
                return;
        }

        received = false;
    }

}
