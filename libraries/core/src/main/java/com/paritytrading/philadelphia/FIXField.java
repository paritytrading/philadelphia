package com.paritytrading.philadelphia;

import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ReadOnlyBufferException;

/**
 * A field.
 */
public class FIXField {

    private int tag;

    private FIXValue value;

    /**
     * Construct a new field.
     *
     * @param capacity the capacity of the value container
     */
    public FIXField(int capacity) {
        tag = 0;

        value = new FIXValue(capacity);
    }

    /**
     * Get the tag.
     *
     * @return the tag
     */
    public int getTag() {
        return tag;
    }

    /**
     * Set the tag.
     *
     * @param tag the tag
     */
    public void setTag(int tag) {
        this.tag = tag;
    }

    /**
     * Get the value container.
     *
     * @return the value container
     */
    public FIXValue getValue() {
        return value;
    }

    /**
     * Read this field from a buffer.
     *
     * @param buffer a buffer
     * @throws FIXValueOverflowException if the length of the value exceeds
     *   the capacity of the value container
     * @return true if this field was successfully read from the buffer,
     *   otherwise false
     */
    public boolean get(ByteBuffer buffer) throws FIXValueOverflowException {
        tag = FIXTags.get(buffer);

        if (tag == 0)
            return false;

        return value.get(buffer);
    }

    /**
     * Write this field to a buffer.
     *
     * @param buffer a buffer
     * @throws BufferOverflowException if there are fewer bytes remaining in
     *   the buffer than what this field consists of
     * @throws ReadOnlyBufferException if the buffer is read-only
     */
    public void put(ByteBuffer buffer) {
        if (value.length() > 0) {
            FIXTags.put(buffer, tag);

            value.put(buffer);
        }
    }

}
