package com.paritytrading.philadelphia.initiator;

import com.paritytrading.philadelphia.FIXConfig;
import com.paritytrading.philadelphia.FIXMessage;
import com.paritytrading.philadelphia.FIXMessageListener;
import com.paritytrading.philadelphia.FIXSession;
import com.paritytrading.philadelphia.FIXStatusListener;
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

    private FIXSession transport;

    private Histogram histogram;

    private long sentAtNanoTime;

    private boolean received;

    private Initiator(SocketChannel channel) {
        transport = new FIXSession(channel, CONFIG, this, new FIXStatusListener() {

            @Override
            public void close(FIXSession session, String message) throws IOException {
                session.close();
            }

            @Override
            public void sequenceReset(FIXSession session) {
            }

            @Override
            public void tooLowMsgSeqNum(FIXSession session, long receivedMsgSeqNum, long expectedMsgSeqNum) {
            }

            @Override
            public void heartbeatTimeout(FIXSession session) throws IOException {
                session.close();
            }

            @Override
            public void reject(FIXSession session, FIXMessage message) throws IOException {
            }

            @Override
            public void logon(FIXSession session, FIXMessage message) throws IOException {
            }

            @Override
            public void logout(FIXSession session, FIXMessage message) throws IOException {
                session.sendLogout();
            }

        });

        histogram = new Histogram(3);
    }

    public static Initiator open(SocketAddress address) throws IOException {
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

    public Histogram getHistogram() {
        return histogram;
    }

    public FIXSession getTransport() {
        return transport;
    }

    public void send(FIXMessage message) throws IOException {
        sentAtNanoTime = System.nanoTime();

        transport.update(message);
        transport.send(message);

        received = false;
    }

    public void receive() throws IOException {
        while (!received) {
            if (transport.receive() < 0)
                return;
        }

        received = false;
    }

}
