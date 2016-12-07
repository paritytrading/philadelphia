package com.paritytrading.philadelphia;

import java.util.ArrayList;
import java.util.List;

class TestMessages implements TestMessageListener {

    private List<String> messages;

    public TestMessages() {
        this.messages = new ArrayList<>();
    }

    public List<String> collect() {
        return messages;
    }

    @Override
    public void message(String message) {
        messages.add(message);
    }
}
