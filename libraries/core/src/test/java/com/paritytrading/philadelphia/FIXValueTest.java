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
    void setIntMinValue() {
        value.setInt(Long.MIN_VALUE);

        assertEquals("-9223372036854775808\u0001", put());
    }

    @Test
    void setIntMinusOneHundredTwentyThree() {
        value.setInt(-123);

        assertEquals("-123\u0001", put());
    }

    @Test
    void setIntMinusOne() {
        value.setInt(-1);

        assertEquals("-1\u0001", put());
    }

    @Test
    void setIntZero() {
        value.setInt(0);

        assertEquals("0\u0001", put());
    }

    @Test
    void setIntOne() {
        value.setInt(1);

        assertEquals("1\u0001", put());
    }

    @Test
    void setIntOneHundredTwentyThree() {
        value.setInt(123);

        assertEquals("123\u0001", put());
    }

    @Test
    void setIntMaxValue() {
        value.setInt(Long.MAX_VALUE);

        assertEquals("9223372036854775807\u0001", put());
    }

    @Test
    void asFloatMinValue() {
        get("-900719925474099100.0");

        assertEquals(-900719925474099100.0, value.asFloat(), 0.1);
    }

    @Test
    void asFloatMinusTwelvePointThree() {
        get("-12.3\u0001");

        assertEquals(-12.3, value.asFloat(), 0.001);
    }

    @Test
    void asFloatMinusPi() {
        get("-3.141592653589793");

        assertEquals(-Math.PI, value.asFloat(), 1e-16);
    }

    @Test
    void asFloatMinusOne() {
        get("-1\u0001");

        assertEquals(-1.0, value.asFloat(), 0.001);
    }

    @Test
    void asFloatMinusOnePointZero() {
        get("-1.0\u0001");

        assertEquals(-1.0, value.asFloat(), 0.001);
    }

    @Test
    void asFloatMinusZeroPointOne() {
        get("-0.1\u0001");

        assertEquals(-0.1, value.asFloat(), 0.001);
    }

    @Test
    void asFloatMinusZeroPointZeroOne() {
        get("-0.01\u0001");

        assertEquals(-0.01, value.asFloat(), 0.001);
    }

    @Test
    void asFloatMinusMinDecimal() {
        get("-0.00000000000000001");

        assertEquals(-1e-17, value.asFloat(), 1e-18);
    }

    @Test
    void asFloatMinusZero() {
        get("-0\u0001");

        assertEquals(0.0, value.asFloat(), 0.001);
    }

    @Test
    void asFloatMinusZeroPointZero() {
        get("-0.0\u0001");

        assertEquals(0.0, value.asFloat(), 0.001);
    }

    @Test
    void asFloatZero() {
        get("0\u0001");

        assertEquals(0.0, value.asFloat(), 0.001);
    }

    @Test
    void asFloatZeroPointZero() {
        get("0.0\u0001");

        assertEquals(0.0, value.asFloat(), 0.001);
    }

    @Test
    void asFloatMinDecimal() {
        get("0.00000000000000001");

        assertEquals(1e-17, value.asFloat(), 1e-18);
    }

    @Test
    void asFloatZeroPointZeroOne() {
        get("0.01\u0001");

        assertEquals(0.01, value.asFloat(), 0.001);
    }

    @Test
    void asFloatZeroPointOne() {
        get("0.1\u0001");

        assertEquals(0.1, value.asFloat(), 0.001);
    }

    @Test
    void asFloatOne() {
        get("1\u0001");

        assertEquals(1.0, value.asFloat(), 0.001);
    }

    @Test
    void asFloatOnePointZero() {
        get("1.0\u0001");

        assertEquals(1.0, value.asFloat(), 0.001);
    }

    @Test
    void asFloatPi() {
        get("3.141592653589793");

        assertEquals(Math.PI, value.asFloat(), 1e-16);
    }

    @Test
    void asFloatTwelvePointThree() {
        get("12.3\u0001");

        assertEquals(12.3, value.asFloat(), 0.001);
    }

    @Test
    void asFloatMaxValue() {
        get("900719925474099100.0");

        assertEquals(900719925474099100.0, value.asFloat(), 0.1);
    }

    @Test
    void notFloat() {
        value.setString("FOO");

        assertThrows(FIXValueFormatException.class, () -> value.asFloat());
    }

    @Test
    void setFloatMinValue() {
        value.setFloat(-900719925474099100.0, 0);

        assertEquals("-900719925474099072\u0001", put());
    }

    @Test
    void setFloatMinusTwelvePointThree() {
        value.setFloat(-12.3, 1);

        assertEquals("-12.3\u0001", put());
    }

    @Test
    void setFloatMinusPi() {
        value.setFloat(-Math.PI, 15);

        assertEquals("-3.141592653589793\u0001", put());
    }

    @Test
    void setFloatMinusPiWithFourDecimals() {
        value.setFloat(-Math.PI, 4);

        assertEquals("-3.1416\u0001", put());
    }

    @Test
    void setFloatMinusPiWithThreeDecimals() {
        value.setFloat(-Math.PI, 3);

        assertEquals("-3.142\u0001", put());
    }

    @Test
    void setFloatMinusPiWithTwoDecimals() {
        value.setFloat(-Math.PI, 2);

        assertEquals("-3.14\u0001", put());
    }

    @Test
    void setFloatMinusOne() {
        value.setFloat(-1.0, 0);

        assertEquals("-1\u0001", put());
    }

    @Test
    void setFloatMinusOnePointZero() {
        value.setFloat(-1.0, 1);

        assertEquals("-1.0\u0001", put());
    }

    @Test
    void setFloatMinusZeroPointOne() {
        value.setFloat(-0.1, 1);

        assertEquals("-0.1\u0001", put());
    }

    @Test
    void setFloatMinusZeroPointZeroOne() {
        value.setFloat(-0.01, 2);

        assertEquals("-0.01\u0001", put());
    }

    @Test
    void setFloatMinusMinDecimal() {
        value.setFloat(-0.00000000000000001, 17);

        assertEquals("-0.00000000000000001\u0001", put());
    }

    @Test
    void setFloatZero() {
        value.setFloat(0.0, 0);

        assertEquals("0\u0001", put());
    }

    @Test
    void setFloatZeroPointZero() {
        value.setFloat(0.0, 1);

        assertEquals("0.0\u0001", put());
    }

    @Test
    void setFloatMinDecimal() {
        value.setFloat(0.00000000000000001, 17);

        assertEquals("0.00000000000000001\u0001", put());
    }

    @Test
    void setFloatZeroPointZeroOne() {
        value.setFloat(0.01, 2);

        assertEquals("0.01\u0001", put());
    }

    @Test
    void setFloatZeroPointOne() {
        value.setFloat(0.1, 1);

        assertEquals("0.1\u0001", put());
    }

    @Test
    void setFloatOne() {
        value.setFloat(1.0, 0);

        assertEquals("1\u0001", put());
    }

    @Test
    void setFloatOnePointZero() {
        value.setFloat(1.0, 1);

        assertEquals("1.0\u0001", put());
    }

    @Test
    void setFloatPiWithTwoDecimals() {
        value.setFloat(Math.PI, 2);

        assertEquals("3.14\u0001", put());
    }

    @Test
    void setFloatPiWithThreeDecimals() {
        value.setFloat(Math.PI, 3);

        assertEquals("3.142\u0001", put());
    }

    @Test
    void setFloatPiWithFourDecimals() {
        value.setFloat(Math.PI, 4);

        assertEquals("3.1416\u0001", put());
    }

    @Test
    void setFloatPi() {
        value.setFloat(Math.PI, 15);

        assertEquals("3.141592653589793\u0001", put());
    }

    @Test
    void setFloatTwelvePointThree() {
        value.setFloat(12.3, 1);

        assertEquals("12.3\u0001", put());
    }

    @Test
    void setFloatMaxValue() {
        value.setFloat(900719925474099100.0, 0);

        assertEquals("900719925474099072\u0001", put());
    }

    @Test
    void asString() {
        get("FOO\u0001");

        assertEquals("FOO", value.asString());
    }

    @Test
    void asStringWithAppendable() throws IOException {
        get("FOO\u0001");

        StringBuilder builder = new StringBuilder();

        Appendable appendable = builder;

        value.asString(appendable);

        assertEquals("FOO", builder.toString());
    }

    @Test
    void asStringWithStringBuilder() {
        get("FOO\u0001");

        StringBuilder builder = new StringBuilder();

        value.asString(builder);

        assertEquals("FOO", builder.toString());
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
    void notDate() {
        value.setString("FOO");

        assertThrows(FIXValueFormatException.class, () -> value.asDate(new MutableDateTime()));
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
    void notTimeOnly() {
        value.setString("FOO");

        assertThrows(FIXValueFormatException.class, () -> value.asTimeOnly(new MutableDateTime()));
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
    void notTimestamp() {
        value.setString("FOO");

        assertThrows(FIXValueFormatException.class, () -> value.asTimestamp(new MutableDateTime()));
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

    @SuppressWarnings("deprecation")
    @Test
    void asCheckSum() {
        get("064\u0001");

        assertEquals(64, value.asCheckSum());
    }

    @SuppressWarnings("deprecation")
    @Test
    void notCheckSum() {
        value.setString("FOO");

        assertThrows(FIXValueFormatException.class, () -> value.asCheckSum());
    }

    @Test
    void setCheckSum() {
        value.setCheckSum(320);

        assertEquals("064\u0001", put());
    }

    @Test
    void get() {
        get("FOO\u0001BAR\u0001");

        assertEquals("FOO\u0001", put());
    }

    @Test
    void getWithPartial() {
        assertEquals(false, get("FOO"));
    }

    @Test
    void getWithOverflow() {
        assertThrows(FIXValueOverflowException.class, () -> value.get(ByteBuffers.wrap("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")));
    }

    @Test
    void string() {
        value.setString("FOO");

        assertEquals("FOO", value.toString());
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
