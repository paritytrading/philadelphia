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

import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ReadOnlyBufferException;
import org.joda.time.MutableDateTime;
import org.joda.time.ReadableDateTime;

/**
 * A value container.
 */
public class FIXValue {

    private static final double POWERS_OF_TEN[] = {
        1e0,
        1e1,
        1e2,
        1e3,
        1e4,
        1e5,
        1e6,
        1e7,
        1e8,
        1e9,
        1e10,
        1e11,
        1e12,
        1e13,
        1e14,
        1e15,
        1e16,
        1e17,
    };

    private final byte[] bytes;

    private final int end;

    private int offset;
    private int length;

    /**
     * Construct a new value container.
     *
     * @param capacity the capacity
     */
    public FIXValue(int capacity) {
        bytes = new byte[capacity];

        end = capacity;

        bytes[0] = SOH;

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
     * Compare the string representation of this value to the specified
     * character.
     *
     * @param x the character to compare the string representation of this
     *   value against
     * @return true if this value represents the same string as the specified
     *   character, otherwise false
     */
    public boolean contentEquals(byte x) {
        return length == 1 && bytes[offset] == x;
    }

    /**
     * Compare the string representation of this value to the specified
     * character sequence.
     *
     * @param x the character sequence to compare the string representation of
     *   this value against
     * @return true if this value represents the same string as the specified
     *   character sequence, otherwise false
     */
    public boolean contentEquals(byte[] x) {
        if (length != x.length)
            return false;

        for (int i = 0; i < length; i++) {
            if (bytes[offset + i] != x[i])
                return false;
        }

        return true;
    }

    /**
     * Compare the string representation of this value to the specified
     * character.
     *
     * @param x the character to compare the string representation of this
     *   value against
     * @return true if this value represents the same string as the specified
     *   character, otherwise false
     */
    public boolean contentEquals(char x) {
        return length == 1 && bytes[offset] == x;
    }

    /**
     * Compare the string representation of this value to the specified
     * character sequence.
     *
     * @param x the character sequence to compare the string representation of
     *   this value against
     * @return true if this value represents the same string as the specified
     *   character, otherwise false
     */
    public boolean contentEquals(CharSequence x) {
        if (length != x.length())
            return false;

        for (int i = 0; i < length; i++) {
            if (bytes[offset + i] != x.charAt(i))
                return false;
        }

        return true;
    }

    /**
     * Copy the value to a destination byte array.
     *
     * @param dst a destination byte array
     * @throws IndexOutOfBoundsException if the length of the value is greater
     *     than the length of the destination byte array
     */
    public void copyTo(byte[] dst) {
        System.arraycopy(bytes, offset, dst, 0, length);
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
        if (x < 0) {
            setNegativeInt(x);
            return;
        }

        int i = end;

        bytes[--i] = SOH;

        do {
            bytes[--i] = (byte)('0' + x % 10);

            x /= 10;
        } while (x > 0);

        offset = i;
        length = end - offset - 1;
    }

    private void setNegativeInt(long x) {
        int i = end;

        bytes[--i] = SOH;

        do {
            bytes[--i] = (byte)('0' - x % 10);

            x /= 10;
        } while (x < 0);

        bytes[--i] = '-';

        offset = i;
        length = end - offset - 1;
    }

    /**
     * Get the value as a float.
     *
     * <p><strong>Note.</strong> The value is a string representation of
     * a decimal number. As converting an arbitrary decimal number into a
     * floating point number requires arbitrary-precision arithmetic, this
     * method only works with the subset of decimal numbers that can be
     * converted into floating point numbers using floating-point
     * arithmetic.</p>
     *
     * <p>If we represent a decimal number in the form
     *
     *     &plusmn;<i>s</i>&nbsp;&times;&nbsp;10<sup><i>e</i></sup>,
     *
     * where <i>s</i> is an integer significand and <i>e</i> is an integer
     * exponent, this method works for decimal numbers having
     *
     *     0&nbsp;&le;&nbsp;<i>s</i>&nbsp;&le;&nbsp;2<sup>53</sup>&nbsp;-&nbsp;1
     *
     * and
     *
     *     -17&nbsp;&le;&nbsp;<i>e</i>&nbsp;&le;&nbsp;2.</p>
     *
     * @return the value as a float
     * @throws FIXValueFormatException if the value is not a float
     * @see <a href="https://www.exploringbinary.com/fast-path-decimal-to-floating-point-conversion/">Fast Path Decimal to Floating-Point Conversion</a>
     */
    public double asFloat() {
        boolean negative = false;

        int i = offset;

        if (bytes[i] == '-') {
            negative = true;

            i++;
        }

        long significand = 0;

        byte b = 0;

        while (i < offset + length) {
            b = bytes[i++];

            if (b < '0' || b > '9')
                break;

            significand = 10 * significand + b - '0';
        }

        if (b != '.' && i < offset + length)
            notFloat();

        int exponent = 0;

        while (i < offset + length) {
            b = bytes[i++];

            if (b < '0' || b > '9')
                notFloat();

            significand = 10 * significand + b - '0';

            exponent++;
        }

        double x = significand / POWERS_OF_TEN[exponent];

        return negative ? -x : +x;
    }

    /**
     * Set the value to a float.
     *
     * @param x a float
     * @param decimals the number of decimals
     * @see #asFloat
     */
    public void setFloat(double x, int decimals) {
        if (x < 0.0) {
            setNegativeFloat(x, decimals);
            return;
        }

        int i = end;

        bytes[--i] = SOH;

        long y = Math.round(POWERS_OF_TEN[decimals] * x);

        for (int j = 0; j < decimals; j++) {
            bytes[--i] = (byte)('0' + y % 10);

            y /= 10;
        }

        if (decimals > 0)
            bytes[--i] = '.';

        do {
            bytes[--i] = (byte)('0' + y % 10);

            y /= 10;
        } while (y > 0);

        offset = i;
        length = end - offset - 1;
    }

    private void setNegativeFloat(double x, int decimals) {
        int i = end;

        bytes[--i] = SOH;

        long y = Math.round(POWERS_OF_TEN[decimals] * -x);

        for (int j = 0; j < decimals; j++) {
            bytes[--i] = (byte)('0' + y % 10);

            y /= 10;
        }

        if (decimals > 0)
            bytes[--i] = '.';

        do {
            bytes[--i] = (byte)('0' + y % 10);

            y /= 10;
        } while (y > 0);

        bytes[--i] = '-';

        offset = i;
        length = end - offset - 1;
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
     * appendable.
     *
     * @param x an appendable
     * @throws IOException if an I/O error occurs
     */
    public void asString(Appendable x) throws IOException {
        for (int i = 0; i < length; i++)
            x.append((char)bytes[offset + i]);
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
     * Get the value as a date.
     *
     * <p><strong>Note.</strong> This method sets both date and time fields.
     * When combining this method and {@link #asTimeOnly(MutableDateTime)},
     * this method should be invoked first.</p>
     *
     * @param x a date
     * @throws FIXValueFormatException if the value is not a date
     * @see #asTimeOnly(MutableDateTime)
     */
    public void asDate(MutableDateTime x) {
        if (length != 8)
            notDate();

        int year        = getDigits(4, offset + 0);
        int monthOfYear = getDigits(2, offset + 4);
        int dayOfMonth  = getDigits(2, offset + 6);

        // Note: 'setDateTime()' takes roughly 55% of the time 'setDate()'
        // takes. Using individual methods, such as 'setYear()', is faster
        // than using 'setDate()' but still slower than 'setDateTime()'.
        x.setDateTime(year, monthOfYear, dayOfMonth, 0, 0, 0, 0);
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
     * Get the value as a time only.
     *
     * @param x a time only
     * @throws FIXValueFormatException if the value is not a time only
     * @see #asDate(MutableDateTime)
     */
    public void asTimeOnly(MutableDateTime x) {
        if (length != 8 && length != 12)
            notTimeOnly();

        int hourOfDay      = getDigits(2, offset + 0);
        int minuteOfHour   = getDigits(2, offset + 3);
        int secondOfMinute = getDigits(2, offset + 6);
        int millisOfSecond = length == 12 ? getDigits(3, offset + 9) : 0;

        x.setTime(hourOfDay, minuteOfHour, secondOfMinute, millisOfSecond);
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
     * Get the value as a timestamp.
     *
     * @param x a timestamp
     * @throws FIXValueFormatException if the value is not a timestamp
     */
    public void asTimestamp(MutableDateTime x) {
        if (length != 17 && length != 21)
            notTimestamp();

        int year           = getDigits(4, offset + 0);
        int monthOfYear    = getDigits(2, offset + 4);
        int dayOfMonth     = getDigits(2, offset + 6);
        int hourOfDay      = getDigits(2, offset + 9);
        int minuteOfHour   = getDigits(2, offset + 12);
        int secondOfMinute = getDigits(2, offset + 15);
        int millisOfSecond = length == 21 ? getDigits(3, offset + 18) : 0;

        x.setDateTime(year, monthOfYear, dayOfMonth, hourOfDay, minuteOfHour,
                secondOfMinute, millisOfSecond);
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
     * Get the value as a checksum.
     *
     * @return the value as a checksum
     * @throws FIXValueFormatException if the value is not an integer
     * @deprecated Use {@link #asInt()} instead.
     */
    @Deprecated
    public long asCheckSum() {
        return asInt();
    }

    /**
     * Set the value to a checksum.
     *
     * @param x a checksum
     */
    public void setCheckSum(long x) {
        setDigits((int)(x & 0xff), 0, 3);
        bytes[3] = SOH;

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

        while (buffer.hasRemaining()) {
            byte b = buffer.get();

            bytes[length] = b;

            if (b == SOH)
                return true;

            if (++length == end)
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

    /**
     * Returns a string representation of this value.
     *
     * <p><strong>Note.</strong> This method allocates memory.</p>
     *
     * @return a string representation of this value
     */
    @Override
    public String toString() {
        return asString();
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

    private void setDigits(int value, int offset, int digits) {
        while (digits-- > 0) {
            bytes[offset + digits] = (byte)('0' + value % 10);

            value /= 10;
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
