package com.paritytrading.philadelphia;

/**
 * Indicates that the number of fields exceeds the capacity of a message container.
 */
public class FIXMessageOverflowException extends FIXException {

    /**
     * Construct an instance with the specified detail message.
     *
     * @param message the detail message
     */
    public FIXMessageOverflowException(String message) {
        super(message);
    }

}
