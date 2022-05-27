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

import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.List;

class FIXConnectionStatus<CHANNEL extends ReadableByteChannel & GatheringByteChannel> implements FIXConnectionStatusListener<CHANNEL> {

    private List<Event> events;

    FIXConnectionStatus() {
        this.events = new ArrayList<>();
    }

    List<Event> collect() {
        return events;
    }

    @Override
    public void close(FIXConnection<CHANNEL> connection, String message) {
        events.add(new Close(message));
    }

    @Override
    public void sequenceReset(FIXConnection<CHANNEL> connection) {
        events.add(new SequenceReset());
    }

    @Override
    public void tooLowMsgSeqNum(FIXConnection<CHANNEL> connection, long receivedMsgSeqNum, long expectedMsgSeqNum) {
        events.add(new TooLowMsgSeqNum(receivedMsgSeqNum, expectedMsgSeqNum));
    }

    @Override
    public void heartbeatTimeout(FIXConnection<CHANNEL> connection) {
        events.add(new HeartbeatTimeout());
    }

    @Override
    public void reject(FIXConnection<CHANNEL> connection, FIXMessage message) {
        events.add(new Reject());
    }

    @Override
    public void logon(FIXConnection<CHANNEL> connection, FIXMessage message) {
        events.add(new Logon());
    }

    @Override
    public void logout(FIXConnection<CHANNEL> connection, FIXMessage message) {
        events.add(new Logout());
    }

    interface Event {
    }

    static class Close extends Value implements Event {
        final String message;

        Close(String message) {
            this.message = message;
        }
    }

    static class SequenceReset extends Value implements Event {
    }

    static class TooLowMsgSeqNum extends Value implements Event {
        final long receivedMsgSeqNum;
        final long expectedMsgSeqNum;

        TooLowMsgSeqNum(long receivedMsgSeqNum, long expectedMsgSeqNum) {
            this.receivedMsgSeqNum = receivedMsgSeqNum;
            this.expectedMsgSeqNum = expectedMsgSeqNum;
        }
    }

    static class HeartbeatTimeout extends Value implements Event {
    }

    static class Reject extends Value implements Event {
    }

    static class Logon extends Value implements Event {
    }

    static class Logout extends Value implements Event {
    }

}
