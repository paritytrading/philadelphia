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
package com.paritytrading.philadelphia;

import static com.paritytrading.philadelphia.FIX.*;
import static com.paritytrading.philadelphia.FIXMsgTypes.*;
import static com.paritytrading.philadelphia.FIXTags.*;

import java.io.Closeable;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.SocketChannel;

/**
 * A connection.
 */
public class FIXConnection implements Closeable {

    private static final int CURRENT_TIMESTAMP_FIELD_CAPACITY = 24;

    private final ReadableByteChannel rxChannel;
    private final GatheringByteChannel txChannel;

    private final FIXConfig config;

    private final FIXValue bodyLength;
    private final FIXValue checkSum;

    private String senderCompId;
    private String targetCompId;

    private long inMsgSeqNum;
    private long outMsgSeqNum;

    private final ByteBuffer rxBuffer;

    private final ByteBuffer txHeaderBuffer;

    private final int bodyLengthOffset;

    private final ByteBuffer txBodyBuffer;

    private final ByteBuffer[] txBuffers;

    /*
     * This variable is written on data reception and read on connection
     * keep-alive. These two functions can run on different threads
     * without locking.
     */
    private volatile long lastRxMillis;

    /*
     * This variable is written on data transmission and read on connection
     * keep-alive. These two functions can run on different threads but
     * require locking.
     */
    private long lastTxMillis;

    private long testRequestTxMillis;

    private final long heartbeatMillis;

    private final long testRequestMillis;

    private final FIXMessageParser parser;

    private final FIXConnectionStatusListener statusListener;

    private final FIXMessage adminMessage;

    private long currentTimeMillis;

    private final FIXTimestamp currentTime;

    private final FIXValue currentTimestamp;

    /**
     * Create a connection. The underlying channel can be either blocking or
     * non-blocking.
     *
     * @param channel the underlying channel
     * @param config the connection configuration
     * @param listener the inbound message listener
     * @param statusListener the inbound status event listener
     * @param currentTimeMillis the current time in milliseconds
     * @param <CHANNEL> the underlying channel type, which must implement
     *   {@link ReadableByteChannel} and {@link GatheringByteChannel}
     * @see SocketChannel
     */
    public <CHANNEL extends ReadableByteChannel & GatheringByteChannel>
    FIXConnection(CHANNEL channel, FIXConfig config, FIXMessageListener listener,
            FIXConnectionStatusListener statusListener, long currentTimeMillis) {
        this(channel, channel, config, listener, statusListener, currentTimeMillis);
    }

    /**
     * Create a connection. The underlying channel can be either blocking or
     * non-blocking.
     *
     * <p><strong>Note.</strong> When using this constructor, the inbound
     * message listener will be invoked for all incoming messages, including
     * all administrative messages. The application is responsible for handling
     * these appropriately. At the very least, it must increment the incoming
     * MsgSeqNum(34) value.</p>
     *
     * @param channel the underlying channel
     * @param config the connection configuration
     * @param listener the inbound message listener
     * @param currentTimeMillis the current time in milliseconds
     * @param <CHANNEL> the underlying channel type, which must implement
     *   {@link ReadableByteChannel} and {@link GatheringByteChannel}
     * @see SocketChannel
     * @see #incrementInMsgSeqNum
     */
    public <CHANNEL extends ReadableByteChannel & GatheringByteChannel>
    FIXConnection(CHANNEL channel, FIXConfig config, FIXMessageListener listener, long currentTimeMillis) {
        this(channel, channel, config, listener, null, currentTimeMillis);
    }

