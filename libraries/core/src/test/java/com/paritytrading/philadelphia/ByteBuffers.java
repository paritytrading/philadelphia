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

import static java.nio.charset.StandardCharsets.*;

import java.nio.ByteBuffer;

class ByteBuffers {

    public static String getString(ByteBuffer buffer) {
        return getString(buffer, buffer.remaining());
    }

    public static String getString(ByteBuffer buffer, int length) {
        byte[] bytes = new byte[length];

        buffer.get(bytes);

        return new String(bytes, US_ASCII);
    }

    public static ByteBuffer wrap(String s) {
        return ByteBuffer.wrap(s.getBytes(US_ASCII));
    }

}
