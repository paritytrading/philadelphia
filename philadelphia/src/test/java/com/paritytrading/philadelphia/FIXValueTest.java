package com.paritytrading.philadelphia;

import static com.paritytrading.philadelphia.FIX.*;
import static org.junit.Assert.*;

import java.nio.ByteBuffer;
import java.nio.BufferUnderflowException;
import org.joda.time.LocalTime;
import org.joda.time.MutableDateTime;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class FIXValueTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    private FIXValue value;

    @Before
    public void setUp() {
        value = new FIXValue(32);
    }

    public void byteAt() {
        value.setString("FOO");

        byte[] bytes = new byte[value.length()];

        for (int i = 0; i < value.length(); i++)
            bytes[i] = value.byteAt(i);

        assertArrayEquals(new byte[] { 'F', 'O', 'O' }, bytes);
    }

    public void copyTo() {
        value.setInt(123);

        byte[] bytes = new byte[6];

        value.copyTo(bytes);

        assertArrayEquals(new byte[] { '1', '2', '3', 0, 0, 0 }, bytes);
    }

    @Test
    public void set() {
        FIXValue anotherValue = new FIXValue(32);

        anotherValue.setString("FOO");

        value.set(anotherValue);

        assertPutEquals("FOO\u0001");
    }

    @Test
    public void get() throws FIXValueOverflowException {
        get("FOO\u0001");

        assertPutEquals("FOO\u0001");
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

    @Test
    public void notChar() {
        value.setString("FOO");

        exception.expect(FIXValueFormatException.class);

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

    @Test
    public void notInt() {
        value.setString("FOO");

        exception.expect(FIXValueFormatException.class);

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

    @Test
    public void notFloat() {
        value.setString("FOO");

        exception.expect(FIXValueFormatException.class);

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
        get("20150924");

        MutableDateTime d = new MutableDateTime();

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
        get("09:30:05.250");

        MutableDateTime t = new MutableDateTime();

        value.asTimeOnly(t);

        assertEquals(new LocalTime(9, 30, 5, 250), new LocalTime(t));
    }

    @Test
    public void asTimeOnlyWithoutMillis() throws FIXValueOverflowException {
        get("09:30:05");

        MutableDateTime t = new MutableDateTime();

        value.asTimeOnly(t);

        assertEquals(new LocalTime(9, 30, 5, 0), new LocalTime(t));
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
        get("20150924-09:30:05.250");

        MutableDateTime t = new MutableDateTime();

        value.asTimestamp(t);

        assertEquals(new MutableDateTime(2015, 9, 24, 9, 30, 5, 250), t);
    }

    @Test
    public void asTimestampWithoutMillis() throws FIXValueOverflowException {
        get("20150924-09:30.05");

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

    @Test
    public void notTimestamp() {
        value.setString("FOO");

        exception.expect(FIXValueFormatException.class);

        value.asTimestamp(new MutableDateTime());
    }

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

    @Test
    public void notCheckSum() {
        value.setString("FOO");

        exception.expect(FIXValueFormatException.class);

        value.asCheckSum();
    }

    @Test
    public void readOverflow() throws FIXValueOverflowException {
        exception.expect(FIXValueOverflowException.class);

        value.get(ByteBuffers.wrap("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
    }

    @Test
    public void readPartial() throws FIXValueOverflowException {
        assertEquals(false, value.get(ByteBuffers.wrap("foo")));
    }

    private void get(String s) throws FIXValueOverflowException {
        value.get(ByteBuffers.wrap(s));
    }

    private void assertPutEquals(String s) {
        ByteBuffer buffer = ByteBuffer.allocate(s.length());

        value.put(buffer);
        buffer.flip();

        assertEquals(s, ByteBuffers.getString(buffer));
    }

}