    /**
     * Create a connection. The underlying channels can be either blocking or
     * non-blocking.
     *
     * @param rxChannel the underlying channel for receiving
     * @param txChannel the underlying channel for transmitting (can be the
     *   same instance as {@code rxChannel})
     * @param config the connection configuration
     * @param listener the inbound message listener
     * @param statusListener the inbound status event listener
     * @param currentTimeMillis the current time in milliseconds
     */
    public FIXConnection(ReadableByteChannel rxChannel, GatheringByteChannel txChannel,
            FIXConfig config, FIXMessageListener listener, FIXConnectionStatusListener statusListener,
            long currentTimeMillis) {
        this.rxChannel = rxChannel;
        this.txChannel = txChannel;

        this.config = config;

        this.bodyLength = new FIXValue(BODY_LENGTH_FIELD_CAPACITY);
        this.checkSum   = new FIXValue(CHECK_SUM_FIELD_CAPACITY);

        this.senderCompId = config.getSenderCompID();
        this.targetCompId = config.getTargetCompID();

        if (statusListener != null)
            listener = new FIXConnectionStatusHandler(config, this, listener, statusListener);

        this.parser = new FIXMessageParser(config, listener);

        this.statusListener = statusListener;

        this.inMsgSeqNum = config.getInMsgSeqNum();
        this.outMsgSeqNum = config.getOutMsgSeqNum();

        this.rxBuffer = ByteBuffer.allocateDirect(config.getRxBufferCapacity());

        this.txHeaderBuffer = ByteBuffer.allocateDirect(config.getTxBufferCapacity());

        this.txHeaderBuffer.put(BEGIN_STRING_BYTES);
        this.txHeaderBuffer.put(config.getBeginString());
        this.txHeaderBuffer.put(SOH);
        this.txHeaderBuffer.put(BODY_LENGTH_BYTES);

        this.bodyLengthOffset = this.txHeaderBuffer.position();

        this.txBodyBuffer = ByteBuffer.allocateDirect(config.getTxBufferCapacity());

        this.txBuffers = new ByteBuffer[2];

        this.txBuffers[0] = txHeaderBuffer;
        this.txBuffers[1] = txBodyBuffer;

        this.lastRxMillis = currentTimeMillis;
        this.lastTxMillis = currentTimeMillis;

        this.heartbeatMillis = config.getHeartBtInt() * 1000;

        this.testRequestMillis = config.getHeartBtInt() * 1100;

        this.testRequestTxMillis = 0;

        this.adminMessage = new FIXMessage(ADMIN_MESSAGE_CAPACITY, config.getFieldCapacity());

        this.currentTimeMillis = currentTimeMillis;

        this.currentTime = new FIXTimestamp();
        this.currentTime.setEpochMilli(currentTimeMillis);

        this.currentTimestamp = new FIXValue(CURRENT_TIMESTAMP_FIELD_CAPACITY);

        this.currentTimestamp.setTimestampMillis(this.currentTime);
    }

    /**
     * Create a connection. The underlying channels can be either blocking or
     * non-blocking.
     *
     * <p><strong>Note.</strong> When using this constructor, the inbound
     * message listener will be invoked for all incoming messages, including
     * all administrative messages. The application is responsible for handling
     * these appropriately. At the very least, it must increment the incoming
     * MsgSeqNum(34) value.</p>
     *
     * @param rxChannel the underlying channel for receiving
     * @param txChannel the underlying channel for transmitting (can be the
     *   same instance as {@code rxChannel})
     * @param config the connection configuration
     * @param listener the inbound message listener
     * @param currentTimeMillis the current time in milliseconds
     * @see #incrementInMsgSeqNum
     */
    public FIXConnection(ReadableByteChannel rxChannel, GatheringByteChannel txChannel,
            FIXConfig config, FIXMessageListener listener, long currentTimeMillis) {
        this(rxChannel, txChannel, config, listener, null, currentTimeMillis);
    }

    /**
     * Get the next incoming MsgSeqNum(34).
     *
     * @return the next incoming MsgSeqNum(34)
     */
    public long getInMsgSeqNum() {
        return inMsgSeqNum;
    }

    /**
     * Set the next incoming MsgSeqNum(34).
     *
     * @param inMsgSeqNum the next incoming MsgSeqNum(34)
     */
    public void setInMsgSeqNum(long inMsgSeqNum) {
        this.inMsgSeqNum = inMsgSeqNum;
    }

    /**
     * Increment the incoming MsgSeqNum(34).
     */
    public void incrementInMsgSeqNum() {
        inMsgSeqNum++;
    }

    /**
     * Get the next outgoing MsgSeqNum(34).
     *
     * @return the next outgoing MsgSeqNum(34)
     */
    public long getOutMsgSeqNum() {
        return outMsgSeqNum;
    }

    /**
     * Set the next outgoing MsgSeqNum(34).
     *
     * @param outMsgSeqNum the next outgoing MsgSeqNum(34)
     */
    public void setOutMsgSeqNum(long outMsgSeqNum) {
        this.outMsgSeqNum = outMsgSeqNum;
    }

    /**
     * Get the SenderCompID(49).
     *
     * @return the SenderCompID(49)
     */
    public String getSenderCompID() {
        return senderCompId;
    }

    /**
     * Set the SenderCompID(49).
     *
     * @param senderCompId the SenderCompID(49)
     */
    public void setSenderCompID(String senderCompId) {
        this.senderCompId = senderCompId;
    }

    /**
     * Get the TargetCompID(56).
     *
     * @return the TargetCompID(56)
     */
    public String getTargetCompID() {
        return targetCompId;
    }

    /**
     * Set the TargetCompID(56).
     *
     * @param targetCompId the TargetCompID(56).
     */
    public void setTargetCompID(String targetCompId) {
        this.targetCompId = targetCompId;
    }

