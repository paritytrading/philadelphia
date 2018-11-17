package com.paritytrading.philadelphia;

import static com.paritytrading.philadelphia.fix42.FIX42Enumerations.*;
import static com.paritytrading.philadelphia.fix42.FIX42MsgTypes.*;
import static com.paritytrading.philadelphia.fix42.FIX42Tags.*;

import com.paritytrading.philadelphia.FIXMessage;
import com.paritytrading.philadelphia.FIXMessageOverflowException;
import com.paritytrading.philadelphia.FIXValueOverflowException;
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

        message.addField(MsgType).setChar(OrderSingle);
        message.addField(SenderCompID).setString("initiator");
        message.addField(TargetCompID).setString("acceptor");
        message.addField(MsgSeqNum).setInt(2);
        message.addField(SendingTime).setString("20150924-09:30:05.250");
        message.addField(ClOrdID).setString("123");
        message.addField(HandlInst).setChar(HandlInstValues.AutomatedExecutionNoIntervention);
        message.addField(Symbol).setString("FOO");
        message.addField(Side).setChar(SideValues.Buy);
        message.addField(TransactTime).setString("20150924-09:30:05.250");
        message.addField(OrdType).setChar(OrdTypeValues.Limit);
        message.addField(Price).setFloat(150.25, 2);
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
