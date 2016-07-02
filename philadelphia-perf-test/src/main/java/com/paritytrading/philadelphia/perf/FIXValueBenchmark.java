package com.paritytrading.philadelphia.perf;

import com.paritytrading.philadelphia.FIXValue;
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
public class FIXValueBenchmark {

    private StringBuilder string;

    private MutableDateTime date;

    private MutableDateTime timeOnly;

    private MutableDateTime timestamp;

    private FIXValue charValue;

    private FIXValue intValue;

    private FIXValue floatValue;

    private FIXValue stringValue;

    private FIXValue dateValue;

    private FIXValue timeOnlyValue;

    private FIXValue timestampValue;

    @Setup(Level.Iteration)
    public void prepare() {
        string = new StringBuilder(32);

        date = new MutableDateTime(2015, 9, 24, 0, 0, 0, 0);

        timeOnly = new MutableDateTime(2015, 9, 24, 9, 30, 5, 250);

        timestamp = new MutableDateTime(2015, 9, 24, 9, 30, 5, 250);

        charValue = new FIXValue(32);
        charValue.setChar('Y');

        intValue = new FIXValue(32);
        intValue.setInt(123);

        floatValue = new FIXValue(32);
        floatValue.setFloat(12.30, 2);

        stringValue = new FIXValue(32);
        stringValue.setString("FOO");

        dateValue = new FIXValue(32);
        dateValue.setDate(date);

        timeOnlyValue = new FIXValue(32);
        timeOnlyValue.setTimeOnly(timeOnly, true);

        timestampValue = new FIXValue(32);
        timestampValue.setTimestamp(timestamp, true);
    }

    @Benchmark
    public char asChar() {
        return charValue.asChar();
    }

    @Benchmark
    public void setChar() {
        charValue.setChar('Y');
    }

    @Benchmark
    public long asInt() {
        return intValue.asInt();
    }

    @Benchmark
    public void setInt() {
        intValue.setInt(123);
    }

    @Benchmark
    public double asFloat() {
        return floatValue.asFloat();
    }

    @Benchmark
    public void setFloat() {
        floatValue.setFloat(12.30, 2);
    }

    @Benchmark
    public StringBuilder asString() {
        stringValue.asString(string);

        return string;
    }

    @Benchmark
    public void setString() {
        stringValue.setString("FOO");
    }

    @Benchmark
    public MutableDateTime asDate() {
        dateValue.asDate(date);

        return date;
    }

    @Benchmark
    public void setDate() {
        dateValue.setDate(date);
    }

    @Benchmark
    public MutableDateTime asTimeOnly() {
        timeOnlyValue.asTimeOnly(timeOnly);

        return timeOnly;
    }

    @Benchmark
    public void setTimeOnly() {
        timeOnlyValue.setTimeOnly(timeOnly, true);
    }

    @Benchmark
    public MutableDateTime asTimestamp() {
        timestampValue.asTimestamp(timestamp);

        return timestamp;
    }

    @Benchmark
    public void setTimestamp() {
        timestampValue.setTimestamp(timestamp, true);
    }

}