    /**
     * Create a message container.
     *
     * @return a message container
     */
    public FIXMessage create() {
        return new FIXMessage(config);
    }

    /**
     * <p>Prepare a message. When preparing a message, the following mandatory
     * fields are added:</p>
     *
     * <ul>
     *   <li>MsgType(35)</li>
     *   <li>SenderCompID(49)</li>
     *   <li>TargetCompID(56)</li>
     *   <li>MsgSeqNum(34)</li>
     *   <li>SendingTime(52)</li>
     * </ul>
     *
     * @param message a message
     * @param msgType the MsgType(35)
     */
    public void prepare(FIXMessage message, char msgType) {
        message.reset();

        message.addField(MsgType).setChar(msgType);

        prepare(message);
    }

    /**
     * <p>Prepare a message.</p>
     *
     * @param message a message
     * @param msgType the MsgType(35)
     * @see #prepare(FIXMessage, char)
     */
    public void prepare(FIXMessage message, CharSequence msgType) {
        message.reset();

        message.addField(MsgType).setString(msgType);

        prepare(message);
    }

    private void prepare(FIXMessage message) {
        message.addField(SenderCompID).setString(senderCompId);
        message.addField(TargetCompID).setString(targetCompId);
        message.addField(MsgSeqNum).setInt(outMsgSeqNum);
        message.addField(SendingTime).set(currentTimestamp);
    }

    /**
     * <p>Update a message. When updating a message, the following mandatory
     * fields are updated:</p>
     *
     * <ul>
     *   <li>MsgSeqNum(34)</li>
     *   <li>SendingTime(52)</li>
     * </ul>
     *
     * @param message a message
     * @throws NullPointerException if MsgSeqNum(34) or SendingTime(52) is
     *   not found
     */
    public void update(FIXMessage message) {
        message.valueOf(MsgSeqNum).setInt(outMsgSeqNum);
        message.valueOf(SendingTime).set(currentTimestamp);
    }

    /**
     * <p>Set the current time in milliseconds. It is used for the following
     * purposes:</p>
     *
     * <ul>
     *   <li>SendingTime(52)</li>
     *   <li>the connection keep-alive mechanism</li>
     * </ul>
     *
     * @param currentTimeMillis the current time in milliseconds
     */
    public void setCurrentTimeMillis(long currentTimeMillis) {
        this.currentTimeMillis = currentTimeMillis;

        currentTime.setEpochMilli(currentTimeMillis);

        currentTimestamp.setTimestampMillis(currentTime);
    }

    /**
     * Get the current time in milliseconds.
     *
     * @return the current time milliseconds
     * @see #setCurrentTimeMillis
     */
    public long getCurrentTimeMillis() {
        return currentTimeMillis;
    }

    /**
     * Get the current timestamp.
     *
     * @return the current timestamp
     */
    public CharSequence getCurrentTimestamp() {
        return currentTimestamp;
    }

    /**
     * Keep this connection alive.
     *
     * <p>If the duration indicated by HeartBtInt(108) has passed since
     * sending a message, send a Heartbeat(0) message.</p>
     *
     * <p>If the duration indicated by HeartBtInt(108) amended with a
     * reasonable transmission time has passed since receiving a message,
     * send a TestRequest(1) message.</p>
     *
     * <p>If a TestRequest(1) message has been sent and no data has been
     * received within the duration indicated by HeartBtInt(108) amended with
     * a reasonable transmission time, throw an exception indicating
     * heartbeat timeout.</p>
     *
     * @throws FIXHeartbeatTimeoutException if no data has been received within
     *   the duration indicated by Heartbeat(108) amended with a reasonable
     *   transmission time since sending a TestRequest(1) message
     * @throws IOException if an I/O error occurs
     */
    public void keepAlive() throws FIXHeartbeatTimeoutException, IOException {
        if (currentTimeMillis - lastTxMillis > heartbeatMillis)
            sendHeartbeat();

        if (testRequestTxMillis == 0) {
            if (currentTimeMillis - lastRxMillis > testRequestMillis) {
                sendTestRequest(currentTimestamp);

                testRequestTxMillis = currentTimeMillis;
            }
        } else {
            if (currentTimeMillis - testRequestTxMillis > testRequestMillis) {
                testRequestTxMillis = 0;

                heartbeatTimeout();
            }
        }
    }

