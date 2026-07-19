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

import static java.nio.charset.StandardCharsets.*;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigInteger;
import org.junit.jupiter.api.Test;

class FIXIntDecoderTest {

    @Test
    void minValue() {
        assertEquals(Long.MIN_VALUE, decode("-9223372036854775808"));
    }

    @Test
    void minusOneHundredTwentyThree() {
        assertEquals(-123, decode("-123"));
    }

    @Test
    void minusOne() {
        assertEquals(-1, decode("-1"));
    }

    @Test
    void minusZero() {
        assertEquals(0, decode("-0"));
    }

    @Test
    void zero() {
        assertEquals(0, decode("0"));
    }

    @Test
    void one() {
        assertEquals(1, decode("1"));
    }

    @Test
    void oneHundredTwentyThree() {
        assertEquals(123, decode("123"));
    }

    @Test
    void maxValue() {
        assertEquals(Long.MAX_VALUE, decode("9223372036854775807"));
    }

    @Test
    void notInt() {
        assertThrows(FIXValueFormatException.class, () -> decode("FOO"));
    }

    @Test
    void positiveAdditionOverflow() {
        assertTooLargeInt(BigInteger.valueOf(Long.MAX_VALUE).add(BigInteger.ONE));
    }

    @Test
    void positiveMultiplicationOverflow() {
        assertTooLargeInt(BigInteger.valueOf(Long.MAX_VALUE).add(BigInteger.TEN));
    }

    @Test
    void positiveLengthOverflow() {
        assertTooLargeInt(BigInteger.valueOf(Long.MAX_VALUE).multiply(BigInteger.TEN));
    }

    @Test
    void negativeAdditionOverflow() {
        assertTooSmallInt(BigInteger.valueOf(Long.MIN_VALUE).subtract(BigInteger.ONE));
    }

    @Test
    void negativeMultiplicationOverflow() {
        assertTooSmallInt(BigInteger.valueOf(Long.MIN_VALUE).subtract(BigInteger.TEN));
    }

    @Test
    void negativeLengthOverflow() {
        assertTooSmallInt(BigInteger.valueOf(Long.MIN_VALUE).multiply(BigInteger.TEN));
    }

    private static long decode(String value) {
        byte[] bytes = (">" + value + "<").getBytes(US_ASCII);

        return FIXIntDecoder.decode(bytes, 1, bytes.length - 2);
    }

    private static void assertTooLargeInt(BigInteger value) {
        assertMessage("Too large integer", value.toString());
    }

    private static void assertTooSmallInt(BigInteger value) {
        assertMessage("Too small integer", value.toString());
    }

    private static void assertMessage(String message, String value) {
        FIXValueFormatException exception = assertThrows(FIXValueFormatException.class,
                () -> decode(value));

        assertEquals(message, exception.getMessage());
    }

}
