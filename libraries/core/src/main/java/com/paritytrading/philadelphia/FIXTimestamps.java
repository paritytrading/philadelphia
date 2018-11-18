package com.paritytrading.philadelphia;

import org.joda.time.ReadableDateTime;

class FIXTimestamps {

    private static final ThreadLocal<char[]> BUFFER = ThreadLocal.withInitial(() -> new char[21]);

    static void append(ReadableDateTime t, StringBuilder s) {
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

    static void setDigits(char[] buffer, int i, int offset, int digits) {
        for (int j = offset + digits - 1; j >= offset; j--) {
            buffer[j] = (char)('0' + i % 10);

            i /= 10;
        }
    }

}
