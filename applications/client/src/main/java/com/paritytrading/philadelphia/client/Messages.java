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
