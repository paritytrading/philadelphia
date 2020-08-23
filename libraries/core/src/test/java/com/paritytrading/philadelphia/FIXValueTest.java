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

import static org.junit.Assert.*;

import java.nio.ByteBuffer;
import org.joda.time.MutableDateTime;
import org.junit.Before;
import org.junit.Test;

public class FIXValueTest {

    private static final byte F = 'F';

    private static final byte[] FOO = { 'F', 'O', 'O', };

    private FIXValue value;

    @Before
    public void setUp() {
        value = new FIXValue(32);
    }

    @Test
    public void byteAt() {
        value.setString("FOO");

        byte[] bytes = new byte[value.length()];

        for (int i = 0; i < value.length(); i++)
            bytes[i] = value.byteAt(i);

        assertArrayEquals(new byte[] { 'F', 'O', 'O' }, bytes);
    }

    @Test
    public void copyTo() {
        value.setInt(123);

        byte[] bytes = new byte[6];

        value.copyTo(bytes);

        assertArrayEquals(new byte[] { '1', '2', '3', 0, 0, 0 }, bytes);
    }

    @Test
    public void setWithoutOffset() {
        FIXValue anotherValue = new FIXValue(32);

        anotherValue.setString("FOO");

        value.set(anotherValue);

        assertPutEquals("FOO\u0001");
    }

    @Test
    public void setWithOffset() {
        FIXValue anotherValue = new FIXValue(32);

        anotherValue.setInt(123);

        value.set(anotherValue);

        assertPutEquals("123\u0001");
    }

    @Test
    public void get() throws FIXValueOverflowException {
        get("FOO\u0001");

        assertPutEquals("FOO\u0001");
    }

    @Test
    public void contentEqualsByte() {
        value.setString("F");

        assertTrue(value.contentEquals(F));
    }

    @Test
    public void contentDoesNotEqualByte() {
        value.setString("FOO");

        assertFalse(value.contentEquals(F));
    }

    @Test
    public void contentEqualsByteArray() {
        value.setString("FOO");

        assertTrue(value.contentEquals(FOO));
    }

    @Test
    public void contentDoesNotEqualByteArray() {
        value.setString("F");

        assertFalse(value.contentEquals(FOO));
    }

    @Test
    public void contentEqualsChar() {
        value.setInt(1);

        assertTrue(value.contentEquals('1'));
    }

    @Test
    public void contentDoesNotEqualChar() {
        value.setInt(123);

        assertFalse(value.contentEquals('1'));
    }

    @Test
    public void contentEqualsCharSequence() {
        value.setInt(123);

        assertTrue(value.contentEquals("123"));
    }

    @Test
    public void contentDoesNotEqualCharSequence() {
        value.setInt(1);

        assertFalse(value.contentEquals("123"));
    }

    @Test
    public void asBoolean() throws FIXValueOverflowException {
        get("Y\u0001");

        assertTrue(value.asBoolean());
    }

    @Test
    public void setBoolean() {
        value.setBoolean(false);

        assertPutEquals("N\u0001");
    }

    @Test(expected=FIXValueFormatException.class)
    public void notBoolean() {
        value.setString("FOO");

        value.asBoolean();
    }

    @Test
    public void asChar() throws FIXValueOverflowException {
        get("Y\u0001");

        assertEquals('Y', value.asChar());
    }

    @Test
    public void setChar() {
        value.setChar('Y');

        assertPutEquals("Y\u0001");
    }

    @Test(expected=FIXValueFormatException.class)
    public void notChar() {
        value.setString("FOO");

        value.asChar();
    }

    @Test
    public void asInt() throws FIXValueOverflowException {
        get("123\u0001");

        assertEquals(123, value.asInt());
    }

    @Test
    public void setInt() {
        value.setInt(123);

        assertPutEquals("123\u0001");
    }

    @Test(expected=FIXValueFormatException.class)
    public void notInt() {
        value.setString("FOO");

        value.asInt();
    }

    @Test
    public void asZeroInt() throws FIXValueOverflowException {
        get("0\u0001");

        assertEquals(0, value.asInt());
    }

    @Test
    public void setZeroInt() {
        value.setInt(0);

        assertPutEquals("0\u0001");
    }

    @Test
    public void asNegativeInt() throws FIXValueOverflowException {
        get("-123\u0001");

        assertEquals(-123, value.asInt());
    }

    @Test
    public void setNegativeInt() {
        value.setInt(-123);

        assertPutEquals("-123\u0001");
    }

    @Test
    public void asFloat() throws FIXValueOverflowException {
        get("12.50\u0001");

        assertEquals(12.50, value.asFloat(), 0.01);
    }

    @Test
    public void setFloat() {
        value.setFloat(12.50, 2);

        assertPutEquals("12.50\u0001");
    }

    @Test(expected=FIXValueFormatException.class)
    public void notFloat() {
        value.setString("FOO");

        value.asFloat();
    }

    @Test
    public void asZeroFloat() throws FIXValueOverflowException {
        get("0.00\u0001");

        assertEquals(0.00, value.asFloat(), 0.01);
    }

    @Test
    public void setZeroFloat() {
        value.setFloat(0.00, 2);

        assertPutEquals("0.00\u0001");
    }

    @Test
    public void asNegativeFloat() throws FIXValueOverflowException {
        get("-12.50\u0001");

        assertEquals(-12.50, value.asFloat(), 0.01);
    }

    @Test
    public void setNegativeFloat() {
        value.setFloat(-12.50, 2);

        assertPutEquals("-12.50\u0001");
    }

