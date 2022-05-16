/*
 * Copyright 2022 Philadelphia authors
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
package com.paritytrading.philadelphia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FIXTimestampTest {

    @Test
    void epoch() {
        FIXTimestamp timestamp = new FIXTimestamp();

        assertEquals(0, timestamp.getEpochMilli());

        assertEquals(1970, timestamp.getYear());
        assertEquals(1, timestamp.getMonth());
        assertEquals(1, timestamp.getDay());
        assertEquals(0, timestamp.getHour());
        assertEquals(0, timestamp.getMinute());
        assertEquals(0, timestamp.getSecond());
        assertEquals(0, timestamp.getMilli());
        assertEquals("19700101-00:00:00.000", timestamp.toString());
    }

    @Test
    void setEpochMilli() {
        FIXTimestamp timestamp = new FIXTimestamp();

        timestamp.setEpochMilli(1650387150250L);

        assertEquals(2022, timestamp.getYear());
        assertEquals(4, timestamp.getMonth());
        assertEquals(19, timestamp.getDay());
        assertEquals(16, timestamp.getHour());
        assertEquals(52, timestamp.getMinute());
        assertEquals(30, timestamp.getSecond());
        assertEquals(250, timestamp.getMilli());
        assertEquals("20220419-16:52:30.250", timestamp.toString());
    }

}
