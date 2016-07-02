package com.paritytrading.philadelphia.perf;

import com.paritytrading.philadelphia.FIXTimestamps;
import java.util.concurrent.TimeUnit;
import org.joda.time.MutableDateTime;
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
public class FIXTimestampsBenchmark {

    private StringBuilder builder;

    private MutableDateTime timestamp;

    @Setup(Level.Iteration)
    public void prepare() {
        builder = new StringBuilder(32);

        timestamp = new MutableDateTime(2015, 9, 24, 9, 30, 5, 250);
    }

    @Benchmark
    public StringBuilder append() {
        builder.setLength(0);

        FIXTimestamps.append(timestamp, builder);

        return builder;
    }

}
