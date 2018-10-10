package com.paritytrading.philadelphia.perf;

import com.paritytrading.philadelphia.FIXTags;
import java.nio.ByteBuffer;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Setup;

public class FIXTagsBenchmark extends FIXBenchmark {

    private ByteBuffer buffer;

    @Setup(Level.Iteration)
    public void prepare() {
        byte[] bytes = new byte[] { '1', '2', '3', '=' };

        buffer = ByteBuffer.allocateDirect(bytes.length);

        buffer.put(bytes);
        buffer.flip();
    }

    @Benchmark
    public void baseline() {
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
