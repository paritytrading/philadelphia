package com.paritytrading.philadelphia;

import java.io.IOException;

/**
 * The interface for inbound messages.
 */
public interface FIXMessageListener {

    /**
     * Receive a message.
     *
     * @param message a message
     * @throws IOException if an I/O error occurs
     */
    public void message(FIXMessage message) throws IOException;

}
