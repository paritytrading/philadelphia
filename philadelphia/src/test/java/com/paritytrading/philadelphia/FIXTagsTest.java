package com.paritytrading.philadelphia;

import static org.junit.Assert.*;

import java.nio.ByteBuffer;
import org.junit.Test;

public class FIXTagsTest {

    @Test
    public void get() {
        assertEquals(123, FIXTags.get(ByteBuffers.wrap("123=")));
    }

    @Test
    public void getPartial() {
        assertEquals(0, FIXTags.get(ByteBuffers.wrap("123")));
    }

    @Test
    public void put() {
        ByteBuffer buffer = ByteBuffer.allocate(4);

        FIXTags.put(buffer, 123);
        buffer.flip();

        assertEquals("123=", ByteBuffers.getString(buffer));
    }

}
