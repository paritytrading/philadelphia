package com.paritytrading.philadelphia;

import static java.nio.charset.StandardCharsets.*;

import java.nio.ByteBuffer;

class ByteBuffers {

    public static String getString(ByteBuffer buffer) {
        return getString(buffer, buffer.remaining());
    }

    public static String getString(ByteBuffer buffer, int length) {
        byte[] bytes = new byte[length];

        buffer.get(bytes);

        return new String(bytes, US_ASCII);
    }

    public static ByteBuffer wrap(String s) {
        return ByteBuffer.wrap(s.getBytes(US_ASCII));
    }

}
