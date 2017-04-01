package com.paritytrading.philadelphia;

import static com.paritytrading.philadelphia.FIXTags.*;

import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ReadOnlyBufferException;

/**
 * A message container.
 */
public class FIXMessage {

    private FIXField fields[];

    private int count;

    /**
     * Construct a new message container.
     *
     * @param maxFieldCount the maximum number of fields
     * @param fieldCapacity the field capacity
     */
    public FIXMessage(int maxFieldCount, int fieldCapacity) {
        fields = new FIXField[maxFieldCount];

        for (int i = 0; i < fields.length; i++)
            fields[i] = new FIXField(fieldCapacity);

        count = 0;
    }

    /**
     * Get the MsgType(35).
     *
     * @return the MsgType(35) or <code>null</code> if the field is not
     *   present
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
     * Get a field.
     *
     * @param index the index
     * @return the field
     * @throws IndexOutOfBoundsException if the index exceeds the maximum
     *   number of fields
     */
    public FIXField getField(int index) {
        return fields[index];
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
     * @return the value container or <code>null</code> if there are no
     *   instances of a field with the specified tag
     */
    public FIXValue findField(int tag) {
        for (int i = 0; i < count; i++) {
            if (fields[i].getTag() == tag)
                return fields[i].getValue();
        }

        return null;
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
        FIXField field = fields[count++];

        field.setTag(tag);

        return field.getValue();
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
            if (count == fields.length)
                throw new FIXMessageOverflowException("Too many fields");

            if (!fields[count++].get(buffer))
                return false;
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
        for (int i = 0; i < count; i++)
            fields[i].put(buffer);
    }

}
