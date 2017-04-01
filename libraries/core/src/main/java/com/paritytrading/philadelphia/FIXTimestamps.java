package com.paritytrading.philadelphia;

import org.joda.time.ReadableDateTime;

/**
 * Utilities for working with timestamps.
 */
public class FIXTimestamps {

    private FIXTimestamps() {
    }

    /**
     * Append a timestamp to a string builder.
     *
     * @param t a timestamp
     * @param s a string builder
     */
    public static void append(ReadableDateTime t, StringBuilder s) {
        s.append(t.getYear());
        appendTwoDigits(t.getMonthOfYear(), s);
        appendTwoDigits(t.getDayOfMonth(), s);
        s.append('-');
        appendTwoDigits(t.getHourOfDay(), s);
        s.append(':');
        appendTwoDigits(t.getMinuteOfHour(), s);
        s.append(':');
        appendTwoDigits(t.getSecondOfMinute(), s);
        s.append('.');
        appendThreeDigits(t.getMillisOfSecond(), s);
    }

    private static void appendThreeDigits(int x, StringBuilder s) {
        if (x < 100)
            s.append('0');

        if (x < 10)
            s.append('0');

        s.append(x);
    }

    private static void appendTwoDigits(int x, StringBuilder s) {
        if (x < 10)
            s.append('0');

        s.append(x);
    }

}
