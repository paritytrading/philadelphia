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

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Setup;

public class FIXIntDecoderBenchmark extends FIXBenchmark {

    private byte[] zeroBytes;
    private byte[] maxFastPathBytes;
    private byte[] maxValueBytes;

    @Setup(Level.Iteration)
    public void prepare() {
        zeroBytes = getBytes("0");
        maxFastPathBytes = getBytes("999999999999999999");
        maxValueBytes = getBytes(Long.toString(Long.MAX_VALUE));
    }

    @Benchmark
    public long decodeZero() {
        return decode(zeroBytes);
    }

    @Benchmark
    public long decodeMaxFastPath() {
        return decode(maxFastPathBytes);
    }

    @Benchmark
    public long decodeMaxValue() {
        return decode(maxValueBytes);
    }

    private static long decode(byte[] bytes) {
        return FIXIntDecoder.decode(bytes, 0, bytes.length);
    }

    private static byte[] getBytes(String value) {
        return value.getBytes(US_ASCII);
    }

}
