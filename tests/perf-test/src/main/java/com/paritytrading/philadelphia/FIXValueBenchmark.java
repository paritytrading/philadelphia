/*
 * Copyright 2015 Philadelphia authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.paritytrading.philadelphia;

import org.joda.time.MutableDateTime;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Setup;

public class FIXValueBenchmark extends FIXBenchmark {

    private StringBuilder string;

    private MutableDateTime date;

    private MutableDateTime timeOnly;

    private MutableDateTime timestamp;

    private FIXValue booleanValue;

    private FIXValue charValue;

    private FIXValue intValue;

    private FIXValue floatValue;

    private FIXValue stringValue;

    private FIXValue dateValue;

    private FIXValue timeOnlyValue;

    private FIXValue timestampValue;

    private FIXValue copyValue;

    @Setup(Level.Iteration)
    public void prepare() {
        string = new StringBuilder(32);

        date = new MutableDateTime(2015, 9, 24, 0, 0, 0, 0);

        timeOnly = new MutableDateTime(2015, 9, 24, 9, 30, 5, 250);

        timestamp = new MutableDateTime(2015, 9, 24, 9, 30, 5, 250);

        booleanValue = new FIXValue(64);
        booleanValue.setBoolean(true);

        charValue = new FIXValue(64);
        charValue.setChar('Y');

        intValue = new FIXValue(64);
        intValue.setInt(123);

        floatValue = new FIXValue(64);
        floatValue.setFloat(12.30, 2);

        stringValue = new FIXValue(64);
        stringValue.setString("FOO");

        dateValue = new FIXValue(64);
        dateValue.setDate(date);

        timeOnlyValue = new FIXValue(64);
        timeOnlyValue.setTimeOnly(timeOnly, true);

        timestampValue = new FIXValue(64);
        timestampValue.setTimestamp(timestamp, true);

        copyValue = new FIXValue(64);
    }

    @Benchmark
    public void baseline() {
    }

    @Benchmark
    public boolean asBoolean() {
        return booleanValue.asBoolean();
    }

    @Benchmark
    public void setBoolean() {
        booleanValue.setBoolean(true);
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

    @Benchmark
    public void setToValue() {
        copyValue.set(timestampValue);
    }

}
