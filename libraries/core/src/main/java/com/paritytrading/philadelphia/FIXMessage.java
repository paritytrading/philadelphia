/*
 * Copyright 2015 Philadelphia authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.paritytrading.philadelphia;

import static com.paritytrading.philadelphia.FIXTags.*;

import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ReadOnlyBufferException;
import java.util.stream.Stream;

/**
 * A message container.
 */
public class FIXMessage {

    private final int[] tags;

    private final FIXValue[] values;

    private int count;

    /**
     * Construct a new message container.
     *
     * @param config the message configuration
     */
    public FIXMessage(FIXConfig config) {
        this(config.getMaxFieldCount(), config.getFieldCapacity());
    }

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
        return valueOf(MsgType);
    }

    /**
     * Get the MsgSeqNum(34).
     *
     * @return the MsgSeqNum(34) or zero if the field is not present
     */
    public long getMsgSeqNum() {
        FIXValue msgSeqNum = valueOf(MsgSeqNum);

        return msgSeqNum != null ? msgSeqNum.asInt() : 0;
    }

    /**
     * Get the tag at a specified index.
     *
     * @param index the index
     * @return the tag
     * @throws IndexOutOfBoundsException if the index exceeds the maximum
     *   number of fields
     */
    public int tagAt(int index) {
        return tags[index];
    }

    /**
     * Get the value container at a specified index.
     *
     * @param index the index
     * @return the value container
     * @throws IndexOutOfBoundsException if the index exceeds the maximum
     *   number of fields
     */
    public FIXValue valueAt(int index) {
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
     * Set the number of fields.
     *
     * @param count the number of fields
     */
    public void setFieldCount(int count) {
        this.count = count;
    }

    /**
     * Get the value container of the first instance of a field with the
     * specified tag.
     *
     * @param tag the tag
     * @return the value container or {@code null} if there are no instances
     *   of a field with the specified tag
     */
    public FIXValue valueOf(int tag) {
        for (int i = 0; i < count; i++) {
            if (tags[i] == tag)
                return values[i];
        }

        return null;
    }

    /**
     * Get the value container of the first instance of a field with the
     * specified tag, starting at the specified index.
     *
     * @param tag the tag
     * @param fromIndex the index to start the search from
     * @return the value container or {@code null} if there are no instances
     *   of a field with the specified tag
     */
    public FIXValue valueOf(int tag, int fromIndex) {
        for (; fromIndex < count; fromIndex++) {
            if (tags[fromIndex] == tag)
                return values[fromIndex];
        }

        return null;
    }

    /**
     * Get the index of the first instance of a field with the specified tag.
     *
     * @param tag the tag
     * @return the index or -1 if there are no instances of a field with the
     *   specified tag
     */
    public int indexOf(int tag) {
        for (int i = 0; i < count; i++) {
            if (tags[i] == tag)
                return i;
        }

        return -1;
    }

    /**
     * Get the index of the first instance of a field with the specified tag,
     * starting at the specified index.
     *
     * @param tag the tag
     * @param fromIndex the index to start the search from
     * @return the index or -1 if there are no instances of a field with the
     *   specified tag
     */
    public int indexOf(int tag, int fromIndex) {
        for (; fromIndex < count; fromIndex++) {
            if (tags[fromIndex] == tag)
                return fromIndex;
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
                tooManyFields();

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
     * Construct a new message container from a string representation.
     *
     * <p><strong>Note.</strong> This method allocates memory.</p>
     *
     * @param s a string representation
     * @return a message container
     */
    public static FIXMessage fromString(String s) {
        String[][] fields = Stream.of(s.split("\\|"))
                .map(field -> field.split("="))
                .toArray(String[][]::new);

        int maxValueLength = Stream.of(fields)
                .mapToInt(field -> field[1].length())
                .max()
                .orElse(0);

        FIXMessage message = new FIXMessage(fields.length, maxValueLength + 1);

        for (String[] field : fields) {
            int    tag   = Integer.parseInt(field[0]);
            String value = field[1];

            message.addField(tag).setString(value);
        }

        return message;
    }

    /**
     * Returns a string representation of this message.
     *
     * <p><strong>Note.</strong> This method allocates memory.</p>
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

    private static void tooManyFields() throws FIXMessageOverflowException {
        throw new FIXMessageOverflowException("Too many fields");
    }

}
