/*
 * Copyright 2026 Philadelphia authors
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

class FIXIntDecoder {

    static long decode(byte[] bytes, int offset, int length) {
        if (bytes[offset] == '-')
            return decodeNegative(bytes, offset, length);
        else
            return decodePositive(bytes, offset, length);
    }

    private static long decodePositive(byte[] bytes, int offset, int length) {
        int i = offset;

        long x = 0;

        while (i < offset + length) {
            byte b = bytes[i++];

            if (b < '0' || b > '9')
                notInt();

            x = 10 * x + b - '0';
        }

        return x;
    }

    private static long decodeNegative(byte[] bytes, int offset, int length) {
        int i = offset + 1;

        long x = 0;

        while (i < offset + length) {
            byte b = bytes[i++];

            if (b < '0' || b > '9')
                notInt();

            x = 10 * x + '0' - b;
        }

        return x;
    }

    private static void notInt() throws FIXValueFormatException {
        throw new FIXValueFormatException("Not an integer");
    }

}
