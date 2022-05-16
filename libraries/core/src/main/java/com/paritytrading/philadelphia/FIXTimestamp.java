/*
 * Copyright 2022 Philadelphia authors
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

import static java.util.Calendar.*;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * A timestamp container.
 */
public class FIXTimestamp {

    private final Calendar calendar;

    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;
    private int second;
    private int milli;

    /**
     * Construct a new instance representing the epoch of
     * 1970-01-01T00:00:00.000Z.
     */
    public FIXTimestamp() {
        this(1970, 1, 1, 0, 0, 0, 0);
    }

    /**
     * Construct a new instance.
     *
     * @param year the year
     * @param month the month, from 1 to 12
     * @param day the day, from 1 to 31
     * @param hour the hour, from 0 to 23
     * @param minute the minute, from 0 to 59
     * @param second the second, from 0 to 59
     * @param milli the millisecond, from 0 to 999
     */
    public FIXTimestamp(int year, int month, int day, int hour, int minute, int second, int milli) {
        this.calendar = new GregorianCalendar(TimeZone.getTimeZone("UTC"));

        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        this.milli = milli;
    }

    /**
     * Get the year.
     *
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * Set the year.
     *
     * @param year the year
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Get the month, from 1 to 12.
     *
     * @return the month
     */
    public int getMonth() {
        return month;
    }

    /**
     * Set the month, from 1 to 12.
     *
     * @param month the month
     */
    public void setMonth(int month) {
        this.month = month;
    }

    /**
     * Get the day, from 1 to 31.
     *
     * @return the day
     */
    public int getDay() {
        return day;
    }

    /**
     * Set the day, from 1 to 31.
     *
     * @param day the day
     */
    public void setDay(int day) {
        this.day = day;
    }

    /**
     * Get the hour, from 0 to 23.
     *
     * @return the hour
     */
    public int getHour() {
        return hour;
    }

    /**
     * Set the hour, from 0 to 23.
     *
     * @param hour the hour
     */
    public void setHour(int hour) {
        this.hour = hour;
    }

    /**
     * Get the minute, from 0 to 59.
     *
     * @return the minute
     */
    public int getMinute() {
        return minute;
    }

    /**
     * Set the minute, from 0 to 59.
     *
     * @param minute the minute
     */
    public void setMinute(int minute) {
        this.minute = minute;
    }

    /**
     * Get the second, from 0 to 59.
     *
     * @return the second
     */
    public int getSecond() {
        return second;
    }

    /**
     * Set the second, from 0 to 59.
     *
     * @param second the second
     */
    public void setSecond(int second) {
        this.second = second;
    }

    /**
     * Get the millisecond, from 0 to 999.
     *
     * @return the millisecond
     */
    public int getMilli() {
        return milli;
    }

    /**
     * Set the millisecond, from 0 to 999.
     *
     * @param milli the millisecond
     */
    public void setMilli(int milli) {
        this.milli = milli;
    }

    /**
     * Get the number of milliseconds from the epoch of 1970-01-01T00:00:00.000Z.
     *
     * @return the number of milliseconds from the epoch
     */
    public long getEpochMilli() {
        calendar.set(MILLISECOND, milli);
        calendar.set(year, month - 1, day, hour, minute, second);

        return calendar.getTimeInMillis();
    }

    /**
     * Set the number of milliseconds from the epoch of 1970-01-01T00:00:00.000Z.
     *
     * @param epochMilli the number of milliseconds from the epoch
     */
    public void setEpochMilli(long epochMilli) {
        calendar.setTimeInMillis(epochMilli);

        year = calendar.get(YEAR);
        month = calendar.get(MONTH) + 1;
        day = calendar.get(DAY_OF_MONTH);
        hour = calendar.get(HOUR_OF_DAY);
        minute = calendar.get(MINUTE);
        second = calendar.get(SECOND);
        milli = calendar.get(MILLISECOND);
    }

    /**
     * Returns true if the specified object is equal to this instance,
     * otherwise false.
     *
     * @return true if the specified object is equal to this instance,
     *     otherwise false
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;

        if (!(obj instanceof FIXTimestamp))
            return false;

        FIXTimestamp timestamp = (FIXTimestamp)obj;

        if (timestamp.year != year)
            return false;

        if (timestamp.month != month)
            return false;

        if (timestamp.day != day)
            return false;

        if (timestamp.hour != hour)
            return false;

        if (timestamp.minute != minute)
            return false;

        if (timestamp.second != second)
            return false;

        if (timestamp.milli != milli)
            return false;

        return true;
    }

    /**
     * Returns the hash code value for this instance.
     *
     * @return the hash code value for this instance
     */
    @Override
    public int hashCode() {
        return (year + (month << 16) + (day << 24))
            ^ (hour + (minute << 8) + (second << 16) + (milli << 24));
    }

    /**
     * Returns a string representation of this value.
     *
     * <p><strong>Note.</strong> This method allocates memory.</p>
     *
     * @return a string representation of this value
     */
    @Override
    public String toString() {
        return String.format("%04d%02d%02d-%02d:%02d:%02d.%03d",
                year, month, day, hour, minute, second, milli);
    }

}
