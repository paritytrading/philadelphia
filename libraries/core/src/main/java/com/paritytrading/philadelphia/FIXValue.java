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
import java.nio.charset.StandardCharsets;
import org.joda.time.MutableDateTime;
import org.joda.time.ReadableDateTime;

/**
 * A value container.
 */
public class FIXValue {

    private final ByteBuffer bytes;

    private int offset;
    private int length;

    /**
     * Construct a new value container.
     *
     * @param capacity the capacity
     */
    public FIXValue(int capacity) {
        bytes = ByteBuffer.allocateDirect(capacity);

        bytes.put(0, SOH);

        offset = 0;
        length = 0;
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
        return bytes.get(offset + index);
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
        this.bytes.position(this.offset);
        this.bytes.get(bytes, 0, this.length);
    }

    /**
     * Reset the value.
     */
    public void reset() {
        bytes.reset();
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

        bytes.put(value.bytes);
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

        return bytes.get(offset) == YES;
    }

    /**
     * Set the value to a boolean.
     *
     * @param b a boolean
     */
    public void setBoolean(boolean b) {
        bytes.put(0, b ? YES : NO);
        bytes.put(1, SOH);
        
        offset = 0;
        length = 1;
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

        return (char)bytes.get(offset);
    }

    /**
     * Set the value to a character.
     *
     * @param c a character
     */
    public void setChar(char c) {
        bytes.put(0, (byte)c);
        bytes.put(1, SOH);

        offset = 0;
        length = 1;
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

        if (bytes.get(i) == '-') {
            negative = true;

            i++;
        }

        long value = 0;

        while (i < offset + length) {
            byte b = bytes.get(i++);

            if (b < '0' || b > '9')
                notInt();

            value = 10 * value + b - '0';
        }

        return negative ? -value : +value;
    }

    /**
     * Set the value to an integer.
     *
     * @param i an integer
     */
    public void setInt(long i) {
        bytes.put(bytes.limit() - 1, SOH);

        long j = Math.abs(i); //TODO: maybe another to do this faster

        int k = bytes.limit() - 2;

        do {
            bytes.put(k--, (byte)('0' + j % 10));

            j /= 10;
        } while (j > 0);

        if (i < 0)
            bytes.put(k--, (byte)('-'));

        offset = k + 1;
        length = bytes.limit() - 1 - offset;
    }

    /**
     * Get the value as a float.
     *
     * @return the value as a float
     * @throws FIXValueFormatException if the value is not a float
     */
    public double asFloat() {
        long   value  = 0;
        double factor = 0.0;

        long sign  = bytes.get(offset) == '-' ? -1 : +1;
        int  start = sign < 0 ? offset + 1 : offset;

        for (int i = start; i < offset + length; i++) {
            byte b = bytes.get(i);

            if (b < '0' || b > '9') {
                if (factor == 0.0 && b == '.') {
                    factor = 1.0;
                    continue;
                }

                notFloat();
            }

            value   = 10 * value + b - '0';
            factor *= 10;
        }

        return sign * (factor > 0.0 ? value / factor : value);
    }

    /**
     * Set the value to a float.
     *
     * @param f a float
     * @param decimals the number of decimals
     */
    public void setFloat(double f, int decimals) {
        long i = Math.round(Longs.POWERS_OF_TEN[decimals] * Math.abs(f));

        bytes.put(bytes.limit() - 1, SOH);

        int j = bytes.limit() - 2;

        for (int k = 0; k < decimals; k++) {
            bytes.put(j--, (byte)('0' + i % 10));

            i /= 10;
        }

        if (decimals > 0)
            bytes.put(j--, (byte)'.');

        do {
            bytes.put(j--, (byte)('0' + i % 10));

            i /= 10;
        } while (i > 0);

        if (f < 0)
            bytes.put(j--, (byte)'-');

        offset = j + 1;
        length = bytes.limit() - 1 - offset;
    }

    /**
     * Get the value as a string.
     *
     * @return the value as a string
     */
    public String asString() {
        bytes.position(offset);
        bytes.limit(offset + length);
        return StandardCharsets.US_ASCII.decode(bytes.slice()).toString();
    }

    /**
     * Get the value as a string. The value is appended to the provided
     * string builder.
     *
     * @param s a string builder
     */
    public void asString(StringBuilder s) {
        for (int i = 0; i < length; i++)
            s.append((char)bytes.get(offset + i));
    }

    /**
     * Set the value to a string.
     *
     * @param s a string
     * @throws IndexOutOfBoundsException if the string is too long
     */
    public void setString(CharSequence s) {
        offset = 0;
        length = s.length();

        for (int i = 0; i < length; i++)
            bytes.put(i, (byte)s.charAt(i));

        bytes.put(length, SOH);
    }

