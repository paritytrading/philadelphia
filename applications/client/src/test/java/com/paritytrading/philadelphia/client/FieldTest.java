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

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FieldTest {

    @Test
    void valid() {
        Field field = Field.get("1=foo");

        assertEquals("1=foo", field.toString());
    }

    @Test
    void longTag() {
        Field.get("12345=foo");
    }

    @Test
    void missingTag() {
        assertThrows(IllegalArgumentException.class, () -> Field.get("=foo"));
    }

    @Test
    void tooLongTag() {
        assertThrows(IllegalArgumentException.class, () -> Field.get("123456=foo"));
    }

    @Test
    void invalidTag() {
        assertThrows(IllegalArgumentException.class, () -> Field.get("foo=bar"));
    }

    @Test
    void missingValue() {
        assertThrows(IllegalArgumentException.class, () -> Field.get("123="));
    }

}
