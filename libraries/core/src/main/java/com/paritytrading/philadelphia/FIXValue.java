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

import static com.paritytrading.philadelphia.FIX.*;
import static java.nio.charset.StandardCharsets.*;

import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ReadOnlyBufferException;
import org.joda.time.MutableDateTime;
import org.joda.time.ReadableDateTime;

/**
 * A value container.
 */
public class FIXValue {

    private final byte[] bytes;

    private int tag;
    private int offset;
    private int length;

    /**
     * Construct a new value container.
     *
     * @param capacity the capacity
     */
    public FIXValue(int capacity) {
        bytes = new byte[capacity];

        bytes[0] = SOH;

        offset = 0;
        length = 0;
        tag = 0;
    }

    public FIXValue setTag(int tag) {
        this.tag = tag;
        return this;
    }

    public int getTag() {
        return tag;
    }

    /**
     * Get the byte at the specified index. The index must be between 0 and
     * the length of the value - 1.
     *
     * @param index the index
     * @return the byte at the specified index
     * @throws IndexOutOfBoundsException if the index is outside of this
     *   value container
     */
    public byte byteAt(int index) {
        return bytes[offset + index];
    }

    /**
     * Get the length of the value.
     *
     * @return the length of the value
     */
    public int length() {
        return length;
    }

    /**
     * Copy the value to a byte array.
     *
     * @param bytes a byte array
     * @throws IndexOutOfBoundsException if the length of the value is greater
     *     than the length of the byte array
     */
    public void copyTo(byte[] bytes) {
        System.arraycopy(this.bytes, this.offset, bytes, 0, this.length);
    }

    /**
     * Reset the value.
     */
    public void reset() {
        length = 0;
    }

    /**
     * Set the value.
     *
     * @param value a value container
     */
    public void set(FIXValue value) {
        offset = value.offset;
        length = value.length;

        System.arraycopy(value.bytes, offset, bytes, offset, length + 1);
    }

    /**
     * Get the value as a boolean.
     *
     * @return the value as a boolean
     * @throws FIXValueFormatException if the value is not a boolean
     */
    public boolean asBoolean() {
        if (length != 1)
            notBoolean();

        return bytes[offset] == YES;
    }

    /**
     * Set the value to a boolean.
     *
     * @param x a boolean
     */
    public void setBoolean(boolean x) {
        bytes[0] = x ? YES : NO;
        bytes[1] = SOH;

        offset = 0;
        length = 1;
    }

    /**
     * Set the value to a boolean.
     *
     * @param x a boolean
     */
    public static void setBoolean(ByteBuffer bytes, boolean x) {
        bytes.put(x ? YES : NO);
        bytes.put(SOH);
    }

    /**
     * Get the value as a character.
     *
     * @return the value as a character
     * @throws FIXValueFormatException if the value is not a character
     */
    public char asChar() {
        if (length != 1)
            notChar();

        return (char)bytes[offset];
    }

    /**
     * Set the value to a character.
     *
     * @param x a character
     */
    public void setChar(char x) {
        bytes[0] = (byte)x;
        bytes[1] = SOH;

        offset = 0;
        length = 1;
    }

    /**
     * Set the value to a character.
     *
     * @param x a character
     */
    public static void setChar(ByteBuffer bytes, char x) {
        bytes.put((byte)x);
        bytes.put(SOH);
    }

    /**
     * Get the value as an integer.
     *
     * @return the value as an integer
     * @throws FIXValueFormatException if the value is not an integer
     */
    public long asInt() {
        boolean negative = false;

        int i = offset;

        if (bytes[i] == '-') {
            negative = true;

            i++;
        }

        long x = 0;

        while (i < offset + length) {
            byte b = bytes[i++];

            if (b < '0' || b > '9')
                notInt();

            x = 10 * x + b - '0';
        }

        return negative ? -x : +x;
    }

    /**
     * Set the value to an integer.
     *
     * @param x an integer
     */
    public void setInt(long x) {
        bytes[bytes.length - 1] = SOH;

        long y = Math.abs(x);

        int i = bytes.length - 2;

        do {
            bytes[i--] = (byte)('0' + y % 10);

            y /= 10;
        } while (y > 0);

        if (x < 0)
            bytes[i--] = '-';

        offset = i + 1;
        length = bytes.length - 1 - offset;
    }

