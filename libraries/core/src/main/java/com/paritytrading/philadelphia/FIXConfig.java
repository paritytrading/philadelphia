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

import static java.nio.charset.StandardCharsets.*;

/**
 * A connection configuration.
 *
 * @see #newBuilder
 */
public class FIXConfig {

    /**
     * The default BeginString(8): "FIX.4.2".
     */
    public static final byte[] DEFAULT_BEGIN_STRING = FIXVersion.FIX_4_2.getBeginString().getBytes(US_ASCII);

    /**
     * The default SenderCompID(49): "".
     */
    public static final String DEFAULT_SENDER_COMP_ID = "";

    /**
     * The default TargetCompID(56): "".
     */
    public static final String DEFAULT_TARGET_COMP_ID = "";

    /**
     * The default HeartBtInt(108): 30.
     */
    public static final int DEFAULT_HEART_BT_INT = 30;

    /**
     * The default incoming MsgSeqNum(34): 1.
     */
    public static final int DEFAULT_IN_MSG_SEQ_NUM = 1;

    /**
     * The default outgoing MsgSeqNum(34): 1.
     */
    public static final int DEFAULT_OUT_MSG_SEQ_NUM = 1;

    /**
     * The default minimum message capacity: 64.
     */
    public static final int DEFAULT_MIN_MESSAGE_CAPACITY = 64;

    /**
     * The default maximum message capacity: 65536.
     */
    public static final int DEFAULT_MAX_MESSAGE_CAPACITY = 65536;

    /**
     * The default maximum number of fields: 65536.
     */
    @Deprecated
    public static final int DEFAULT_MAX_FIELD_COUNT = DEFAULT_MAX_MESSAGE_CAPACITY;

    /**
     * The default field capacity: 64.
     */
    public static final int DEFAULT_FIELD_CAPACITY = 64;

    /**
     * The default receive buffer capacity: 1 KiB.
     */
    public static final int DEFAULT_RX_BUFFER_CAPACITY = 1024;

    /**
     * The default transmit buffer capacity: 1 KiB.
     */
    public static final int DEFAULT_TX_BUFFER_CAPACITY = 1024;

    /**
     * The default incoming CheckSum(10) check status: enabled.
     */
    public static final boolean DEFAULT_CHECK_SUM_ENABLED = true;

    /**
     * The default connection configuration.
     */
    public static final FIXConfig DEFAULTS = newBuilder().build();

    private final byte[]  beginString;
    private final String  senderCompId;
    private final String  targetCompId;
    private final int     heartBtInt;
    private final long    inMsgSeqNum;
    private final long    outMsgSeqNum;
    private final int     minMessageCapacity;
    private final int     maxMessageCapacity;
    private final int     fieldCapacity;
    private final int     rxBufferCapacity;
    private final int     txBufferCapacity;
    private final boolean checkSumEnabled;

    /**
     * Create a connection configuration.
     *
     * @param beginString the BeginString(8)
     * @param senderCompId the SenderCompID(49)
     * @param targetCompId the TargetCompID(56)
     * @param heartBtInt the HeartBtInt(108)
     * @param inMsgSeqNum the incoming MsgSeqNum(34)
     * @param outMsgSeqNum the outgoing MsgSeqNum(34)
     * @param minMessageCapacity the initial message capacity
     * @param maxMessageCapacity the maximum message capacity
     * @param fieldCapacity the field capacity
     * @param rxBufferCapacity the receive buffer capacity
     * @param txBufferCapacity the transmit buffer capacity
     * @param checkSumEnabled the incoming CheckSum(10) check status
     * @see #newBuilder
     */
    public FIXConfig(byte[] beginString, String senderCompId,
            String targetCompId, int heartBtInt, long inMsgSeqNum,
            long outMsgSeqNum, int minMessageCapacity,
            int maxMessageCapacity, int fieldCapacity,
            int rxBufferCapacity, int txBufferCapacity,
            boolean checkSumEnabled) {
        this.beginString        = beginString;
        this.senderCompId       = senderCompId;
        this.targetCompId       = targetCompId;
        this.heartBtInt         = heartBtInt;
        this.inMsgSeqNum        = inMsgSeqNum;
        this.outMsgSeqNum       = outMsgSeqNum;
        this.minMessageCapacity = minMessageCapacity;
        this.maxMessageCapacity = maxMessageCapacity;
        this.fieldCapacity      = fieldCapacity;
        this.rxBufferCapacity   = rxBufferCapacity;
        this.txBufferCapacity   = txBufferCapacity;
        this.checkSumEnabled    = checkSumEnabled;
    }

