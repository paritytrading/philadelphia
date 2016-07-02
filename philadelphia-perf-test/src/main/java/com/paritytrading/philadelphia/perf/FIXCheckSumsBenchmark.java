package com.paritytrading.philadelphia.perf;

import static java.nio.charset.StandardCharsets.*;

import com.paritytrading.philadelphia.FIXCheckSums;
import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;
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
@BenchmarkMode(Mode.SampleTime)
public class FIXCheckSumsBenchmark {

    private ByteBuffer buffer;

    @Setup(Level.Iteration)
    public void prepare() {
        String message = "8=FIX.4.2\u00019=55\u000135=1\u000134=15\u0001" +
            "49=initiator\u000156=acceptor\u000152=20150924-09:30:05.250\u0001" +
            "112=foo\u0001";

        buffer = ByteBuffer.wrap(message.getBytes(US_ASCII));
    }

    @Benchmark
    public long sum() {
        return FIXCheckSums.sum(buffer, 0, buffer.remaining());
    }

}
