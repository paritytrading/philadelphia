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

    private byte[] bytes;

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
        offset = 0;
        length = value.length();

        for (int i = 0; i <= length; i++)
            bytes[i] = value.bytes[i];
    }

    /**
     * Get the value as a character.
     *
     * @return the value as a character
     * @throws FIXValueFormatException if the value is not a character
     */
    public char asChar() {
        if (length != 1)
            throw new FIXValueFormatException("Not a character");

        return (char)bytes[offset];
    }

    /**
     * Set the value to a character.
     *
     * @param c a character
     */
    public void setChar(char c) {
        bytes[0] = (byte)c;
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
        long value = 0;

        long sign  = bytes[offset] == '-' ? -1 : +1;
        int  start = sign < 0 ? offset + 1 : offset;

        for (int i = start; i < offset + length; i++) {
            byte b = bytes[i];

            if (b < '0' || b > '9')
                throw new FIXValueFormatException("Not an integer");

            value = 10 * value + bytes[i] - '0';
        }

        return sign * value;
    }

    /**
     * Set the value to an integer.
     *
     * @param i an integer
     */
    public void setInt(long i) {
        bytes[bytes.length - 1] = SOH;

        long j = Math.abs(i);

        int k = bytes.length - 2;

        do {
            bytes[k--] = (byte)('0' + j % 10);

            j /= 10;
        } while (j > 0);

        if (i < 0)
            bytes[k--] = '-';

        offset = k + 1;
        length = bytes.length - 1 - offset;
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

        long sign  = bytes[offset] == '-' ? -1 : +1;
        int  start = sign < 0 ? offset + 1 : offset;

        for (int i = start; i < offset + length; i++) {
            byte b = bytes[i];

            if (b < '0' || b > '9') {
                if (factor == 0.0 && b == '.') {
                    factor = 1.0;
                    continue;
                }

                throw new FIXValueFormatException("Not a float");
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

        bytes[bytes.length - 1] = SOH;

        int j = bytes.length - 2;

        for (int k = 0; k < decimals; k++) {
            bytes[j--] = (byte)('0' + i % 10);

            i /= 10;
        }

        if (decimals > 0)
            bytes[j--] = '.';

        do {
            bytes[j--] = (byte)('0' + i % 10);

            i /= 10;
        } while (i > 0);

        if (f < 0)
            bytes[j--] = '-';

        offset = j + 1;
        length = bytes.length - 1 - offset;
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
     * @param s a string builder
     */
    public void asString(StringBuilder s) {
        for (int i = offset; i < offset + length; i++)
            s.append((char)bytes[i]);
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
            bytes[i] = (byte)s.charAt(i);

        bytes[length] = SOH;
    }

    /**
     * Get the value as a date.
     *
     * @param d a date
     * @throws FIXValueFormatException if the value is not a date
     */
    public void asDate(MutableDateTime d) {
        if (length != 8)
            throw new FIXValueFormatException("Not a date");

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
        setDigits(d.getYear(), 4, 0);
        setDigits(d.getMonthOfYear(), 2, 4);
        setDigits(d.getDayOfMonth(), 2, 6);
        bytes[8] = SOH;

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
            throw new FIXValueFormatException("Not a time only");

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
        setDigits(t.getHourOfDay(), 2, 0);
        bytes[2] = ':';
        setDigits(t.getMinuteOfHour(), 2, 3);
        bytes[5] = ':';
        setDigits(t.getSecondOfMinute(), 2, 6);

        if (millis) {
            bytes[8] = '.';
            setDigits(t.getMillisOfSecond(), 3, 9);
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
     * @param t a timestamp
     * @throws FIXValueFormatException if the value is not a timestamp
     */
    public void asTimestamp(MutableDateTime t) {
        if (length != 17 && length != 21)
            throw new FIXValueFormatException("Not a timestamp");

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
        setDigits(t.getYear(), 4, 0);
        setDigits(t.getMonthOfYear(), 2, 4);
        setDigits(t.getDayOfMonth(), 2, 6);
        bytes[8] = '-';
        setDigits(t.getHourOfDay(), 2, 9);
        bytes[11] = ':';
        setDigits(t.getMinuteOfHour(), 2, 12);
        bytes[14] = ':';
        setDigits(t.getSecondOfMinute(), 2, 15);

        if (millis) {
            bytes[17] = '.';
            setDigits(t.getMillisOfSecond(), 3, 18);
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
        setDigits(c % 256, 3, 0);
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

            if (++length == bytes.length)
                throw new FIXValueOverflowException("Too long value");
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
                throw new FIXValueFormatException("Not a digit");

            value = b - '0' + 10 * value;
        }

        return value;
    }

    private void setDigits(long l, int digits, int offset) {
        for (int i = offset + digits - 1; i >= offset; i--) {
            bytes[i] = (byte)('0' + l % 10);

            l /= 10;
        }
    }

}
