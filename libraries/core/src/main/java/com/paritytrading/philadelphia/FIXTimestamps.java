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

import org.joda.time.ReadableDateTime;

/**
 * Utilities for working with timestamps.
 */
public class FIXTimestamps {

    private static final ThreadLocal<char[]> BUFFER = ThreadLocal.withInitial(() -> new char[21]);

    private FIXTimestamps() {
    }

    /**
     * Append a timestamp to a string builder.
     *
     * @param t a timestamp
     * @param s a string builder
     */
    public static void append(ReadableDateTime t, StringBuilder s) {
        char[] buffer = BUFFER.get();

        setDigits(buffer, t.getYear(), 0, 4);
        setDigits(buffer, t.getMonthOfYear(), 4, 2);
        setDigits(buffer, t.getDayOfMonth(), 6, 2);
        buffer[8] = '-';
        setDigits(buffer, t.getHourOfDay(), 9, 2);
        buffer[11] = ':';
        setDigits(buffer, t.getMinuteOfHour(), 12, 2);
        buffer[14] = ':';
        setDigits(buffer, t.getSecondOfMinute(), 15, 2);
        buffer[17] = '.';
        setDigits(buffer, t.getMillisOfSecond(), 18, 3);

        s.append(buffer);
    }

    private static void setDigits(char[] buffer, int i, int offset, int digits) {
        while (digits-- > 0) {
            buffer[offset + digits] = (char)('0' + i % 10);

            i /= 10;
        }
    }

}
