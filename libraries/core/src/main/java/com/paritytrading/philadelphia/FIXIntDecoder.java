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

    private static final int MAX_NEGATIVE_LENGTH = 20;
    private static final int MAX_POSITIVE_LENGTH = 19;

    static long decode(byte[] bytes, int offset, int length) {
        if (length == 0)
            notInt();

        if (bytes[offset] == '-') {
            if (length >= MAX_NEGATIVE_LENGTH)
                return decodeNegativeExact(bytes, offset, length);
            else
                return decodeNegative(bytes, offset, length);
        } else {
            if (length >= MAX_POSITIVE_LENGTH)
                return decodePositiveExact(bytes, offset, length);
            else
                return decodePositive(bytes, offset, length);
        }
    }

    private static long decodePositive(byte[] bytes, int offset, int length) {
        int i = offset;

        int endIndex = offset + length;

        long x = 0;

        while (i < endIndex) {
            byte b = bytes[i++];

            if (b < '0' || b > '9')
                notInt();

            x = 10 * x + b - '0';
        }

        return x;
    }

    private static long decodePositiveExact(byte[] bytes, int offset, int length) {
        if (length > MAX_POSITIVE_LENGTH)
            tooLargeInt();

        int i = offset;

        int endIndex = offset + length;

        long x = 0;

        while (i < endIndex) {
            byte b = bytes[i++];

            if (b < '0' || b > '9')
                notInt();

            try {
                x = Math.addExact(Math.multiplyExact(x, 10), b - '0');
            } catch (ArithmeticException e) {
                tooLargeInt();
            }
        }

        return x;
    }

    private static long decodeNegative(byte[] bytes, int offset, int length) {
        if (length < 2)
            notInt();

        int i = offset + 1;

        int endIndex = offset + length;

        long x = 0;

        while (i < endIndex) {
            byte b = bytes[i++];

            if (b < '0' || b > '9')
                notInt();

            x = 10 * x + '0' - b;
        }

        return x;
    }

    private static long decodeNegativeExact(byte[] bytes, int offset, int length) {
        if (length > MAX_NEGATIVE_LENGTH)
            tooSmallInt();

        int i = offset + 1;

        int endIndex = offset + length;

        long x = 0;

        while (i < endIndex) {
            byte b = bytes[i++];

            if (b < '0' || b > '9')
                notInt();

            try {
                x = Math.addExact(Math.multiplyExact(x, 10), '0' - b);
            } catch (ArithmeticException e) {
                tooSmallInt();
            }
        }

        return x;
    }

    private static void notInt() throws FIXValueFormatException {
        throw new FIXValueFormatException("Not an integer");
    }

    private static void tooLargeInt() throws FIXValueFormatException {
        throw new FIXValueFormatException("Too large integer");
    }

    private static void tooSmallInt() throws FIXValueFormatException {
        throw new FIXValueFormatException("Too small integer");
    }

}