    /**
     * Set the value to an integer.
     *
     * @param i an integer
     */
    public static void setInt(ByteBuffer bytes, long x) {
        bytes.put(bytes.limit() - 1, SOH);

        long y = Math.abs(x);

        int i = bytes.limit() - 2;

        do {
            bytes.put(i--, (byte)('0' + y % 10));

            y /= 10;
        } while (y > 0);

        if (x < 0)
            bytes.put(i--, (byte)('-'));

        bytes.position(i + 1);
    }

    /**
     * Get the value as a float.
     *
     * @return the value as a float
     * @throws FIXValueFormatException if the value is not a float
     */
    public double asFloat() {
        long x = 0;

        double factor = 0.0;

        long sign  = bytes[offset] == '-' ? -1 : +1;
        int  start = sign < 0 ? offset + 1 : offset;

        for (int i = start; i < offset + length; i++) {
            byte b = bytes[i];

            if (b < '0' || b > '9') {
                if (factor == 0.0 && b == '.') {
                    factor = 1.0;
                    continue;
                }

                notFloat();
            }

            x = 10 * x + b - '0';

            factor *= 10;
        }

        return sign * (factor > 0.0 ? x / factor : x);
    }

    /**
     * Set the value to a float.
     *
     * @param x a float
     * @param decimals the number of decimals
     */
    public void setFloat(double x, int decimals) {
        long y = Math.round(Longs.POWERS_OF_TEN[decimals] * Math.abs(x));

        bytes[bytes.length - 1] = SOH;

        int i = bytes.length - 2;

        for (int j = 0; j < decimals; j++) {
            bytes[i--] = (byte)('0' + y % 10);

            y /= 10;
        }

        if (decimals > 0)
            bytes[i--] = '.';

        do {
            bytes[i--] = (byte)('0' + y % 10);

            y /= 10;
        } while (y > 0);

        if (x < 0)
            bytes[i--] = '-';

        offset = i + 1;
        length = bytes.length - 1 - offset;
    }

    /**
     * Set the value to a float.
     *
     * @param f a float
     * @param decimals the number of decimals
     */
    public static void setFloat(ByteBuffer bytes, double x, int decimals) {
        long y = Math.round(Longs.POWERS_OF_TEN[decimals] * Math.abs(x));

        bytes.put(bytes.limit() - 1, SOH);

        int i = bytes.limit() - 2;

        for (int j = 0; j < decimals; j++) {
            bytes.put(i--, (byte)('0' + y % 10));

            y /= 10;
        }

        if (decimals > 0)
            bytes.put(i--, (byte)'.');

        do {
            bytes.put(i--, (byte)('0' + y % 10));

            y /= 10;
        } while (y > 0);

        if (x < 0)
            bytes.put(i--, (byte)'-');

        bytes.position(i + 1);
    }
    
    /**
     * Get the value as a string.
     *
     * @return the value as a string
     */
    public String asString() {
        return new String(bytes, offset, length, US_ASCII);
    }

    /**
     * Get the value as a string. The value is appended to the provided
     * string builder.
     *
     * @param x a string builder
     */
    public void asString(StringBuilder x) {
        for (int i = 0; i < length; i++)
            x.append((char)bytes[offset + i]);
    }

    /**
     * Set the value to a string.
     *
     * @param x a string
     * @throws IndexOutOfBoundsException if the string is too long
     */
    public void setString(CharSequence x) {
        offset = 0;
        length = x.length();

        for (int i = 0; i < length; i++)
            bytes[i] = (byte)x.charAt(i);

        bytes[length] = SOH;
    }

   /**
     * Set the value to a string.
     *
     * @param s a string
     * @throws IndexOutOfBoundsException if the string is too long
     */
    public static void setString(ByteBuffer bytes, CharSequence x) {
        for (int i = 0; i < x.length(); i++)
            bytes.put((byte)x.charAt(i));

        bytes.put(SOH);
    }


    /**
     * Get the value as a date.
     *
     * @param x a date
     * @throws FIXValueFormatException if the value is not a date
     */
    public void asDate(MutableDateTime x) {
        if (length != 8)
            notDate();

        x.setYear(getDigits(4, offset + 0));
        x.setMonthOfYear(getDigits(2, offset + 4));
        x.setDayOfMonth(getDigits(2, offset + 6));
    }

    /**
     * Set the value to a date.
     *
     * @param x a date
     */
    public void setDate(ReadableDateTime x) {
        setDigits(x.getYear(), 0, 4);
        setDigits(x.getMonthOfYear(), 4, 2);
        setDigits(x.getDayOfMonth(), 6, 2);
        bytes[8] = SOH;

        length = 8;
        offset = 0;
    }

