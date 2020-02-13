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

import java.io.IOException;
import java.nio.ByteBuffer;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Setup;

public class FIXMessageParserBenchmark extends FIXBenchmark {

    private static final String MESSAGE = "8=FIX.4.2\u00019=74\u000135=D\u000149=initiator\u0001" +
            "56=acceptor\u000134=2\u000111=123\u000121=1\u000155=FOO\u000154=1\u000140=2\u0001" +
            "44=150.25\u000110=075\u0001";

    private static final FIXConfig CHECK_SUM_ENABLED  = new FIXConfig.Builder().build();
    private static final FIXConfig CHECK_SUM_DISABLED = new FIXConfig.Builder().setCheckSumEnabled(false).build();

    private ByteBuffer buffer;

    private FIXMessageParser checkSumEnabled;
    private FIXMessageParser checkSumDisabled;

    @Setup(Level.Iteration)
    public void prepare() {
        buffer = ByteBuffer.allocateDirect(1024);

        buffer.put(MESSAGE.getBytes(US_ASCII));
        buffer.flip();

        checkSumEnabled  = new FIXMessageParser(CHECK_SUM_ENABLED,  listener -> {});
        checkSumDisabled = new FIXMessageParser(CHECK_SUM_DISABLED, listener -> {});
    }

    @Benchmark
    public void baseline() {
    }

    @Benchmark
    public boolean checkSumEnabled() throws IOException {
        boolean result = checkSumEnabled.parse(buffer);

        buffer.flip();

        return result;
    }

    @Benchmark
    public boolean checkSumDisabled() throws IOException {
        boolean result = checkSumDisabled.parse(buffer);

        buffer.flip();

        return result;
    }

}
