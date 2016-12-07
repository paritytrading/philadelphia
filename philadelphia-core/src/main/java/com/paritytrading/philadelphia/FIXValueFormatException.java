package com.paritytrading.philadelphia;

/**
 * Indicates that a value does not conform to a format.
 */
public class FIXValueFormatException extends FIXRuntimeException {

    /**
     * Construct an instance with the specified detail message.
     *
     * @param message the detail message
     */
    public FIXValueFormatException(String message) {
        super(message);
    }

}
