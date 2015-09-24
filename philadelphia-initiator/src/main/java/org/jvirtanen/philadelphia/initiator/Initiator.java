package org.jvirtanen.philadelphia.initiator;

import static org.jvirtanen.philadelphia.fix42.FIX42MsgTypes.*;
import static org.jvirtanen.philadelphia.fix42.FIX42Tags.*;

import java.io.IOException;
import java.net.SocketAddress;
import java.net.StandardSocketOptions;
import java.nio.channels.SocketChannel;
import org.HdrHistogram.Histogram;
import org.jvirtanen.philadelphia.FIXConfig;
import org.jvirtanen.philadelphia.FIXMessage;
import org.jvirtanen.philadelphia.FIXMessageListener;
import org.jvirtanen.philadelphia.FIXSession;
import org.jvirtanen.philadelphia.FIXStatusListener;

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
            public void close(String message) throws IOException {
                transport.close();
            }

            @Override
            public void sequenceReset() {
            }

            @Override
            public void tooLowMsgSeqNum(long receivedMsgSeqNum, long expectedMsgSeqNum) {
            }

            @Override
            public void heartbeatTimeout() throws IOException {
                transport.close();
            }

            @Override
            public void reject(FIXMessage message) throws IOException {
            }

            @Override
            public void logon(FIXMessage message) throws IOException {
            }

            @Override
            public void logout(FIXMessage message) throws IOException {
                transport.sendLogout();
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
