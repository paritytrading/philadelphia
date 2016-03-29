package com.paritytrading.philadelphia;

import java.io.IOException;

/**
 * Indicates an error.
 */
public class FIXException extends IOException {

    /**
     * Construct an instance with the specified detail message.
     *
     * @param message the detail message
     */
    public FIXException(String message) {
        super(message);
    }

}
