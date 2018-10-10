package com.paritytrading.philadelphia.perf;

import static java.nio.charset.StandardCharsets.*;

import com.paritytrading.philadelphia.FIXCheckSums;
import java.nio.ByteBuffer;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Setup;

public class FIXCheckSumsBenchmark extends FIXBenchmark {

    private ByteBuffer buffer;

    @Setup(Level.Iteration)
    public void prepare() {
        String message = "8=FIX.4.2\u00019=55\u000135=1\u000134=15\u0001" +
            "49=initiator\u000156=acceptor\u000152=20150924-09:30:05.250\u0001" +
            "112=foo\u0001";

        buffer = ByteBuffer.allocateDirect(message.length());

        buffer.put(message.getBytes(US_ASCII));
        buffer.flip();
    }

    @Benchmark
    public void baseline() {
    }

    @Benchmark
    public long sum() {
        return FIXCheckSums.sum(buffer, 0, buffer.remaining());
    }

}
