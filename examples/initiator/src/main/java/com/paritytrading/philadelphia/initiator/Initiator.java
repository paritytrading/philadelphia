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
package com.paritytrading.philadelphia.initiator;

import static com.paritytrading.philadelphia.fix42.FIX42Tags.*;

import com.paritytrading.philadelphia.FIXConfig;
import com.paritytrading.philadelphia.FIXConnection;
import com.paritytrading.philadelphia.FIXConnectionStatusListener;
import com.paritytrading.philadelphia.FIXMessage;
import com.paritytrading.philadelphia.FIXValue;
import com.paritytrading.philadelphia.FIXMessageListener;
import java.io.Closeable;
import java.io.IOException;
import java.net.SocketAddress;
import java.net.StandardSocketOptions;
import java.nio.channels.SocketChannel;
import org.HdrHistogram.Histogram;

class Initiator implements FIXMessageListener, Closeable {

    private static final FIXConfig CONFIG = new FIXConfig.Builder()
        .setSenderCompID("initiator")
        .setTargetCompID("acceptor")
        .build();

    private final FIXConnection connection;

    private final Histogram histogram;

    private long intervalNanos;

    private int receiveCount;

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
        FIXValue clOrdId = message.valueOf(ClOrdID);
        histogram.recordValue(System.nanoTime() - clOrdId.asInt());

        receiveCount++;
    }

    @Override
    public void close() throws IOException {
        connection.close();
    }

    Histogram getHistogram() {
        return histogram;
    }

    FIXConnection getTransport() {
        return connection;
    }

    void reset() {
        histogram.reset();

        receiveCount = 0;
    }

    void setIntervalNanos(long i) {
        intervalNanos = i;
    }

    void sendAndReceive(FIXMessage message, FIXValue clOrdId, int orders) throws IOException {
        for (long sentAtNanoTime = System.nanoTime(); receiveCount < orders; connection.receive()) {
            if (System.nanoTime() >= sentAtNanoTime) {
                clOrdId.setInt(sentAtNanoTime);

                connection.update(message);
                connection.send(message);

                sentAtNanoTime += intervalNanos;
            }
        }
    }

}