    /**
     * Set the value to a date.
     *
     * @param d a date
     */
    public static void setDate(ByteBuffer bytes, ReadableDateTime x) {
        setDigits(bytes, x.getYear(), 0, 4);
        setDigits(bytes, x.getMonthOfYear(), 4, 2);
        setDigits(bytes, x.getDayOfMonth(), 6, 2);

        bytes.put(8, SOH);

        bytes.position(9);
    }


    /**
     * Get the value as a time only.
     *
     * @param x a time only
     * @throws FIXValueFormatException if the value is not a time only
     */
    public void asTimeOnly(MutableDateTime x) {
        if (length != 8 && length != 12)
            notTimeOnly();

        x.setHourOfDay(getDigits(2, offset + 0));
        x.setMinuteOfHour(getDigits(2, offset + 3));
        x.setSecondOfMinute(getDigits(2, offset + 6));
        x.setMillisOfSecond(length == 12 ? getDigits(3, offset + 9) : 0);
    }

    /**
     * Set the value to a time only.
     *
     * @param x a time only
     * @param millis if true set milliseconds, otherwise do not set milliseconds
     */
    public void setTimeOnly(ReadableDateTime x, boolean millis) {
        setDigits(x.getHourOfDay(), 0, 2);
        bytes[2] = ':';
        setDigits(x.getMinuteOfHour(), 3, 2);
        bytes[5] = ':';
        setDigits(x.getSecondOfMinute(), 6, 2);

        if (millis) {
            bytes[8] = '.';
            setDigits(x.getMillisOfSecond(), 9, 3);
            bytes[12] = SOH;

            length = 12;
        } else {
            bytes[8] = SOH;

            length = 8;
        }

        offset = 0;
    }

    /**
     * Set the value to a time only.
     *
     * @param t a time only
     * @param millis if true set milliseconds, otherwise do not set milliseconds
     */
    public static void setTimeOnly(ByteBuffer bytes, ReadableDateTime t, boolean millis) {
        setDigits(bytes, t.getHourOfDay(), 0, 2);
        bytes.put(2, (byte)':');
        setDigits(bytes, t.getMinuteOfHour(), 3, 2);
        bytes.put(5, (byte)':');
        setDigits(bytes, t.getSecondOfMinute(), 6, 2);

        if (millis) {
            bytes.put(8, (byte)'.');
            setDigits(bytes, t.getMillisOfSecond(), 9, 3);
            bytes.put(12, SOH);
            bytes.position(13);
        } else {
            bytes.put(8, SOH);
            bytes.position(9);
        }
    }

    /**
     * Get the value as a timestamp.
     *
     * @param x a timestamp
     * @throws FIXValueFormatException if the value is not a timestamp
     */
    public void asTimestamp(MutableDateTime x) {
        if (length != 17 && length != 21)
            notTimestamp();

        x.setYear(getDigits(4, offset + 0));
        x.setMonthOfYear(getDigits(2, offset + 4));
        x.setDayOfMonth(getDigits(2, offset + 6));
        x.setHourOfDay(getDigits(2, offset + 9));
        x.setMinuteOfHour(getDigits(2, offset + 12));
        x.setSecondOfMinute(getDigits(2, offset + 15));
        x.setMillisOfSecond(length == 21 ? getDigits(3, offset + 18) : 0);
    }

    /**
     * Set the value to a timestamp.
     *
     * @param x a timestamp
     * @param millis if true set milliseconds, otherwise do not set milliseconds
     */
    public void setTimestamp(ReadableDateTime x, boolean millis) {
        setDigits(x.getYear(), 0, 4);
        setDigits(x.getMonthOfYear(), 4, 2);
        setDigits(x.getDayOfMonth(), 6, 2);
        bytes[8] = '-';
        setDigits(x.getHourOfDay(), 9, 2);
        bytes[11] = ':';
        setDigits(x.getMinuteOfHour(), 12, 2);
        bytes[14] = ':';
        setDigits(x.getSecondOfMinute(), 15, 2);

        if (millis) {
            bytes[17] = '.';
            setDigits(x.getMillisOfSecond(), 18, 3);
            bytes[21] = SOH;

            length = 21;
        } else {
            bytes[17] = SOH;

            length = 17;
        }

        offset = 0;
    }

