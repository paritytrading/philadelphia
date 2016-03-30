package com.paritytrading.philadelphia.client.message;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class FieldTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void valid() {
        Field field = Field.get("1=foo");

        assertEquals("1=foo", field.toString());
    }

    @Test
    public void longTag() {
        Field.get("12345=foo");
    }

    @Test
    public void missingTag() {
        exception.expect(IllegalArgumentException.class);

        Field.get("=foo");
    }

    @Test
    public void tooLongTag() {
        exception.expect(IllegalArgumentException.class);

        Field.get("123456=foo");
    }

    @Test
    public void invalidTag() {
        exception.expect(IllegalArgumentException.class);

        Field.get("foo=bar");
    }

    @Test
    public void missingValue() {
        exception.expect(IllegalArgumentException.class);

        Field.get("foo=");
    }

}
