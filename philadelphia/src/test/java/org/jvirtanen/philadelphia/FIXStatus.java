package org.jvirtanen.philadelphia;

import java.util.ArrayList;
import java.util.List;
import org.jvirtanen.value.Value;

class FIXStatus implements FIXStatusListener {

    private List<Event> events;

    public FIXStatus() {
        this.events = new ArrayList<>();
    }

    public List<Event> collect() {
        return events;
    }

    @Override
    public void close(FIXSession session, String message) {
        events.add(new Close(message));
    }

    @Override
    public void sequenceReset(FIXSession session) {
        events.add(new SequenceReset());
    }

    @Override
    public void tooLowMsgSeqNum(FIXSession session, long receivedMsgSeqNum, long expectedMsgSeqNum) {
        events.add(new TooLowMsgSeqNum(receivedMsgSeqNum, expectedMsgSeqNum));
    }

    @Override
    public void heartbeatTimeout(FIXSession session) {
        events.add(new HeartbeatTimeout());
    }

    @Override
    public void reject(FIXSession session, FIXMessage message) {
        events.add(new Reject());
    }

    @Override
    public void logon(FIXSession session, FIXMessage message) {
        events.add(new Logon());
    }

    @Override
    public void logout(FIXSession session, FIXMessage message) {
        events.add(new Logout());
    }

    public interface Event {
    }

    public static class Close extends Value implements Event {
        public final String message;

        public Close(String message) {
            this.message = message;
        }
    }

    public static class SequenceReset extends Value implements Event {
    }

    public static class TooLowMsgSeqNum extends Value implements Event {
        public final long receivedMsgSeqNum;
        public final long expectedMsgSeqNum;

        public TooLowMsgSeqNum(long receivedMsgSeqNum, long expectedMsgSeqNum) {
            this.receivedMsgSeqNum = receivedMsgSeqNum;
            this.expectedMsgSeqNum = expectedMsgSeqNum;
        }
    }

    public static class HeartbeatTimeout extends Value implements Event {
    }

    public static class Reject extends Value implements Event {
    }

    public static class Logon extends Value implements Event {
    }

    public static class Logout extends Value implements Event {
    }

}
