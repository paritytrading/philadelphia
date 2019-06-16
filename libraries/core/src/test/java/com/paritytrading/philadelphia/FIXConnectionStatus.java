/*
 * Copyright 2015 Philadelphia authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.paritytrading.philadelphia;

import java.util.ArrayList;
import java.util.List;

class FIXConnectionStatus implements FIXConnectionStatusListener {

    private List<Event> events;

    public FIXConnectionStatus() {
        this.events = new ArrayList<>();
    }

    public List<Event> collect() {
        return events;
    }

    @Override
    public void close(FIXConnection connection, String message) {
        events.add(new Close(message));
    }

    @Override
    public void sequenceReset(FIXConnection connection) {
        events.add(new SequenceReset());
    }

    @Override
    public void tooLowMsgSeqNum(FIXConnection connection, long receivedMsgSeqNum, long expectedMsgSeqNum) {
        events.add(new TooLowMsgSeqNum(receivedMsgSeqNum, expectedMsgSeqNum));
    }

    @Override
    public void heartbeatTimeout(FIXConnection connection) {
        events.add(new HeartbeatTimeout());
    }

    @Override
    public void reject(FIXConnection connection, FIXMessage message) {
        events.add(new Reject());
    }

    @Override
    public void logon(FIXConnection connection, FIXMessage message) {
        events.add(new Logon());
    }

    @Override
    public void logout(FIXConnection connection, FIXMessage message) {
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
