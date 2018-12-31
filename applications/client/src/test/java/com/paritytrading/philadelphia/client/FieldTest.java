package com.paritytrading.philadelphia.client;

import static org.junit.Assert.*;

import org.junit.Test;

public class FieldTest {

    @Test
    public void valid() {
        Field field = Field.get("1=foo");

        assertEquals("1=foo", field.toString());
    }

    @Test
    public void longTag() {
        Field.get("12345=foo");
    }

    @Test(expected=IllegalArgumentException.class)
    public void missingTag() {
        Field.get("=foo");
    }

    @Test(expected=IllegalArgumentException.class)
    public void tooLongTag() {
        Field.get("123456=foo");
    }

    @Test(expected=IllegalArgumentException.class)
    public void invalidTag() {
        Field.get("foo=bar");
    }

    @Test(expected=IllegalArgumentException.class)
    public void missingValue() {
        Field.get("foo=");
    }

}
