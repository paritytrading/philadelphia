package com.paritytrading.philadelphia;

class SystemClock implements Clock {

    public static final SystemClock INSTANCE = new SystemClock();

    @Override
    public long currentTimeMillis() {
        return System.currentTimeMillis();
    }

}
