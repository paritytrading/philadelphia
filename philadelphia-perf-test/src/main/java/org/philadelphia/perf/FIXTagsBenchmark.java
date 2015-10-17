package org.jvirtanen.philadelphia.perf;

import static java.nio.charset.StandardCharsets.*;

import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;
import org.jvirtanen.philadelphia.FIXTags;
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
public class FIXTagsBenchmark {

    private ByteBuffer buffer;

    @Setup(Level.Iteration)
    public void prepare() {
        buffer = ByteBuffer.wrap("123=".getBytes(US_ASCII));
    }

    @TearDown(Level.Invocation)
    public void tearDown() {
        buffer.flip();
    }

    @Benchmark
    @BenchmarkMode(Mode.SampleTime)
    public long get() {
        return FIXTags.get(buffer);
    }

    @Benchmark
    @BenchmarkMode(Mode.SampleTime)
    public void put() {
        FIXTags.put(buffer, 123);
    }

}
