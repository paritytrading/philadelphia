package com.paritytrading.philadelphia.client.message;

import com.paritytrading.philadelphia.FIXConnection;
import com.paritytrading.philadelphia.FIXConnectionStatusListener;
import com.paritytrading.philadelphia.FIXMessage;
import com.paritytrading.philadelphia.FIXMessageListener;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.impl.factory.Lists;

public class Messages implements FIXMessageListener, FIXConnectionStatusListener {

    private volatile ImmutableList<Message> messages;

    public Messages() {
        messages = Lists.immutable.with();
    }

    public ImmutableList<Message> collect() {
        return messages;
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
        messages = messages.newWith(Message.get(message));
    }

}
