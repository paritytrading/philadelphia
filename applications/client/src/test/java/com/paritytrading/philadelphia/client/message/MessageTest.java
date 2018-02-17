package com.paritytrading.philadelphia.client.message;

import static org.junit.Assert.*;

import org.junit.Test;

public class MessageTest {

    @Test
    public void valid() {
        Message message = Message.get("35=1|1=foo|2=bar");

        assertEquals("35=1|1=foo|2=bar", message.toString());
    }

    @Test(expected=IllegalArgumentException.class)
    public void missingMsgType() {
        Message.get("1=foo|2=bar");
    }

}
