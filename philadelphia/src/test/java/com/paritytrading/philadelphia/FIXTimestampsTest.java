package com.paritytrading.philadelphia;

import static org.junit.Assert.*;

import org.joda.time.MutableDateTime;
import org.junit.Test;

public class FIXTimestampsTest {

    @Test
    public void format() {
        MutableDateTime timestamp = new MutableDateTime(2015, 9, 1, 9, 30, 5, 250);

        StringBuilder builder = new StringBuilder();

        FIXTimestamps.append(timestamp, builder);

        assertEquals("20150901-09:30:05.250", builder.toString());
    }

}
