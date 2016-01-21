package org.jvirtanen.philadelphia.perf;

import static org.jvirtanen.philadelphia.fix42.FIX42MsgTypes.OrderSingle;
import static org.jvirtanen.philadelphia.fix42.FIX42Tags.ClOrdID;
import static org.jvirtanen.philadelphia.fix42.FIX42Tags.HandlInst;
import static org.jvirtanen.philadelphia.fix42.FIX42Tags.MsgSeqNum;
import static org.jvirtanen.philadelphia.fix42.FIX42Tags.MsgType;
import static org.jvirtanen.philadelphia.fix42.FIX42Tags.OrdType;
import static org.jvirtanen.philadelphia.fix42.FIX42Tags.Price;
import static org.jvirtanen.philadelphia.fix42.FIX42Tags.SenderCompID;
import static org.jvirtanen.philadelphia.fix42.FIX42Tags.SendingTime;
import static org.jvirtanen.philadelphia.fix42.FIX42Tags.Side;
import static org.jvirtanen.philadelphia.fix42.FIX42Tags.Symbol;
import static org.jvirtanen.philadelphia.fix42.FIX42Tags.TargetCompID;
import static org.jvirtanen.philadelphia.fix42.FIX42Tags.TransactTime;

import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

import org.jvirtanen.philadelphia.FIXMessage;
import org.jvirtanen.philadelphia.FIXMessageOverflowException;
import org.jvirtanen.philadelphia.FIXValueOverflowException;
import org.jvirtanen.philadelphia.fix42.FIX42Enumerations.HandlInstValues;
import org.jvirtanen.philadelphia.fix42.FIX42Enumerations.OrdTypeValues;
import org.jvirtanen.philadelphia.fix42.FIX42Enumerations.SideValues;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

@State(Scope.Thread)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class FIXMessageBenchmark {

    private FIXMessage message;

    private ByteBuffer buffer;

    @Setup(Level.Iteration)
    public void prepare() {
        message = new FIXMessage(32, 32);

        format();

        buffer = ByteBuffer.allocate(1024);

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
    @BenchmarkMode(Mode.SampleTime)
    public FIXMessage get() throws FIXMessageOverflowException, FIXValueOverflowException {
        message.get(buffer);

        buffer.flip();

        return message;
    }

    @Benchmark
    @BenchmarkMode(Mode.SampleTime)
    public void put() {
        message.put(buffer);

        buffer.flip();
    }

    @Benchmark
    @BenchmarkMode(Mode.SampleTime)
    public void formatAndPut() {
        format();

        message.put(buffer);

        buffer.flip();
    }

}
