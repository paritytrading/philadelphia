package com.paritytrading.philadelphia.perf;

import static java.nio.charset.StandardCharsets.*;

import com.paritytrading.philadelphia.FIXTags;
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
import org.openjdk.jmh.annotations.TearDown;

@State(Scope.Thread)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@BenchmarkMode(Mode.SampleTime)
public class FIXTagsBenchmark {

    private ByteBuffer buffer;

    @Setup(Level.Iteration)
    public void prepare() {
        buffer = ByteBuffer.wrap("123=".getBytes(US_ASCII));
    }

    @Benchmark
    public long get() {
        long tag = FIXTags.get(buffer);

        buffer.flip();

        return tag;
    }

    @Benchmark
    public void put() {
        FIXTags.put(buffer, 123);

        buffer.flip();
    }

}
