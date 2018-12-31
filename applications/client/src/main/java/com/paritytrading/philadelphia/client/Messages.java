package com.paritytrading.philadelphia.client;

import com.paritytrading.philadelphia.FIXConnection;
import com.paritytrading.philadelphia.FIXConnectionStatusListener;
import com.paritytrading.philadelphia.FIXMessage;
import com.paritytrading.philadelphia.FIXMessageListener;
import java.util.ArrayList;
import java.util.List;

class Messages implements FIXMessageListener, FIXConnectionStatusListener {

    private final List<Message> messages;

    Messages() {
        messages = new ArrayList<>();
    }

    synchronized List<Message> collect() {
        return new ArrayList<>(messages);
    }

    @Override
    public void message(FIXMessage message) {
        add(message);
    }

    @Override
    public void close(FIXConnection connection, String message) {
    }

    @Override
    public void sequenceReset(FIXConnection connection) {
    }

    @Override
    public void tooLowMsgSeqNum(FIXConnection connection, long receivedMsgSeqNum, long expectedMsgSeqNum) {
    }

    @Override
    public void heartbeatTimeout(FIXConnection connection) {
    }

    @Override
    public void reject(FIXConnection connection, FIXMessage message) {
        add(message);
    }

    @Override
    public void logon(FIXConnection connection, FIXMessage message) {
        add(message);
    }

    @Override
    public void logout(FIXConnection connection, FIXMessage message) {
        add(message);
    }

    private void add(FIXMessage message) {
        add(Message.get(message));
    }

    private synchronized void add(Message message) {
        messages.add(message);
    }

}
