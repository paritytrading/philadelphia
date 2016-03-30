package com.paritytrading.philadelphia;

import static com.paritytrading.philadelphia.ByteBuffers.*;
import static com.paritytrading.philadelphia.FIXTags.*;
import static org.junit.Assert.*;

import java.nio.ByteBuffer;
import org.junit.Before;
import org.junit.Test;

public class FIXFieldTest {

    FIXField field;

    ByteBuffer buffer;

    @Before
    public void setUp() {
        field = new FIXField(32);

        buffer = ByteBuffer.allocate(32);
    }

    @Test
    public void put() {
        field.setTag(SenderCompID);
        field.getValue().setString("initiator");
        field.put(buffer);

        buffer.flip();

        assertEquals("49=initiator\u0001", getString(buffer));
    }

    @Test
    public void putEmpty() {
        field.setTag(SenderCompID);
        field.put(buffer);

        buffer.flip();

        assertEquals("", getString(buffer));
    }

}