    /**
     * Get the value as a date.
     *
     * @param d a date
     * @throws FIXValueFormatException if the value is not a date
     */
    public void asDate(MutableDateTime d) {
        if (length != 8)
            notDate();

        int year        = getDigits(4, offset + 0);
        int monthOfYear = getDigits(2, offset + 4);
        int dayOfMonth  = getDigits(2, offset + 6);

        d.setDateTime(year, monthOfYear, dayOfMonth, 0, 0, 0, 0);
    }

    /**
     * Set the value to a date.
     *
     * @param d a date
     */
    public void setDate(ReadableDateTime d) {
        setDigits(d.getYear(), 0, 4);
        setDigits(d.getMonthOfYear(), 4, 2);
        setDigits(d.getDayOfMonth(), 6, 2);
        bytes.put(8, SOH);

        length = 8;
        offset = 0;
    }

    /**
     * Get the value as a time only.
     *
     * @param t a time only
     * @throws FIXValueFormatException if the value is not a time only
     */
    public void asTimeOnly(MutableDateTime t) {
        if (length != 8 && length != 12)
            notTimeOnly();

        t.setHourOfDay(getDigits(2, offset + 0));
        t.setMinuteOfHour(getDigits(2, offset + 3));
        t.setSecondOfMinute(getDigits(2, offset + 6));
        t.setMillisOfSecond(length == 12 ? getDigits(3, offset + 9) : 0);
    }

    /**
     * Set the value to a time only.
     *
     * @param t a time only
     * @param millis if true set milliseconds, otherwise do not set milliseconds
     */
    public void setTimeOnly(ReadableDateTime t, boolean millis) {
        setDigits(t.getHourOfDay(), 0, 2);
        bytes.put(2, (byte)':');
        setDigits(t.getMinuteOfHour(), 3, 2);
        bytes.put(5, (byte)':');
        setDigits(t.getSecondOfMinute(), 6, 2);

        if (millis) {
            bytes.put(8, (byte)'.');
            setDigits(t.getMillisOfSecond(), 9, 3);
            bytes.put(12, SOH);

            length = 12;
        } else {
            bytes.put(8, SOH);

            length = 8;
        }

        offset = 0;
    }

    /**
     * Get the value as a timestamp.
     *
     * @param t a timestamp
     * @throws FIXValueFormatException if the value is not a timestamp
     */
    public void asTimestamp(MutableDateTime t) {
        if (length != 17 && length != 21)
            notTimestamp();

        int year           = getDigits(4, offset + 0);
        int monthOfYear    = getDigits(2, offset + 4);
        int dayOfMonth     = getDigits(2, offset + 6);
        int hourOfDay      = getDigits(2, offset + 9);
        int minuteOfHour   = getDigits(2, offset + 12);
        int secondOfMinute = getDigits(2, offset + 15);
        int millisOfSecond = length == 21 ? getDigits(3, offset + 18) : 0;

        t.setDateTime(year, monthOfYear, dayOfMonth, hourOfDay, minuteOfHour,
                secondOfMinute, millisOfSecond);
    }

    /**
     * Set the value to a timestamp.
     *
     * @param t a timestamp
     * @param millis if true set milliseconds, otherwise do not set milliseconds
     */
    public void setTimestamp(ReadableDateTime t, boolean millis) {
        setDigits(t.getYear(), 0, 4);
        setDigits(t.getMonthOfYear(), 4, 2);
        setDigits(t.getDayOfMonth(), 6, 2);
        bytes.put(8, (byte)'-');
        setDigits(t.getHourOfDay(), 9, 2);
        bytes.put(11, (byte)':');
        setDigits(t.getMinuteOfHour(), 12, 2);
        bytes.put(14, (byte)':');
        setDigits(t.getSecondOfMinute(), 15, 2);

        if (millis) {
            bytes.put(17, (byte)'.');
            setDigits(t.getMillisOfSecond(), 18, 3);
            bytes.put(21, SOH);

            length = 21;
        } else {
            bytes.put(17, SOH);

            length = 17;
        }

        offset = 0;
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
     * @param c a checksum
     */
    public void setCheckSum(long c) {
        setDigits(c & 0xff, 0, 3);
        bytes.put(3, SOH);

        offset = 0;
        length = 3;
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
        bytes.position(0);
        while (buffer.hasRemaining()) {
            byte b = buffer.get();
            bytes.put(b);

            if (b == SOH) {
                bytes.position(0);
                return true;
            }

            if (++length == bytes.limit())
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
        bytes.limit(offset + length + 1);
        ByteBuffer r = bytes.position(offset).slice();
        buffer.put(r);
        bytes.position(0);
    }

    private int getDigits(int digits, int offset) {
        int value = 0;

        for (int i = offset; i < offset + digits; i++) {
            byte b = bytes.get(i);

            if (b < '0' || b > '9')
                notDigit();

            value = 10 * value + b - '0';
        }

        return value;
    }

    private void setDigits(long l, int offset, int digits) {
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