    /**
     * Set the value to a timestamp.
     *
     * @param t a timestamp
     * @param millis if true set milliseconds, otherwise do not set milliseconds
     */
    public static void setTimestamp(ByteBuffer bytes,  ReadableDateTime t, boolean millis) {
        setDigits(bytes, t.getYear(), 0, 4);
        setDigits(bytes, t.getMonthOfYear(), 4, 2);
        setDigits(bytes, t.getDayOfMonth(), 6, 2);
        bytes.put(8, (byte)'-');
        setDigits(bytes, t.getHourOfDay(), 9, 2);
        bytes.put(11, (byte)':');
        setDigits(bytes, t.getMinuteOfHour(), 12, 2);
        bytes.put(14, (byte)':');
        setDigits(bytes, t.getSecondOfMinute(), 15, 2);

        if (millis) {
            bytes.put(17, (byte)'.');
            setDigits(bytes, t.getMillisOfSecond(), 18, 3);
            bytes.put(21, SOH);

            bytes.position(22);
        } else {
            bytes.put(17, SOH);

            bytes.position(18);
        }

    }

    /**
     * Get the value as a checksum.
     *
     * @return the value as a checksum
     * @throws FIXValueFormatException if the value is not an integer
     */
    public long asCheckSum() {
        return asInt();
    }

    /**
     * Set the value to a checksum.
     *
     * @param x a checksum
     */
    public void setCheckSum(long x) {
        setDigits(x & 0xff, 0, 3);
        bytes[3] = SOH;

        offset = 0;
        length = 3;
    }

    /**
     * Set the value to a checksum.
     *
     * @param c a checksum
     */
    public static void setCheckSum(ByteBuffer bytes, long c) {
        setDigits(bytes, c & 0xff, 0, 3);
        bytes.put(3, SOH);

        bytes.position(4);
    }

    /**
     * Read this value from a buffer.
     *
     * @param buffer a buffer
     * @throws FIXValueOverflowException if the length of the value exceeds
     *   the capacity of this value container
     * @return true if a value was successfully read from the buffer, otherwise
     *   false
     */
    public boolean get(ByteBuffer buffer) throws FIXValueOverflowException {
        offset = 0;
        length = 0;

        while (buffer.hasRemaining()) {
            byte b = buffer.get();

            bytes[length] = b;

            if (b == SOH)
                return true;

            if (++length == bytes.length)
                tooLongValue();
        }

        return false;
    }

    /**
     * Write this value to a buffer.
     *
     * @param buffer a buffer
     * @throws BufferOverflowException if there are fewer bytes remaining in
     *   the buffer than what this value consists of
     * @throws ReadOnlyBufferException if the buffer is read-only
     */
    public void put(ByteBuffer buffer) {
        buffer.put(bytes, offset, length + 1);
    }

    private int getDigits(int digits, int offset) {
        int value = 0;

        for (int i = offset; i < offset + digits; i++) {
            byte b = bytes[i];

            if (b < '0' || b > '9')
                notDigit();

            value = 10 * value + b - '0';
        }

        return value;
    }

    private void setDigits(long l, int offset, int digits) {
        for (int i = offset + digits - 1; i >= offset; i--) {
            bytes[i] = (byte)('0' + l % 10);

            l /= 10;
        }
    }

    private static void setDigits(ByteBuffer bytes, long l, int offset, int digits) {
        for (int i = offset + digits - 1; i >= offset; i--) {
            bytes.put(i, (byte)('0' + l % 10));

            l /= 10;
        }
    }

    private static void notBoolean() throws FIXValueFormatException {
        throw new FIXValueFormatException("Not a boolean");
    }

    private static void notChar() throws FIXValueFormatException {
        throw new FIXValueFormatException("Not a character");
    }

    private static void notDate() throws FIXValueFormatException {
        throw new FIXValueFormatException("Not a date");
    }

    private static void notDigit() throws FIXValueFormatException {
        throw new FIXValueFormatException("Not a digit");
    }

    private static void notFloat() throws FIXValueFormatException {
        throw new FIXValueFormatException("Not a float");
    }

    private static void notInt() throws FIXValueFormatException {
        throw new FIXValueFormatException("Not an integer");
    }

    private static void notTimeOnly() throws FIXValueFormatException {
        throw new FIXValueFormatException("Not a time only");
    }

    private static void notTimestamp() throws FIXValueFormatException {
        throw new FIXValueFormatException("Not a timestamp");
    }

    private static void tooLongValue() throws FIXValueOverflowException {
        throw new FIXValueOverflowException("Too long value");
    }

}
