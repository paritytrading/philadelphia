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

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.ByteBuffer;
import org.joda.time.MutableDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FIXValueTest {

    private FIXValue value;

    @BeforeEach
    void setUp() {
        value = new FIXValue(32);
    }

    @Test
    void byteAt() {
        value.setInt(123);

        int length = value.length();

        byte[] bytes = new byte[length];

        for (int i = 0; i < length; i++)
            bytes[i] = value.byteAt(i);

        assertArrayEquals(new byte[] { '1', '2', '3' }, bytes);
    }

    @Test
    void contentEqualsByte() {
        value.setInt(1);

        assertTrue(value.contentEquals((byte)'1'));
    }

    @Test
    void contentDoesNotEqualByte() {
        value.setString("FOO");

        assertFalse(value.contentEquals((byte)'F'));
    }

    @Test
    void contentEqualsByteArray() {
        value.setInt(123);

        assertTrue(value.contentEquals(new byte[] { '1', '2', '3' }));
    }

    @Test
    void contentDoesNotEqualByteArray() {
        value.setString("F");

        assertFalse(value.contentEquals(new byte[] { 'F', 'O', 'O' }));
    }

    @Test
    void contentEqualsChar() {
        value.setInt(1);

        assertTrue(value.contentEquals('1'));
    }

    @Test
    void contentDoesNotEqualChar() {
        value.setString("FOO");

        assertFalse(value.contentEquals('F'));
    }

    @Test
    void contentEqualsCharSequence() {
        value.setInt(123);

        assertTrue(value.contentEquals("123"));
    }

    @Test
    void contentDoesNotEqualCharSequence() {
        value.setString("F");

        assertFalse(value.contentEquals("FOO"));
    }

    @Test
    void copyTo() {
        value.setInt(123);

        byte[] dst = new byte[6];

        value.copyTo(dst);

        assertArrayEquals(new byte[] { '1', '2', '3', 0, 0, 0 }, dst);
    }

    @Test
    void reset() {
        value.setString("FOO");
        value.reset();

        assertEquals(0, value.length());
    }

    @Test
    void set() {
        FIXValue anotherValue = new FIXValue(32);

        anotherValue.setInt(123);

        value.set(anotherValue);

        assertEquals("123\u0001", put());
    }

    @Test
    void asBooleanTrue() {
        get("Y\u0001");

        assertTrue(value.asBoolean());
    }

    @Test
    void asBooleanFalse() {
        get("N\u0001");

        assertFalse(value.asBoolean());
    }

    @Test
    void notBoolean() {
        value.setString("FOO");

        assertThrows(FIXValueFormatException.class, () -> value.asBoolean());
    }

    void setBooleanTrue() {
        value.setBoolean(true);

        assertEquals("Y\u0001", put());
    }

    @Test
    void setBooleanFalse() {
        value.setBoolean(false);

        assertEquals("N\u0001", put());
    }

    @Test
    void asChar() {
        get("Y\u0001");

        assertEquals('Y', value.asChar());
    }

    @Test
    void notChar() {
        value.setString("FOO");

        assertThrows(FIXValueFormatException.class, () -> value.asChar());
    }

    @Test
    void setChar() {
        value.setChar('Y');

        assertEquals("Y\u0001", put());
    }

    @Test
    void asIntMinValue() {
        get("-9223372036854775808\u0001");

        assertEquals(Long.MIN_VALUE, value.asInt());
    }

    @Test
    void asIntMinusOneHundredTwentyThree() {
        get("-123\u0001");

        assertEquals(-123, value.asInt());
    }

    @Test
    void asIntMinusOne() {
        get("-1\u0001");

        assertEquals(-1, value.asInt());
    }

    @Test
    void asIntMinusZero() {
        get("-0\u0001");

        assertEquals(0, value.asInt());
    }

    @Test
    void asIntZero() {
        get("0\u0001");

        assertEquals(0, value.asInt());
    }

    @Test
    void asIntOne() {
        get("1\u0001");

        assertEquals(1, value.asInt());
    }

    @Test
    void asIntOneHundredTwentyThree() {
        get("123\u0001");

        assertEquals(123, value.asInt());
    }

    @Test
    void asIntMaxValue() {
        get("9223372036854775807\u0001");

        assertEquals(Long.MAX_VALUE, value.asInt());
    }

    @Test
    void notInt() {
        value.setString("FOO");

        assertThrows(FIXValueFormatException.class, () -> value.asInt());
    }

    @Test
    void setInt() {
        value.setInt(123);

        assertEquals("123\u0001", put());
    }

    @Test
    void setZeroInt() {
        value.setInt(0);

        assertEquals("0\u0001", put());
    }

    @Test
    void setNegativeInt() {
        value.setInt(-123);

        assertEquals("-123\u0001", put());
    }

    @Test
    void asFloat() {
        get("12.50\u0001");

        assertEquals(12.50, value.asFloat(), 0.01);
    }

    @Test
    void setFloat() {
        value.setFloat(12.50, 2);

        assertEquals("12.50\u0001", put());
    }

    @Test
    void notFloat() {
        value.setString("FOO");

        assertThrows(FIXValueFormatException.class, () -> value.asFloat());
    }

    @Test
    void asZeroFloat() {
        get("0.00\u0001");

        assertEquals(0.00, value.asFloat(), 0.01);
    }

    @Test
    void setZeroFloat() {
        value.setFloat(0.00, 2);

        assertEquals("0.00\u0001", put());
    }

    @Test
    void asNegativeFloat() {
        get("-12.50\u0001");

        assertEquals(-12.50, value.asFloat(), 0.01);
    }

    @Test
    void setNegativeFloat() {
        value.setFloat(-12.50, 2);

        assertEquals("-12.50\u0001", put());
    }

    @Test
    void asFloatWithoutDecimals() {
        get("12\u0001");

        assertEquals(12.00, value.asFloat(), 0.01);
    }

    @Test
    void setFloatWithoutDecimals() {
        value.setFloat(12.00, 0);

        assertEquals("12\u0001", put());
    }

    @Test
    void setFloatWithRoundingDown() {
        value.setFloat(12.50, 2);

        assertEquals("12.50\u0001", put());
    }

    @Test
    void setFloatWithRoundingUp() {
        value.setFloat(12.505, 2);

        assertEquals("12.51\u0001", put());
    }

    @Test
    void asString() {
        get("FOO\u0001");

        assertEquals("FOO", value.asString());
    }

    @Test
    void asStringToAppendable() throws IOException {
        get("FOO\u0001");

        StringBuilder s = new StringBuilder();

        value.asString((Appendable)s);

        assertEquals("FOO", s.toString());
    }

    @Test
    void asStringToStringBuilder() {
        get("FOO\u0001");

        StringBuilder s = new StringBuilder();

        value.asString(s);

        assertEquals("FOO", s.toString());
    }

    @Test
    void setString() {
        value.setString("FOO");

        assertEquals("FOO\u0001", put());
    }

    @Test
    void asDate() {
        get("20150924\u0001");

        MutableDateTime d = new MutableDateTime(1970, 1, 1, 9, 30, 5, 250);

        value.asDate(d);

        assertEquals(new MutableDateTime(2015, 9, 24, 0, 0, 0, 0), d);
    }

    @Test
    void setDate() {
        value.setDate(new MutableDateTime(2015, 9, 24, 0, 0, 0, 0));

        assertEquals("20150924\u0001", put());
    }

    @Test
    void asTimeOnlyWithMillis() {
        get("09:30:05.250\u0001");

        MutableDateTime t = new MutableDateTime(2015, 9, 24, 22, 45, 10, 750);

        value.asTimeOnly(t);

        assertEquals(new MutableDateTime(2015, 9, 24, 9, 30, 5, 250), t);
    }

    @Test
    void asTimeOnlyWithoutMillis() {
        get("09:30:05\u0001");

        MutableDateTime t = new MutableDateTime(2015, 9, 24, 22, 45, 10, 750);

        value.asTimeOnly(t);

        assertEquals(new MutableDateTime(2015, 9, 24, 9, 30, 5, 0), t);
    }

    @Test
    void setTimeOnlyWithMillis() {
        value.setTimeOnly(new MutableDateTime(2015, 9, 24, 9, 30, 5, 250), true);

        assertEquals("09:30:05.250\u0001", put());
    }

    @Test
    void setTimeOnlyWithoutMillis() {
        value.setTimeOnly(new MutableDateTime(2015, 9, 24, 9, 30, 5, 250), false);

        assertEquals("09:30:05\u0001", put());
    }

    @Test
    void asTimestampWithMillis() {
        get("20150924-09:30:05.250\u0001");

        MutableDateTime t = new MutableDateTime();

        value.asTimestamp(t);

        assertEquals(new MutableDateTime(2015, 9, 24, 9, 30, 5, 250), t);
    }

    @Test
    void asTimestampWithoutMillis() {
        get("20150924-09:30.05\u0001");

        MutableDateTime t = new MutableDateTime();

        value.asTimestamp(t);

        assertEquals(new MutableDateTime(2015, 9, 24, 9, 30, 5, 0), t);
    }

    @Test
    void setTimestampWithMillis() {
        value.setTimestamp(new MutableDateTime(2015, 9, 24, 9, 30, 5, 250), true);

        assertEquals("20150924-09:30:05.250\u0001", put());
    }

    @Test
    void setTimestampWithoutMillis() {
        value.setTimestamp(new MutableDateTime(2015, 9, 24, 9, 30, 5, 250), false);

        assertEquals("20150924-09:30:05\u0001", put());
    }

    @Test
    void notTimestamp() {
        value.setString("FOO");

        assertThrows(FIXValueFormatException.class, () -> value.asTimestamp(new MutableDateTime()));
    }

    @SuppressWarnings("deprecation")
    @Test
    void asCheckSum() {
        get("064\u0001");

        assertEquals(64, value.asCheckSum());
    }

    @Test
    void setCheckSum() {
        value.setCheckSum(320);

        assertEquals("064\u0001", put());
    }

    @SuppressWarnings("deprecation")
    @Test
    void notCheckSum() {
        value.setString("FOO");

        assertThrows(FIXValueFormatException.class, () -> value.asCheckSum());
    }

    @Test
    void get() {
        get("FOO\u0001");

        assertEquals("FOO\u0001", put());
    }

    @Test
    void readOverflow() {
        assertThrows(FIXValueOverflowException.class, () -> value.get(ByteBuffers.wrap("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")));
    }

    @Test
    void print() {
        value.setString("FOO");

        assertEquals("FOO|", value.toString());
    }

    @Test
    void readPartial() {
        assertEquals(false, get("foo"));
    }

    private boolean get(String text) {
        try {
            return value.get(ByteBuffers.wrap(text));
        } catch (FIXValueOverflowException e) {
            throw new UncheckedIOException(e);
        }
    }

    private String put() {
        ByteBuffer buffer = ByteBuffer.allocateDirect(value.length() + 1);

        value.put(buffer);
        buffer.flip();

        return ByteBuffers.getString(buffer);
    }

}