    @Test
    public void asFloatWithoutDecimals() throws FIXValueOverflowException {
        get("12\u0001");

        assertEquals(12.00, value.asFloat(), 0.01);
    }

    @Test
    public void setFloatWithoutDecimals() {
        value.setFloat(12.00, 0);

        assertPutEquals("12\u0001");
    }

    @Test
    public void setFloatWithRoundingDown() {
        value.setFloat(12.50, 2);

        assertPutEquals("12.50\u0001");
    }

    @Test
    public void setFloatWithRoundingUp() {
        value.setFloat(12.505, 2);

        assertPutEquals("12.51\u0001");
    }

    @Test
    public void asString() throws FIXValueOverflowException {
        get("FOO\u0001");

        assertEquals("FOO", value.asString());
    }

    @Test
    public void asStringToStringBuilder() throws FIXValueOverflowException {
        get("FOO\u0001");

        StringBuilder s = new StringBuilder();

        value.asString(s);

        assertEquals("FOO", s.toString());
    }

    @Test
    public void setString() {
        value.setString("FOO");

        assertPutEquals("FOO\u0001");
    }

    @Test
    public void asDate() throws FIXValueOverflowException {
        get("20150924\u0001");

        MutableDateTime d = new MutableDateTime(1970, 1, 1, 9, 30, 5, 250);

        value.asDate(d);

        assertEquals(new MutableDateTime(2015, 9, 24, 0, 0, 0, 0), d);
    }

    @Test
    public void setDate() {
        value.setDate(new MutableDateTime(2015, 9, 24, 0, 0, 0, 0));

        assertPutEquals("20150924\u0001");
    }

    @Test
    public void asTimeOnlyWithMillis() throws FIXValueOverflowException {
        get("09:30:05.250\u0001");

        MutableDateTime t = new MutableDateTime(2015, 9, 24, 22, 45, 10, 750);

        value.asTimeOnly(t);

        assertEquals(new MutableDateTime(2015, 9, 24, 9, 30, 5, 250), t);
    }

    @Test
    public void asTimeOnlyWithoutMillis() throws FIXValueOverflowException {
        get("09:30:05\u0001");

        MutableDateTime t = new MutableDateTime(2015, 9, 24, 22, 45, 10, 750);

        value.asTimeOnly(t);

        assertEquals(new MutableDateTime(2015, 9, 24, 9, 30, 5, 0), t);
    }

    @Test
    public void setTimeOnlyWithMillis() {
        value.setTimeOnly(new MutableDateTime(2015, 9, 24, 9, 30, 5, 250), true);

        assertPutEquals("09:30:05.250\u0001");
    }

    @Test
    public void setTimeOnlyWithoutMillis() {
        value.setTimeOnly(new MutableDateTime(2015, 9, 24, 9, 30, 5, 250), false);

        assertPutEquals("09:30:05\u0001");
    }

    @Test
    public void asTimestampWithMillis() throws FIXValueOverflowException {
        get("20150924-09:30:05.250\u0001");

        MutableDateTime t = new MutableDateTime();

        value.asTimestamp(t);

        assertEquals(new MutableDateTime(2015, 9, 24, 9, 30, 5, 250), t);
    }

    @Test
    public void asTimestampWithoutMillis() throws FIXValueOverflowException {
        get("20150924-09:30.05\u0001");

        MutableDateTime t = new MutableDateTime();

        value.asTimestamp(t);

        assertEquals(new MutableDateTime(2015, 9, 24, 9, 30, 5, 0), t);
    }

    @Test
    public void setTimestampWithMillis() {
        value.setTimestamp(new MutableDateTime(2015, 9, 24, 9, 30, 5, 250), true);

        assertPutEquals("20150924-09:30:05.250\u0001");
    }

    @Test
    public void setTimestampWithoutMillis() {
        value.setTimestamp(new MutableDateTime(2015, 9, 24, 9, 30, 5, 250), false);

        assertPutEquals("20150924-09:30:05\u0001");
    }

    @Test(expected=FIXValueFormatException.class)
    public void notTimestamp() {
        value.setString("FOO");

        value.asTimestamp(new MutableDateTime());
    }

    @SuppressWarnings("deprecation")
    @Test
    public void asCheckSum() throws FIXValueOverflowException {
        get("064\u0001");

        assertEquals(64, value.asCheckSum());
    }

    @Test
    public void setCheckSum() {
        value.setCheckSum(320);

        assertPutEquals("064\u0001");
    }

    @SuppressWarnings("deprecation")
    @Test(expected=FIXValueFormatException.class)
    public void notCheckSum() {
        value.setString("FOO");

        value.asCheckSum();
    }

    @Test(expected=FIXValueOverflowException.class)
    public void readOverflow() throws FIXValueOverflowException {
        value.get(ByteBuffers.wrap("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
    }

    @Test
    public void print() {
        value.setString("FOO");

        assertEquals("FOO|", value.toString());
    }

    @Test
    public void readPartial() throws FIXValueOverflowException {
        assertEquals(false, value.get(ByteBuffers.wrap("foo")));
    }

    private void get(String s) throws FIXValueOverflowException {
        value.get(ByteBuffers.wrap(s));
    }

    private void assertPutEquals(String s) {
        ByteBuffer buffer = ByteBuffer.allocateDirect(s.length());

        value.put(buffer);
        buffer.flip();

        assertEquals(s, ByteBuffers.getString(buffer));
    }

}
