package com.paritytrading.philadelphia;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

class FIXMessages implements FIXMessageListener {

    private List<String> messages;

    private ByteBuffer buffer;

    public FIXMessages() {
        this.messages = new ArrayList<>();

        this.buffer = ByteBuffer.allocate(1024);
    }

    public List<String> collect() {
        return messages;
    }

    @Override
    public void message(FIXMessage message) {
        buffer.clear();
        message.put(buffer);
        buffer.flip();

        messages.add(ByteBuffers.getString(buffer));
    }

}