    /**
     * Close the underlying channels.
     *
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void close() throws IOException {
        try (Closeable closingRx = rxChannel; Closeable closingTx = txChannel) {
        }
    }

    /**
     * Receive data from the underlying channel. For each message received,
     * invoke the message listener if applicable.
     *
     * @return the number of bytes read, possibly zero, or -1 if the channel
     *   has reached end-of-stream
     * @throws IOException if an I/O error occurs
     */
    public int receive() throws IOException {
        int bytes = rxChannel.read(rxBuffer);

        if (bytes <= 0)
            return bytes;

        rxBuffer.flip();

        while (parser.parse(rxBuffer));

        rxBuffer.compact();

        if (rxBuffer.position() == rxBuffer.capacity())
            tooLongMessage();

        lastRxMillis = currentTimeMillis;

        testRequestTxMillis = 0;

        return bytes;
    }

    /**
     * Send a message.
     *
     * @param message a message
     * @throws IOException if an I/O error occurs
     */
    public void send(FIXMessage message) throws IOException {
        txBodyBuffer.clear();
        message.put(txBodyBuffer);

        bodyLength.setInt(txBodyBuffer.position());

        txHeaderBuffer.clear();
        txHeaderBuffer.position(bodyLengthOffset);
        bodyLength.put(txHeaderBuffer);

        checkSum.setCheckSum(FIXCheckSums.sum(txHeaderBuffer, 0, txHeaderBuffer.position()) +
                FIXCheckSums.sum(txBodyBuffer, 0, txBodyBuffer.position()));

        txBodyBuffer.put(CHECK_SUM_BYTES);
        checkSum.put(txBodyBuffer);

        txHeaderBuffer.flip();
        txBodyBuffer.flip();

        int remaining = txHeaderBuffer.remaining() + txBodyBuffer.remaining();

        do {
            remaining -= txChannel.write(txBuffers, 0, 2);
        } while (remaining > 0);

        outMsgSeqNum++;

        lastTxMillis = currentTimeMillis;
    }

    /**
     * Send a Reject(3) message.
     *
     * @param refSeqNum the RefSeqNum(45)
     * @param sessionRejectReason the SessionRejectReason(373)
     * @param text the Text(58)
     * @throws IOException if an I/O error occurs
     */
    public void sendReject(long refSeqNum, long sessionRejectReason, CharSequence text) throws IOException {
        prepare(adminMessage, Reject);

        adminMessage.addField(RefSeqNum).setInt(refSeqNum);
        adminMessage.addField(SessionRejectReason).setInt(sessionRejectReason);
        adminMessage.addField(Text).setString(text);

        send(adminMessage);
    }

    /**
     * Send a Logout(5) message.
     *
     * @throws IOException if an I/O error occurs
     */
    public void sendLogout() throws IOException {
        prepare(adminMessage, Logout);

        send(adminMessage);
    }

    /**
     * Send a Logout(5) message.
     *
     * @param text the Text(58)
     * @throws IOException if an I/O error occurs
     */
    public void sendLogout(CharSequence text) throws IOException {
        prepare(adminMessage, Logout);

        adminMessage.addField(Text).setString(text);

        send(adminMessage);
    }

    /**
     * Send a Logon(A) message. Set EncryptMethod(98) to 0 and HeartBtInt(108)
     * according to the connection configuration.
     *
     * @param resetSeqNum if true set ResetSeqNumFlag(141) to true, otherwise
     *   omit ResetSeqNumFlag(141)
     * @throws IOException if an I/O error occurs
     */
    public void sendLogon(boolean resetSeqNum) throws IOException {
        prepare(adminMessage, Logon);

        adminMessage.addField(EncryptMethod).setInt(0);
        adminMessage.addField(HeartBtInt).setInt(config.getHeartBtInt());

        if (resetSeqNum)
            adminMessage.addField(ResetSeqNumFlag).setBoolean(true);

        send(adminMessage);
    }

    /**
     * Send a ResendRequest(2) message.
     *
     * @param beginSeqNo the BeginSeqNo(7)
     * @throws IOException if an I/O error occurs
     */
    public void sendResendRequest(long beginSeqNo) throws IOException {
        prepare(adminMessage, ResendRequest);

        adminMessage.addField(BeginSeqNo).setInt(beginSeqNo);
        adminMessage.addField(EndSeqNo).setInt(0);

        send(adminMessage);
    }

    private void sendHeartbeat() throws IOException {
        prepare(adminMessage, Heartbeat);

        send(adminMessage);
    }

    private void sendTestRequest(FIXValue testReqId) throws IOException {
        prepare(adminMessage, TestRequest);

        adminMessage.addField(TestReqID).set(testReqId);

        send(adminMessage);
    }

    private static void heartbeatTimeout() throws FIXHeartbeatTimeoutException {
        throw new FIXHeartbeatTimeoutException("Heartbeat timeout");
    }

    private static void tooLongMessage() throws FIXMessageOverflowException {
        throw new FIXMessageOverflowException("Too long message");
    }

}
