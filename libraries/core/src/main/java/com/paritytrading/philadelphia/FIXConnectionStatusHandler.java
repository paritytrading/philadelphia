/*
 * Copyright 2022 Philadelphia authors
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

import static com.paritytrading.philadelphia.FIX.*;
import static com.paritytrading.philadelphia.FIXMsgTypes.*;
import static com.paritytrading.philadelphia.FIXSessionRejectReasons.*;
import static com.paritytrading.philadelphia.FIXTags.*;

import java.io.IOException;

class FIXConnectionStatusHandler implements FIXMessageListener {

    private final FIXConnection connection;

    private final FIXMessageListener listener;

    private final FIXConnectionStatusListener statusListener;

    private final FIXMessage adminMessage;

    FIXConnectionStatusHandler(FIXConfig config, FIXConnection connection, FIXMessageListener listener, FIXConnectionStatusListener statusListener) {
        this.connection = connection;

        this.listener = listener;

        this.statusListener = statusListener;

        this.adminMessage = new FIXMessage(ADMIN_MESSAGE_MAX_FIELD_COUNT, config.getFieldCapacity());
    }

    @Override
    public void message(FIXMessage message) throws IOException {
        long msgSeqNum = message.getMsgSeqNum();
        if (msgSeqNum == 0) {
            msgSeqNumNotFound();
            return;
        }

        FIXValue msgType = message.valueOf(MsgType);
        if (msgType == null) {
            msgTypeNotFound();
            return;
        }

        if (msgType.byteAt(0) == SequenceReset && msgType.length() == 1) {
            if (handleSequenceReset(message))
                return;
        }

        if (msgSeqNum != connection.getInMsgSeqNum()) {
            handleMsgSeqNum(message, msgType, msgSeqNum);
            return;
        }

        connection.incrementInMsgSeqNum();

        if (msgType.length() != 1) {
            listener.message(message);
            return;
        }

        switch (msgType.byteAt(0)) {
        case Heartbeat:
            break;
        case TestRequest:
            handleTestRequest(message);
            break;
        case ResendRequest:
            handleResendRequest(message);
            break;
        case Reject:
            handleReject(message);
            break;
        case Logout:
            handleLogout(message);
            break;
        case Logon:
            handleLogon(message);
            break;
        default:
            listener.message(message);
            break;
        }
    }

    private void handleMsgSeqNum(FIXMessage message, FIXValue msgType, long msgSeqNum) throws IOException {
        long rxMsgSeqNum = connection.getInMsgSeqNum();

        if (msgSeqNum < rxMsgSeqNum)
            handleTooLowMsgSeqNum(message, msgType, msgSeqNum);
        else
            sendResendRequest(rxMsgSeqNum);
    }

    private void handleTooLowMsgSeqNum(FIXMessage message, FIXValue msgType, long msgSeqNum) throws IOException {
        long rxMsgSeqNum = connection.getInMsgSeqNum();

        if (msgType.contentEquals(Logout)) {
            handleLogout(message);
        } else if (!msgType.contentEquals(SequenceReset)) {
            FIXValue possDupFlag = message.valueOf(PossDupFlag);

            if (possDupFlag == null || possDupFlag.asBoolean() == false)
                statusListener.tooLowMsgSeqNum(connection, msgSeqNum, rxMsgSeqNum);
        }
    }

    private void handleTestRequest(FIXMessage message) throws IOException {
        FIXValue testReqId = message.valueOf(TestReqID);
        if (testReqId == null) {
            connection.sendReject(message.getMsgSeqNum(), RequiredTagMissing, "TestReqID(112) not found");
            return;
        }

        sendHeartbeat(testReqId);
    }

    private void handleResendRequest(FIXMessage message) throws IOException {
        FIXValue value;

        value = message.valueOf(BeginSeqNo);
        if (value == null) {
            connection.sendReject(message.getMsgSeqNum(), RequiredTagMissing, "BeginSeqNo(7) not found");
            return;
        }

        long beginSeqNo = value.asInt();

        value = message.valueOf(EndSeqNo);
        if (value == null) {
            connection.sendReject(message.getMsgSeqNum(), RequiredTagMissing, "EndSeqNo(16) not found");
            return;
        }

        long endSeqNo = value.asInt();
        long txMsgSeqNum = connection.getOutMsgSeqNum();

        if (beginSeqNo > txMsgSeqNum) {
            connection.sendReject(message.getMsgSeqNum(), ValueIsIncorrect, "BeginSeqNo(7) too high");
            return;
        }

        long newSeqNo = endSeqNo == 0 ? txMsgSeqNum : Math.min(endSeqNo + 1, txMsgSeqNum);

        sendSequenceReset(beginSeqNo, newSeqNo);
    }

    private void handleReject(FIXMessage message) throws IOException {
        statusListener.reject(connection, message);
    }

    private boolean handleSequenceReset(FIXMessage message) throws IOException {
        long rxMsgSeqNum = connection.getInMsgSeqNum();

        FIXValue value = message.valueOf(NewSeqNo);
        if (value == null) {
            connection.sendReject(message.getMsgSeqNum(), RequiredTagMissing, "NewSeqNo(36) not found");
            return true;
        }

        long newSeqNo = value.asInt();
        if (newSeqNo < rxMsgSeqNum) {
            connection.sendReject(message.getMsgSeqNum(), ValueIsIncorrect, "NewSeqNo(36) too low");
            return true;
        }

        connection.setInMsgSeqNum(newSeqNo);

        FIXValue gapFillFlag = message.valueOf(GapFillFlag);
        boolean reset = gapFillFlag == null || gapFillFlag.asBoolean() == false;

        if (reset)
            statusListener.sequenceReset(connection);

        return reset;
    }

    private void handleLogout(FIXMessage message) throws IOException {
        statusListener.logout(connection, message);
    }

    private void handleLogon(FIXMessage message) throws IOException {
        if (connection.getSenderCompID().isEmpty()) {
            FIXValue value = message.valueOf(TargetCompID);
            if (value == null) {
                statusListener.close(connection, "SenderCompID(49) not found");
                return;
            }

            connection.setSenderCompID(value.toString());
        }

        if (connection.getTargetCompID().isEmpty()) {
            FIXValue value = message.valueOf(SenderCompID);
            if (value == null) {
                statusListener.close(connection, "TargetCompID(56) not found");
                return;
            }

            connection.setTargetCompID(value.toString());
        }

        statusListener.logon(connection, message);
    }

    private void sendHeartbeat(FIXValue testReqId) throws IOException {
        connection.prepare(adminMessage, Heartbeat);

        adminMessage.addField(TestReqID).set(testReqId);

        connection.send(adminMessage);
    }

    private void sendResendRequest(long beginSeqNo) throws IOException {
        connection.prepare(adminMessage, ResendRequest);

        adminMessage.addField(BeginSeqNo).setInt(beginSeqNo);
        adminMessage.addField(EndSeqNo).setInt(0);

        connection.send(adminMessage);
    }

    private void sendSequenceReset(long msgSeqNum, long newSeqNo) throws IOException {
        connection.prepare(adminMessage, SequenceReset);

        adminMessage.valueOf(MsgSeqNum).setInt(msgSeqNum);
        adminMessage.addField(GapFillFlag).setBoolean(true);
        adminMessage.addField(NewSeqNo).setInt(newSeqNo);

        decrementOutMsgSeqNum();

        connection.send(adminMessage);
    }

    private void decrementOutMsgSeqNum() {
        connection.setOutMsgSeqNum(connection.getOutMsgSeqNum() - 1);
    }

    private void msgSeqNumNotFound() throws IOException {
        connection.sendLogout("MsgSeqNum(34) not found");
    }

    private void msgTypeNotFound() throws IOException {
        statusListener.close(connection, "MsgType(35) not found");
    }

}
