package com.paritytrading.philadelphia.client.message;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MessageTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void valid() {
        Message message = Message.get("35=1|1=foo|2=bar");

        assertEquals("35=1|1=foo|2=bar", message.toString());
    }

    @Test
    public void missingMsgType() {
        exception.expect(IllegalArgumentException.class);

        Message message = Message.get("1=foo|2=bar");
    }

}
