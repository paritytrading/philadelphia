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

import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;

/**
 * Utilities for working with checksums.
 */
public class FIXCheckSums {

    private FIXCheckSums() {
    }

    /**
     * Return the sum of bytes in a buffer.
     *
     * @param buffer a buffer
     * @param offset the offset
     * @param length the length
     * @return the sum of bytes in the buffer
     * @throws BufferUnderflowException if the length from the offset exceeds
     *   the limit of the buffer
     */
    public static long sum(ByteBuffer buffer, int offset, int length) {
        long sum = 0;

        for (int i = offset; i < offset + length; i++)
            sum += buffer.get(i);

        return sum;
    }

}
