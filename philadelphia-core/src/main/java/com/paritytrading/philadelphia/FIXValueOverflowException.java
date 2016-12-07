package com.paritytrading.philadelphia;

/**
 * Indicates that the length of a value exceeds the capacity of a value
 * container.
 */
public class FIXValueOverflowException extends FIXException {

    /**
     * Construct an instance with the specified detail message.
     *
     * @param message the detail message
     */
    public FIXValueOverflowException(String message) {
        super(message);
    }

}
