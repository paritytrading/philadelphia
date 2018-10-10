package com.paritytrading.philadelphia.perf;

import com.paritytrading.philadelphia.FIXTimestamps;
import org.joda.time.MutableDateTime;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Setup;

public class FIXTimestampsBenchmark extends FIXBenchmark {

    private StringBuilder builder;

    private MutableDateTime timestamp;

    @Setup(Level.Iteration)
    public void prepare() {
        builder = new StringBuilder(21);

        timestamp = new MutableDateTime(2015, 9, 24, 9, 30, 5, 250);
    }

    @Benchmark
    public void baseline() {
    }

    @Benchmark
    public StringBuilder append() {
        builder.setLength(0);

        FIXTimestamps.append(timestamp, builder);

        return builder;
    }

}
