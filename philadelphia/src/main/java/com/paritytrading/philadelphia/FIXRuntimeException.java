package com.paritytrading.philadelphia;

/**
 * Indicates a runtime error.
 */
public class FIXRuntimeException extends RuntimeException {

    /**
     * Construct an instance with the specified detail message.
     *
     * @param message the detail message
     */
    public FIXRuntimeException(String message) {
        super(message);
    }

}
