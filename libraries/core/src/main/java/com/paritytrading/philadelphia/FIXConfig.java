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

/**
 * A connection configuration.
 *
 * @see Builder
 */
public class FIXConfig {

    private final FIXVersion version;
    private final String     senderCompId;
    private final String     targetCompId;
    private final int        heartBtInt;
    private final long       incomingMsgSeqNum;
    private final long       outgoingMsgSeqNum;
    private final int        maxFieldCount;
    private final int        fieldCapacity;
    private final int        rxBufferCapacity;
    private final int        txBufferCapacity;
    private final boolean    checkSumEnabled;

    /**
     * Create a connection configuration.
     *
     * @param version the protocol version
     * @param senderCompId the SenderCompID(49)
     * @param targetCompId the TargetCompID(56)
     * @param heartBtInt the HeartBtInt(108)
     * @param incomingMsgSeqNum the incoming MsgSeqNum(34)
     * @param outgoingMsgSeqNum the outgoing MsgSeqNum(34)
     * @param maxFieldCount the maximum number of fields in a message
     * @param fieldCapacity the field capacity
     * @param rxBufferCapacity the receive buffer capacity
     * @param txBufferCapacity the transmit buffer capacity
     * @param checkSumEnabled the incoming CheckSum(10) check status
     * @see Builder
     */
    public FIXConfig(FIXVersion version, String senderCompId,
            String targetCompId, int heartBtInt,
            long incomingMsgSeqNum, long outgoingMsgSeqNum,
            int maxFieldCount, int fieldCapacity, int rxBufferCapacity,
            int txBufferCapacity, boolean checkSumEnabled) {
        this.version           = version;
        this.senderCompId      = senderCompId;
        this.targetCompId      = targetCompId;
        this.heartBtInt        = heartBtInt;
        this.incomingMsgSeqNum = incomingMsgSeqNum;
        this.outgoingMsgSeqNum = outgoingMsgSeqNum;
        this.maxFieldCount     = maxFieldCount;
        this.fieldCapacity     = fieldCapacity;
        this.rxBufferCapacity  = rxBufferCapacity;
        this.txBufferCapacity  = txBufferCapacity;
        this.checkSumEnabled   = checkSumEnabled;
    }

    /**
     * Get the protocol version.
     *
     * @return the protocol version
     */
    public FIXVersion getVersion() {
        return version;
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
    public long getIncomingMsgSeqNum() {
        return incomingMsgSeqNum;
    }

    /**
     * Get the outgoing MsgSeqNum(34).
     *
     * @return the outgoing MsgSeqNum(34)
     */
    public long getOutgoingMsgSeqNum() {
        return outgoingMsgSeqNum;
    }

    /**
     * Get the maximum number of fields in a message.
     *
     * @return the maximum number of fields in a message
     */
    public int getMaxFieldCount() {
        return maxFieldCount;
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
        return "FIXConfig{" +
                "version=" + version +
                ", senderCompId='" + senderCompId + '\'' +
                ", targetCompId='" + targetCompId + '\'' +
                ", heartBtInt=" + heartBtInt +
                ", incomingMsgSeqNum=" + incomingMsgSeqNum +
                ", outgoingMsgSeqNum=" + outgoingMsgSeqNum +
                ", maxFieldCount=" + maxFieldCount +
                ", fieldCapacity=" + fieldCapacity +
                ", rxBufferCapacity=" + rxBufferCapacity +
                ", txBufferCapacity=" + txBufferCapacity +
                ", checkSumEnabled=" + checkSumEnabled +
                '}';
    }

    /**
     * <p>A connection configuration builder. The builder uses the following
     * default values:</p>
     * <ul>
     *   <li>protocol version: FIX 4.2</li>
     *   <li>SenderCompID(49): empty</li>
     *   <li>TargetCompID(56): empty</li>
     *   <li>HeartBtInt(108): 30</li>
     *   <li>incoming MsgSeqNum(34): 1</li>
     *   <li>outgoing MsgSeqNum(34): 1</li>
     *   <li>maximum number of fields in a message: 64</li>
     *   <li>field capacity: 64</li>
     *   <li>receive buffer capacity: 1024</li>
     *   <li>transmit buffer capacity: 1024</li>
     *   <li>incoming CheckSum(10) check status: enabled</li>
     * </ul>
     */
    public static class Builder {

        private FIXVersion version;
        private String     senderCompId;
        private String     targetCompId;
        private int        heartBtInt;
        private long       incomingMsgSeqNum;
        private long       outgoingMsgSeqNum;
        private int        maxFieldCount;
        private int        fieldCapacity;
        private int        rxBufferCapacity;
        private int        txBufferCapacity;
        private boolean    checkSumEnabled;

        /**
         * Create a connection configuration builder.
         */
        public Builder() {
            version           = FIXVersion.FIX_4_2;
            senderCompId      = "";
            targetCompId      = "";
            heartBtInt        = 30;
            incomingMsgSeqNum = 1;
            outgoingMsgSeqNum = 1;
            maxFieldCount     = 64;
            fieldCapacity     = 64;
            rxBufferCapacity  = 1024;
            txBufferCapacity  = 1024;
            checkSumEnabled   = true;
        }

        /**
         * Set the protocol version.
         *
         * @param version the protocol version
         * @return this instance
         */
        public Builder setVersion(FIXVersion version) {
            this.version = version;

            return this;
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
         * @param incomingMsgSeqNum the incoming MsgSeqNum(34)
         * @return this instance
         */
        public Builder setIncomingMsgSeqNum(long incomingMsgSeqNum) {
            this.incomingMsgSeqNum = incomingMsgSeqNum;

            return this;
        }

        /**
         * Set the outgoing MsgSeqNum(34).
         *
         * @param outgoingMsgSeqNum the outgoing MsgSeqNum(34)
         * @return this instance
         */
        public Builder setOutgoingMsgSeqNum(long outgoingMsgSeqNum) {
            this.outgoingMsgSeqNum = outgoingMsgSeqNum;

            return this;
        }

        /**
         * Set the maximum number of fields in a message.
         *
         * @param maxFieldCount the maximum number of fields in a message
         * @return this instance
         */
        public Builder setMaxFieldCount(int maxFieldCount) {
            this.maxFieldCount = maxFieldCount;

            return this;
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
            return new FIXConfig(version, senderCompId, targetCompId,
                    heartBtInt, incomingMsgSeqNum, outgoingMsgSeqNum,
                    maxFieldCount, fieldCapacity, rxBufferCapacity,
                    txBufferCapacity, checkSumEnabled);
        }

    }

}
