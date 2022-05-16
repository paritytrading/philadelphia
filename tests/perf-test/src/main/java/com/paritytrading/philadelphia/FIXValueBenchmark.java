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

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Setup;

public class FIXValueBenchmark extends FIXBenchmark {

    private static final byte[] FOO = { 'F', 'O', 'O', };

    private StringBuilder string;

    private FIXTimestamp date;

    private FIXTimestamp timeOnly;

    private FIXTimestamp timestamp;

    private long dateMillis;

    private long timeOnlyMillis;

    private long timestampMillis;

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

        date = new FIXTimestamp(2015, 9, 24, 0, 0, 0, 0);

        timeOnly = new FIXTimestamp(2015, 9, 24, 9, 30, 5, 250);

        timestamp = new FIXTimestamp(2015, 9, 24, 9, 30, 5, 250);

        dateMillis = date.getEpochMilli();
        timeOnlyMillis = timeOnly.getEpochMilli();
        timestampMillis = timestamp.getEpochMilli();

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
        timeOnlyValue.setTimeOnlyMillis(timeOnly);

        timestampValue = new FIXValue(64);
        timestampValue.setTimestampMillis(timestamp);

        copyValue = new FIXValue(64);
    }

    @Benchmark
    public void baseline() {
    }

    @Benchmark
    public boolean contentEqualsByteArray() {
        return stringValue.contentEquals(FOO);
    }

    @Benchmark
    public boolean contentEqualsCharSequence() {
        return stringValue.contentEquals("FOO");
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
        string.setLength(0);
        string.append(stringValue);

        return string;
    }

    @Benchmark
    public void setString() {
        stringValue.setString("FOO");
    }

    @Benchmark
    public long asDate() {
        dateValue.asDate(date);

        return date.getEpochMilli();
    }

    @Benchmark
    public void setDate() {
        date.setEpochMilli(dateMillis);

        dateValue.setDate(date);
    }

    @Benchmark
    public long asTimeOnly() {
        timeOnlyValue.asTimeOnly(timeOnly);

        return timeOnly.getEpochMilli();
    }

    @Benchmark
    public void setTimeOnly() {
        timeOnly.setEpochMilli(timeOnlyMillis);

        timeOnlyValue.setTimeOnlySecs(timeOnly);
    }

    @Benchmark
    public long asTimestamp() {
        timestampValue.asTimestamp(timestamp);

        return timestamp.getEpochMilli();
    }

    @Benchmark
    public void setTimestamp() {
        timestamp.setEpochMilli(timestampMillis);

        timestampValue.setTimestampMillis(timestamp);
    }

    @Benchmark
    public void setToValue() {
        copyValue.set(timestampValue);
    }

}
