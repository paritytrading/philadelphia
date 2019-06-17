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

import java.io.IOException;
import java.nio.ByteBuffer;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Setup;

public class FIXMessageParserBenchmark extends FIXBenchmark {

    private ByteBuffer buffer;

    private FIXMessageParser messageParser;

    @Setup(Level.Iteration)
    public void prepare() {
        FIXMessage message = new FIXMessage(64, 64);

        format(message);

        buffer = ByteBuffer.allocateDirect(1024);

        message.put(buffer);

        buffer.flip();

        FIXConfig fixConfig = new FIXConfig.Builder().build();

        messageParser = new FIXMessageParser(fixConfig, listener -> {});
    }

    private void format(FIXMessage message) {
        message.addField(BeginString).setString("FIX.4.2");
        message.addField(BodyLength).setInt(74);
        message.addField(MsgType).setChar(OrderSingle);
        message.addField(SenderCompID).setString("initiator");
        message.addField(TargetCompID).setString("acceptor");
        message.addField(MsgSeqNum).setInt(2);
        message.addField(ClOrdID).setString("123");
        message.addField(HandlInst).setChar(HandlInstValues.AutomatedExecutionNoIntervention);
        message.addField(Symbol).setString("FOO");
        message.addField(Side).setChar(SideValues.Buy);
        message.addField(OrdType).setChar(OrdTypeValues.Limit);
        message.addField(Price).setFloat(150.25, 2);
        message.addField(CheckSum).setCheckSum(75);
    }

    @Benchmark
    public void baseline() {
    }

    @Benchmark
    public boolean parse() throws IOException {
        boolean success = messageParser.parse(buffer);

        buffer.flip();

        return success;
    }
}
