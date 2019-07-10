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

import static com.paritytrading.philadelphia.fix42.FIX42Enumerations.*;
import static com.paritytrading.philadelphia.fix42.FIX42MsgTypes.*;
import static com.paritytrading.philadelphia.fix42.FIX42Tags.*;

import java.nio.ByteBuffer;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Setup;

public class FIXMessageBenchmark extends FIXBenchmark {

    private FIXMessage message;

    private ByteBuffer buffer;

    @Setup(Level.Iteration)
    public void prepare() {
        message = new FIXMessage(32, 32);

        format();

        buffer = ByteBuffer.allocateDirect(1024);

        message.put(buffer);

        buffer.flip();
    }

    private void format() {
        message.reset();

        message.addChar(MsgType, OrderSingle);
        message.addString(SenderCompID, "initiator");
        message.addString(TargetCompID, "acceptor");
        message.addInt(MsgSeqNum, 2);
        message.addString(SendingTime, "20150924-09:30:05.250");
        message.addString(ClOrdID, "123");
        message.addChar(HandlInst, HandlInstValues.AutomatedExecutionNoIntervention);
        message.addString(Symbol, "FOO");
        message.addChar(Side, SideValues.Buy);
        message.addString(TransactTime, "20150924-09:30:05.250");
        message.addChar(OrdType, OrdTypeValues.Limit);
        message.addFloat(Price, 150.25, 2);
    }

    @Benchmark
    public void baseline() {
    }

    @Benchmark
    public FIXMessage get() throws FIXMessageOverflowException, FIXValueOverflowException {
        message.get(buffer);

        buffer.flip();

        return message;
    }

    @Benchmark
    public void put() {
        message.put(buffer);

        buffer.flip();
    }

    @Benchmark
    public void formatAndPut() {
        format();

        message.put(buffer);

        buffer.flip();
    }

}
