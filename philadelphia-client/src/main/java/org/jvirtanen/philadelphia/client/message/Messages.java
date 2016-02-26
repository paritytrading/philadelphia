package org.jvirtanen.philadelphia.client.message;

import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.impl.factory.Lists;
import org.jvirtanen.philadelphia.FIXMessage;
import org.jvirtanen.philadelphia.FIXMessageListener;
import org.jvirtanen.philadelphia.FIXSession;
import org.jvirtanen.philadelphia.FIXStatusListener;

public class Messages implements FIXMessageListener, FIXStatusListener {

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
    public void close(FIXSession session, String message) {
    }

    @Override
    public void sequenceReset(FIXSession session) {
    }

    @Override
    public void tooLowMsgSeqNum(FIXSession session, long receivedMsgSeqNum, long expectedMsgSeqNum) {
    }

    @Override
    public void heartbeatTimeout(FIXSession session) {
    }

    @Override
    public void reject(FIXSession session, FIXMessage message) {
        add(message);
    }

    @Override
    public void logon(FIXSession session, FIXMessage message) {
        add(message);
    }

    @Override
    public void logout(FIXSession session, FIXMessage message) {
        add(message);
    }

    private void add(FIXMessage message) {
        messages = messages.newWith(Message.get(message));
    }

}
