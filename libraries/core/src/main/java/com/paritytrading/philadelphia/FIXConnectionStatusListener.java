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

import java.io.IOException;

/**
 * The interface for inbound status events.
 */
public interface FIXConnectionStatusListener {

    /**
     * Receive an indication to close the connection.
     *
     * @param connection the connection
     * @param message a detail message
     * @throws IOException if an I/O error occurs
     */
    void close(FIXConnection connection, String message) throws IOException;

    /**
     * Receive an indication of a sequence reset.
     *
     * @param connection the connection
     * @throws IOException if an I/O error occurs
     */
    void sequenceReset(FIXConnection connection) throws IOException;

    /**
     * Receive an indication of a message with too low MsgSeqNum(34) and
     * without PossDupFlag(43) or with PossDupFlag(43) set to false.
     *
     * @param connection the connection
     * @param receivedMsgSeqNum the received MsgSeqNum(34)
     * @param expectedMsgSeqNum the expected MsgSeqNum(34)
     * @throws IOException if an I/O error occurs
     */
    void tooLowMsgSeqNum(FIXConnection connection, long receivedMsgSeqNum, long expectedMsgSeqNum) throws IOException;

    /**
     * Receive an indication of a heartbeat timeout.
     *
     * @param connection the connection
     * @throws IOException if an I/O error occurs
     */
    void heartbeatTimeout(FIXConnection connection) throws IOException;

    /**
     * Receive a Reject(3) message.
     *
     * @param connection the connection
     * @param message the Reject(3) message
     * @throws IOException if an I/O error occurs
     */
    void reject(FIXConnection connection, FIXMessage message) throws IOException;

    /**
     * Receive a Logon(A) message.
     *
     * @param connection the connection 
     * @param message the Logon(A) message
     * @throws IOException if an I/O error occurs
     */
    void logon(FIXConnection connection, FIXMessage message) throws IOException;

    /**
     * Receive a Logout(5) message.
     *
     * @param connection the connection 
     * @param message the Logout(5) message
     * @throws IOException if an I/O error occurs
     */
    void logout(FIXConnection connection, FIXMessage message) throws IOException;

}
