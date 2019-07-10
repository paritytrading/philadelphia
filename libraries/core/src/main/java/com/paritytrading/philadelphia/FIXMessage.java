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
import static com.paritytrading.philadelphia.FIX.*;

import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ReadOnlyBufferException;
import java.nio.charset.StandardCharsets;
import java.util.stream.Stream;
import org.joda.time.MutableDateTime;
import org.joda.time.ReadableDateTime;

/**
 * A message container.
 */
public class FIXMessage {

    private final FIXValue[] values;
    private final ByteBuffer outgoingBuf;
    private int count;

    /**
     * Construct a new message container.
     *
     * @param maxFieldCount the maximum number of fields
     * @param fieldCapacity the field capacity
     */
    public FIXMessage(int maxFieldCount, int fieldCapacity) {

        values = new FIXValue[maxFieldCount];

        for (int i = 0; i < values.length; i++)
            values[i] = new FIXValue(fieldCapacity);

        outgoingBuf = ByteBuffer.allocateDirect(maxFieldCount * fieldCapacity);

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
        return values[index].getTag();
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
            if (values[i].getTag() == tag)
                return values[i];
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
            if (values[i].getTag() == tag)
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
        return values[count++].setTag(tag);
    }

    public void addBoolean(int tag, boolean x) {
        FIXTags.put(outgoingBuf, tag);
        FIXValue.setBoolean(outgoingBuf, x);
    }

    public void addChar(int tag, char x) {
        FIXTags.put(outgoingBuf, tag);
        FIXValue.setChar(outgoingBuf, x);
    }

    public void addInt(int tag, long x) {
        FIXTags.put(outgoingBuf, tag);
        ByteBuffer buf = outgoingBuf.slice();
        FIXValue.setInt(buf, x);
        buf.compact();
        int pos = outgoingBuf.position();
        outgoingBuf.position(pos + buf.position());
    }

    public void addFloat(int tag, double x, int decimals) {
        FIXTags.put(outgoingBuf, tag);
        ByteBuffer buf = outgoingBuf.slice();
        FIXValue.setFloat(buf, x, decimals);
        buf.compact();
        int pos = outgoingBuf.position();
        outgoingBuf.position(pos + buf.position());
    }

    public void addString(int tag, CharSequence x) {
        FIXTags.put(outgoingBuf, tag);
        FIXValue.setString(outgoingBuf, x);
    }

    public void addDate(int tag, ReadableDateTime x) {
        FIXTags.put(outgoingBuf, tag);
        ByteBuffer buf = outgoingBuf.slice();
        FIXValue.setDate(buf, x);
        int pos = outgoingBuf.position();
        outgoingBuf.position(pos + buf.position());       
    }

    public void addTimeOnly(int tag, ReadableDateTime x, boolean millis) {
        FIXTags.put(outgoingBuf, tag);
        ByteBuffer buf = outgoingBuf.slice();
        FIXValue.setTimeOnly(buf, x, millis);
        int pos = outgoingBuf.position();
        outgoingBuf.position(pos + buf.position());  
    }

    public void addTimestamp(int tag, ReadableDateTime x, boolean millis) {
        FIXTags.put(outgoingBuf, tag);
        ByteBuffer buf = outgoingBuf.slice();
        FIXValue.setTimestamp(buf, x, millis);
        int pos = outgoingBuf.position();
        outgoingBuf.position(pos + buf.position());  
    }

    public void addCheckSum(int tag, long x) {
        FIXTags.put(outgoingBuf, tag);
        ByteBuffer buf = outgoingBuf.slice();
        FIXValue.setCheckSum(buf, x);
        int pos = outgoingBuf.position();
        outgoingBuf.position(pos + buf.position());  
    }

    public void addValue(int tag, FIXValue value) {
        FIXTags.put(outgoingBuf, tag);
        value.put(outgoingBuf);
    }

    /**
     * Reset this message container.
     */
    public void reset() {
        count = 0;
        outgoingBuf.clear();
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
            if (count == values.length)
                tooManyFields();

            int tag = FIXTags.get(buffer);
            if (tag == 0)
                return false;

            values[count].setTag(tag);

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
        if (count == 0) {
            outgoingBuf.flip();
            buffer.put(outgoingBuf);
            outgoingBuf.rewind();
        } else {
            for (int i = 0; i < count; i++) {
                FIXTags.put(buffer, values[i].getTag());
                values[i].put(buffer);
            }
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
            builder.append(values[i].getTag());
            builder.append('=');
            values[i].asString(builder);
            builder.append('|');
        }
        if (count == 0 && outgoingBuf.position() != 0) {
            outgoingBuf.flip();
            while (outgoingBuf.hasRemaining()) {
                byte b = outgoingBuf.get();
                if (b == SOH)
                    builder.append("|");
                else
                    builder.append((char)b);
            }
        }
    }

    private static void tooManyFields() throws FIXMessageOverflowException {
        throw new FIXMessageOverflowException("Too many fields");
    }

}
