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
package com.paritytrading.philadelphia;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.ByteBuffer;
import org.junit.jupiter.api.Test;

class FIXTagsTest {

    @Test
    void get() {
        assertEquals(123, FIXTags.get(ByteBuffers.wrap("123=")));
    }

    @Test
    void getPartial() {
        assertEquals(0, FIXTags.get(ByteBuffers.wrap("123")));
    }

    @Test
    void put() {
        ByteBuffer buffer = ByteBuffer.allocateDirect(4);

        FIXTags.put(buffer, 123);
        buffer.flip();

        assertEquals("123=", ByteBuffers.getString(buffer));
    }

}
