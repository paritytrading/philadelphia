package com.paritytrading.philadelphia;

/**
 * A time source.
 */
public interface Clock {

    /**
     * Get the current time in milliseconds.
     *
     * @return the current time in milliseconds
     * @see System#currentTimeMillis
     */
    long currentTimeMillis();

}
