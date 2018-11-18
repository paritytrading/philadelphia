package com.paritytrading.philadelphia;

import java.nio.ByteBuffer;

class FIXCheckSums {

    public static long sum(ByteBuffer buffer, int offset, int length) {
        long sum = 0;

        for (int i = offset; i < offset + length; i++)
            sum += buffer.get(i);

        return sum;
    }

}
