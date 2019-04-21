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
