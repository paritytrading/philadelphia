package com.paritytrading.philadelphia;

import static java.util.Arrays.*;
import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.ByteBuffer;
import org.junit.Before;
import org.junit.Test;

public class FIXMessageParserTest {

    private FIXMessage message;

    private FIXMessageParser parser;

    private FIXMessages messages;

    @Before
    public void setUp() {
        message = new FIXMessage(32, 32);

        messages = new FIXMessages();

        parser = new FIXMessageParser(messages, message);
    }

    @Test
    public void readPartialBeginStringTag() throws IOException {
        readPartial("8");
    }

    @Test
    public void readPartialBeginStringValueMissing() throws IOException {
        readPartial("8=");
    }

    @Test
    public void readPartialBeginStringValue() throws IOException {
        readPartial("8=FIX");
    }

    @Test
    public void readGarbledBeginString() throws IOException {
        readGarbledOrPartial("9=30\u00018=FIX.4.2\u0001", 10);
    }

    @Test
    public void readPartialBodyLengthMissing() throws IOException {
        readPartial("8=FIX.4.2\u0001");
    }

    @Test
    public void readPartialBodyLengthTag() throws IOException {
        readPartial("8=FIX.4.2\u00019");
    }

    @Test
    public void readPartialBodyLengthValueMissing() throws IOException {
        readPartial("8=FIX.4.2\u00019=");
    }

    @Test
    public void readPartialBodyLengthValue() throws IOException {
        readPartial("8=FIX.4.2\u00019=1");
    }

    @Test
    public void readGarbledBodyLength() throws IOException {
        readGarbledOrPartial("8=FIX.4.2\u00018=FIX.4.2\u0001", 10);
    }

    @Test
    public void readPartialBody() throws IOException {
        readPartial("8=FIX.4.2\u00019=5\u000135=");
    }

    @Test
    public void readPartialCheckSumMissing() throws IOException {
        readPartial("8=FIX.4.2\u00019=5\u000135=D\u0001");
    }

    @Test
    public void readPartialCheckSumTag() throws IOException {
        readPartial("8=FIX.4.2\u00019=5\u000135=D\u000110");
    }

    @Test
    public void readPartialCheckSumValueMissing() throws IOException {
        readPartial("8=FIX.4.2\u00019=5\u000135=D\u000110=");
    }

    @Test
    public void readPartialCheckSumValue() throws IOException {
        readPartial("8=FIX.4.2\u00019=5\u000135=D\u000110=0");
    }

    @Test
    public void readGarbledCheckSum() throws IOException {
        readGarbledOrPartial("8=FIX.4.2\u00019=5\u000135=D\u000110=000\u0001", 0);
    }

    @Test
    public void read() throws IOException {
        ByteBuffer buffer = ByteBuffers.wrap("8=FIX.4.2\u00019=5\u000135=D\u000110=181\u0001");

        assertEquals(true, parser.parse(buffer));

        assertEquals(0, buffer.remaining());

        assertEquals(asList("35=D\u0001"), messages.collect());
    }

    @Test
    public void readFixt11() throws IOException {
        ByteBuffer buffer = ByteBuffers.wrap("8=FIXT.1.1\u00019=5\u000135=D\u000110=005\u0001");

        assertEquals(true, parser.parse(buffer));

        assertEquals(0, buffer.remaining());

        assertEquals(asList("35=D\u0001"), messages.collect());
    }

    private void readPartial(String input) throws IOException {
        readGarbledOrPartial(input, input.length());
    }

    private void readGarbledOrPartial(String input, int remaining) throws IOException {
        ByteBuffer buffer = ByteBuffers.wrap(input);

        assertEquals(false, parser.parse(buffer));

        assertEquals(remaining, buffer.remaining());

        assertEquals(asList(), messages.collect());
    }

}
