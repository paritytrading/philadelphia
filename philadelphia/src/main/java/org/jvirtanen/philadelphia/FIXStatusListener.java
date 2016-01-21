package org.jvirtanen.philadelphia;

import java.io.IOException;

/**
 * The interface for inbound status events.
 */
public interface FIXStatusListener {

    /**
     * Receive an indication to close the connection.
     *
     * @param session the Session
     * @param message a detail message
     * @throws IOException if an I/O error occurs
     */
    void close(FIXSession session, String message) throws IOException;

    /**
     * Receive an indication of a sequence reset.
     *
     * @param session the Session
     * @throws IOException if an I/O error occurs
     */
    void sequenceReset(FIXSession session) throws IOException;

    /**
     * Receive an indication of a message with too low MsgSeqNum(34) and
     * without PossDupFlag(43) or with PossDupFlag(43) set to false.
     *
     * @param session the Session
     * @param receivedMsgSeqNum the received MsgSeqNum(34)
     * @param expectedMsgSeqNum the expected MsgSeqNum(34)
     * @throws IOException if an I/O error occurs
     */
    void tooLowMsgSeqNum(FIXSession session, long receivedMsgSeqNum, long expectedMsgSeqNum) throws IOException;

    /**
     * Receive an indication of a heartbeat timeout.
     *
     * @param session the Session
     * @throws IOException if an I/O error occurs
     */
    void heartbeatTimeout(FIXSession session) throws IOException;

    /**
     * Receive a Reject(3) message.
     *
     * @param session the Session
     * @param message the Reject(3) message
     * @throws IOException if an I/O error occurs
     */
    void reject(FIXSession session, FIXMessage message) throws IOException;

    /**
     * Receive a Logon(A) message.
     *
     * @param session the Session
     * @param message the Logon(A) message
     * @throws IOException if an I/O error occurs
     */
    void logon(FIXSession session, FIXMessage message) throws IOException;

    /**
     * Receive a Logout(5) message.
     *
     * @param session the Session
     * @param message the Logout(5) message
     * @throws IOException if an I/O error occurs
     */
    void logout(FIXSession session, FIXMessage message) throws IOException;

}
