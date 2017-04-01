package com.paritytrading.philadelphia;

import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;

/**
 * Utilities for working with checksums.
 */
public class FIXCheckSums {

    private FIXCheckSums() {
    }

    /**
     * Return the sum of bytes in a buffer.
     *
     * @param buffer a buffer
     * @param offset the offset
     * @param length the length
     * @return the sum of bytes in the buffer
     * @throws BufferUnderflowException if the length from the offset exceeds
     *   the limit of the buffer
     */
    public static long sum(ByteBuffer buffer, int offset, int length) {
        long sum = 0;

        for (int i = offset; i < offset + length; i++)
            sum += buffer.get(i);

        return sum;
    }

}