    /**
     * Get the BeginString(8).
     *
     * @return the BeginString(8)
     */
    public byte[] getBeginString() {
        return beginString;
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
     * Get the TargetCompID(56).
     *
     * @return the TargetCompID(56)
     */
    public String getTargetCompID() {
        return targetCompId;
    }

    /**
     * Get the HeartBtInt(108).
     *
     * @return the HeartBtInt(108)
     */
    public int getHeartBtInt() {
        return heartBtInt;
    }

    /**
     * Get the incoming MsgSeqNum(34).
     *
     * @return the incoming MsgSeqNum(34)
     */
    public long getInMsgSeqNum() {
        return inMsgSeqNum;
    }

    /**
     * Get the outgoing MsgSeqNum(34).
     *
     * @return the outgoing MsgSeqNum(34)
     */
    public long getOutMsgSeqNum() {
        return outMsgSeqNum;
    }

    /**
     * Get the initial message capacity.
     *
     * @return the initial message capacity
     */
    public int getMinMessageCapacity() {
        return minMessageCapacity;
    }

    /**
     * Get the maximum message capacity.
     *
     * @return the maximum message capacity
     */
    public int getMaxMessageCapacity() {
        return maxMessageCapacity;
    }

    /**
     * Get the maximum number of fields in a message.
     *
     * @return the maximum number of fields in a message
     * @see #getMaxMessageCapacity
     */
    @Deprecated
    public int getMaxFieldCount() {
        return getMaxMessageCapacity();
    }

    /**
     * Get the field capacity.
     *
     * @return the field capacity
     */
    public int getFieldCapacity() {
        return fieldCapacity;
    }

    /**
     * Get the receive buffer capacity.
     *
     * @return the receive buffer capacity
     */
    public int getRxBufferCapacity() {
        return rxBufferCapacity;
    }

    /**
     * Get the transmit buffer capacity.
     *
     * @return the transmit buffer capacity
     */
    public int getTxBufferCapacity() {
        return txBufferCapacity;
    }

    /**
     * Get the incoming CheckSum(10) check status.
     *
     * @return true if the incoming CheckSum(10) check is enabled, otherwise
     *     false
     */
    public boolean isCheckSumEnabled() {
        return checkSumEnabled;
    }

    /**
     * Get the string representation of instance.
     *
     * @return string representation of instance.
     */
    @Override
    public String toString() {
        return new StringBuilder()
            .append("FIXConfig(")
            .append("beginString=\"").append(new String(beginString, US_ASCII)).append("\",")
            .append("senderCompId=\"").append(senderCompId).append("\",")
            .append("targetCompId=\"").append(targetCompId).append("\",")
            .append("heartBtInt=").append(heartBtInt).append(",")
            .append("inMsgSeqNum=").append(inMsgSeqNum).append(",")
            .append("outMsgSeqNum=").append(outMsgSeqNum).append(",")
            .append("minMessageCapacity=").append(minMessageCapacity).append(",")
            .append("maxMessageCapacity=").append(maxMessageCapacity).append(",")
            .append("fieldCapacity=").append(fieldCapacity).append(",")
            .append("rxBufferCapacity=").append(rxBufferCapacity).append(",")
            .append("txBufferCapacity=").append(txBufferCapacity).append(",")
            .append("checkSumEnabled=").append(checkSumEnabled)
            .append(")")
            .toString();
    }

    /**
     * Create a connection configuration builder.
     *
     * @return a connection configuration builder
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * A connection configuration builder.
     */
    public static class Builder {

        private byte[]  beginString;
        private String  senderCompId;
        private String  targetCompId;
        private int     heartBtInt;
        private long    inMsgSeqNum;
        private long    outMsgSeqNum;
        private int     minMessageCapacity;
        private int     maxMessageCapacity;
        private int     fieldCapacity;
        private int     rxBufferCapacity;
        private int     txBufferCapacity;
        private boolean checkSumEnabled;

        /**
         * Create a connection configuration builder.
         */
        public Builder() {
            beginString        = DEFAULT_BEGIN_STRING;
            senderCompId       = DEFAULT_SENDER_COMP_ID;
            targetCompId       = DEFAULT_TARGET_COMP_ID;
            heartBtInt         = DEFAULT_HEART_BT_INT;
            inMsgSeqNum        = DEFAULT_IN_MSG_SEQ_NUM;
            outMsgSeqNum       = DEFAULT_OUT_MSG_SEQ_NUM;
            minMessageCapacity = DEFAULT_MIN_MESSAGE_CAPACITY;
            maxMessageCapacity = DEFAULT_MAX_MESSAGE_CAPACITY;
            fieldCapacity      = DEFAULT_FIELD_CAPACITY;
            rxBufferCapacity   = DEFAULT_RX_BUFFER_CAPACITY;
            txBufferCapacity   = DEFAULT_TX_BUFFER_CAPACITY;
            checkSumEnabled    = DEFAULT_CHECK_SUM_ENABLED;
        }

        /**
         * Set the BeginString(8).
         *
         * @param beginString the BeginString(8)
         * @return this instance
         * @see #setVersion
         */
        public Builder setBeginString(byte[] beginString) {
            this.beginString = beginString;

            return this;
        }

        /**
         * Set the BeginString(8).
         *
         * @param beginString the BeginString(8)
         * @return this instance
         * @see #setVersion
         */
        public Builder setBeginString(String beginString) {
            return setBeginString(beginString.getBytes(US_ASCII));
        }

        /**
         * Set the protocol version.
         *
         * @param version the protocol version
         * @return this instance
         */
        public Builder setVersion(FIXVersion version) {
            return setBeginString(version.getBeginString());
        }

        /**
         * Set the SenderCompID(49).
         *
         * @param senderCompId the SenderCompID(49)
         * @return this instance
         */
        public Builder setSenderCompID(String senderCompId) {
            this.senderCompId = senderCompId;

            return this;
        }

        /**
         * Set the TargetCompID(56).
         *
         * @param targetCompId the TargetCompID(56)
         * @return this instance
         */
        public Builder setTargetCompID(String targetCompId) {
            this.targetCompId = targetCompId;

            return this;
        }

        /**
         * Set the HeartBtInt(108).
         *
         * @param heartBtInt the HeartBtInt(108)
         * @return this instance
         */
        public Builder setHeartBtInt(int heartBtInt) {
            this.heartBtInt = heartBtInt;

            return this;
        }

        /**
         * Set the incoming MsgSeqNum(34).
         *
         * @param inMsgSeqNum the incoming MsgSeqNum(34)
         * @return this instance
         */
        public Builder setInMsgSeqNum(long inMsgSeqNum) {
            this.inMsgSeqNum = inMsgSeqNum;

            return this;
        }

        /**
         * Set the outgoing MsgSeqNum(34).
         *
         * @param outMsgSeqNum the outgoing MsgSeqNum(34)
         * @return this instance
         */
        public Builder setOutMsgSeqNum(long outMsgSeqNum) {
            this.outMsgSeqNum = outMsgSeqNum;

            return this;
        }

        /**
         * Set the initial message capacity.
         *
         * @param minMessageCapacity the initial message capacity
         * @return this instance
         * @see #setMaxMessageCapacity
         * @see #setMessageCapacity
         */
        public Builder setMinMessageCapacity(int minMessageCapacity) {
            this.minMessageCapacity = minMessageCapacity;

            return this;
        }

        /**
         * Set the maximum message capacity.
         *
         * @param maxMessageCapacity the maximum message capacity
         * @return this instance
         * @see #setMinMessageCapacity
         * @see #setMessageCapacity
         */
        public Builder setMaxMessageCapacity(int maxMessageCapacity) {
            this.maxMessageCapacity = maxMessageCapacity;

            return this;
        }

        /**
         * Set both the initial message capacity and the maximum message
         * capacity.
         *
         * @param messageCapacity the initial as well as the maximum message
         *     capacity
         * @return this instance
         * @see #setMinMessageCapacity
         * @see #setMaxMessageCapacity
         */
        public Builder setMessageCapacity(int messageCapacity) {
            this.minMessageCapacity = messageCapacity;
            this.maxMessageCapacity = messageCapacity;

            return this;
        }

        /**
         * Set the maximum number of fields in a message.
         *
         * @param maxFieldCount the maximum number of fields in a message
         * @return this instance
         * @see #setMessageCapacity
         */
        @Deprecated
        public Builder setMaxFieldCount(int maxFieldCount) {
            return setMessageCapacity(maxFieldCount);
        }

        /**
         * Set the field capacity.
         *
         * @param fieldCapacity the field capacity
         * @return this instance
         */
        public Builder setFieldCapacity(int fieldCapacity) {
            this.fieldCapacity = fieldCapacity;

            return this;
        }

        /**
         * Set the receive buffer capacity.
         *
         * @param rxBufferCapacity the receive buffer capacity
         * @return this instance
         */
        public Builder setRxBufferCapacity(int rxBufferCapacity) {
            this.rxBufferCapacity = rxBufferCapacity;

            return this;
        }

        /**
         * Set the transmit buffer capacity.
         *
         * @param txBufferCapacity the transmit buffer capacity
         * @return this instance
         */
        public Builder setTxBufferCapacity(int txBufferCapacity) {
            this.txBufferCapacity = txBufferCapacity;

            return this;
        }

        /**
         * Set the incoming CheckSum(10) check status.
         *
         * @param checkSumEnabled if true, the incoming CheckSum(10) check is
         *     enabled, otherwise it is disabled
         * @return this instance
         */
        public Builder setCheckSumEnabled(boolean checkSumEnabled) {
            this.checkSumEnabled = checkSumEnabled;

            return this;
        }

        /**
         * Build the connection configuration.
         *
         * @return the connection configuration
         */
        public FIXConfig build() {
            return new FIXConfig(beginString, senderCompId, targetCompId,
                    heartBtInt, inMsgSeqNum, outMsgSeqNum, minMessageCapacity,
                    maxMessageCapacity, fieldCapacity, rxBufferCapacity,
                    txBufferCapacity, checkSumEnabled);
        }

    }

}
