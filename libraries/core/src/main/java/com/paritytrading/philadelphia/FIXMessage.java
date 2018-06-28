package com.paritytrading.philadelphia;

import static com.paritytrading.philadelphia.FIXTags.*;

import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ReadOnlyBufferException;

/**
 * A message container.
 */
public class FIXMessage {

    private int[] tags;

    private FIXValue[] values;

    private int count;

    /**
     * Construct a new message container.
     *
     * @param maxFieldCount the maximum number of fields
     * @param fieldCapacity the field capacity
     */
    public FIXMessage(int maxFieldCount, int fieldCapacity) {
        tags = new int[maxFieldCount];

        values = new FIXValue[maxFieldCount];

        for (int i = 0; i < values.length; i++)
            values[i] = new FIXValue(fieldCapacity);

        count = 0;
    }

    /**
     * Get the MsgType(35).
     *
     * @return the MsgType(35) or {@code null} if the field is not present
     */
    public FIXValue getMsgType() {
        return findField(MsgType);
    }

    /**
     * Get the MsgSeqNum(34).
     *
     * @return the MsgSeqNum(34) or zero if the field is not present
     */
    public long getMsgSeqNum() {
        FIXValue msgSeqNum = findField(MsgSeqNum);

        return msgSeqNum != null ? msgSeqNum.asInt() : 0;
    }

    /**
     * Get a tag.
     *
     * @param index the index
     * @return the tag
     * @throws IndexOutOfBoundsException if the index exceeds the maximum
     *   number of fields
     */
    public int getTag(int index) {
        return tags[index];
    }

    /**
     * Get a value container.
     *
     * @param index the index
     * @return the value container
     * @throws IndexOutOfBoundsException if the index exceeds the maximum
     *   number of fields
     */
    public FIXValue getValue(int index) {
        return values[index];
    }

    /**
     * Get the number of fields.
     *
     * @return the number of fields
     */
    public int getFieldCount() {
        return count;
    }

    /**
     * Get the value container of the first instance of a field with the
     * specified tag.
     *
     * @param tag the tag
     * @return the value container or {@code null} if there are no instances
     *   of a field with the specified tag
     */
    public FIXValue findField(int tag) {
        for (int i = 0; i < count; i++) {
            if (tags[i] == tag)
                return values[i];
        }

        return null;
    }

    /**
     * Get the index of the first instance of a field with the specified tag.
     *
     * @param tag the tag
     * @return the index or -1 if there are no instances
     *   of a field with the specified tag
     */
    public int findIndex(int tag) {
        for (int i = 0; i < count; i++) {
            if (tags[i] == tag)
                return i;
        }

        return -1;
    }

    /**
     * Add a field.
     *
     * @param tag the tag
     * @return the value container
     * @throws IndexOutOfBoundsException if maximum number of fields is
     *   exceeded
     */
    public FIXValue addField(int tag) {
        tags[count] = tag;

        return values[count++];
    }

    /**
     * Reset this message container.
     */
    public void reset() {
        count = 0;
    }

    /**
     * Read this message from a buffer.
     *
     * @param buffer a buffer
     * @return true if this message was successfully read from the buffer,
     *   otherwise false
     * @throws FIXMessageOverflowException if the number of fields exceeds the
     *   maximum number of fields
     * @throws FIXValueOverflowException if the length of a value exceeds the
     *   capacity of the value container
     */
    public boolean get(ByteBuffer buffer) throws FIXMessageOverflowException,
           FIXValueOverflowException {
        reset();

        while (buffer.hasRemaining()) {
            if (count == tags.length)
                throw new FIXMessageOverflowException("Too many fields");

            int tag = FIXTags.get(buffer);
            if (tag == 0)
                return false;

            tags[count] = tag;

            if (!values[count].get(buffer))
                return false;

            count++;
        }

        return true;
    }

    /**
     * Write this message to a buffer.
     *
     * @param buffer a buffer
     * @throws BufferOverflowException if there are fewer bytes remaining in
     *   the buffer than what this message consists of
     * @throws ReadOnlyBufferException if the buffer is read-only
     */
    public void put(ByteBuffer buffer) {
        for (int i = 0; i < count; i++) {
            FIXTags.put(buffer, tags[i]);

            values[i].put(buffer);
        }
    }

    /**
     * Returns a string representation of this message.
     *
     * @return a string representation of this message
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        toString(builder);

        return builder.toString();
    }

    /**
     * Appends a string representation of this message to the specified string
     * builder.
     *
     * @param builder a string builder
     */
    public void toString(StringBuilder builder) {
        for (int i = 0; i < count; i++) {
            builder.append(tags[i]);
            builder.append('=');
            values[i].asString(builder);
            builder.append('|');
        }
    }

}
