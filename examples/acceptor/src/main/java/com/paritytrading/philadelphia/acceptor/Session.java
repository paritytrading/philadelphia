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
package com.paritytrading.philadelphia.acceptor;

import static com.paritytrading.philadelphia.fix42.FIX42Enumerations.*;
import static com.paritytrading.philadelphia.fix42.FIX42MsgTypes.*;
import static com.paritytrading.philadelphia.fix42.FIX42Tags.*;

import com.paritytrading.philadelphia.FIXConfig;
import com.paritytrading.philadelphia.FIXConnection;
import com.paritytrading.philadelphia.FIXConnectionStatusListener;
import com.paritytrading.philadelphia.FIXMessage;
import com.paritytrading.philadelphia.FIXMessageListener;
import com.paritytrading.philadelphia.FIXValue;
import java.io.IOException;
import java.nio.channels.SocketChannel;

class Session implements FIXMessageListener {

    private static final FIXConfig CONFIG = new FIXConfig.Builder().build();

    private final FIXConnection connection;

    private final FIXMessage report;

    private final FIXValue orderId;
    private final FIXValue clOrdId;
    private final FIXValue execId;
    private final FIXValue symbol;
    private final FIXValue side;
    private final FIXValue orderQty;
    private final FIXValue price;
    private final FIXValue leavesQty;

    private long nextOrderId;
    private long nextExecId;

    Session(SocketChannel channel) {
        connection = new FIXConnection(channel, CONFIG, this, new FIXConnectionStatusListener() {

            @Override
            public void close(FIXConnection connection, String message) throws IOException {
                connection.close();
            }

            @Override
            public void sequenceReset(FIXConnection connection) {
            }

            @Override
            public void tooLowMsgSeqNum(FIXConnection connection, long receivedMsgSeqNum, long expectedMsgSeqNum) {
            }

            @Override
            public void heartbeatTimeout(FIXConnection connection) throws IOException {
                connection.close();
            }

            @Override
            public void reject(FIXConnection connection, FIXMessage message) throws IOException {
            }

            @Override
            public void logon(FIXConnection connection, FIXMessage message) throws IOException {
                connection.sendLogon(true);

                connection.updateCompID(report);
            }

            @Override
            public void logout(FIXConnection connection, FIXMessage message) throws IOException {
                connection.sendLogout();
            }

        });

        report = connection.create();

        connection.prepare(report, ExecutionReport);

        orderId   = report.addField(OrderID);
        clOrdId   = report.addField(ClOrdID);
        execId    = report.addField(ExecID);
                    report.addField(ExecTransType).setChar(ExecTransTypeValues.New);
                    report.addField(ExecType).setChar(ExecTypeValues.New);
                    report.addField(OrdStatus).setChar(OrdStatusValues.New);
        symbol    = report.addField(Symbol);
        side      = report.addField(Side);
        orderQty  = report.addField(OrderQty);
        price     = report.addField(Price);
        leavesQty = report.addField(LeavesQty);
                    report.addField(CumQty).setInt(0);
                    report.addField(AvgPx).setFloat(0.00, 2);

        nextOrderId = 1;
        nextExecId  = 1;
    }

    @Override
    public void message(FIXMessage message) throws IOException {
        FIXValue msgType = message.getMsgType();

        if (msgType.length() != 1 || msgType.asChar() != OrderSingle)
            return;

        clOrdId.reset();
        symbol.reset();
        side.reset();
        orderQty.reset();
        price.reset();

        for (int i = 0; i < message.getFieldCount(); i++) {
            switch (message.tagAt(i)) {
            case ClOrdID:
                clOrdId.set(message.valueAt(i));
                break;
            case Symbol:
                symbol.set(message.valueAt(i));
                break;
            case Side:
                side.set(message.valueAt(i));
                break;
            case OrderQty:
                orderQty.set(message.valueAt(i));
                break;
            case Price:
                price.set(message.valueAt(i));
                break;
            }
        }

        if (clOrdId.length() == 0) {
            connection.sendReject(message.getMsgSeqNum(), 1, "ClOrdID(11) not found");
            return;
        }

        if (symbol.length() == 0) {
            connection.sendReject(message.getMsgSeqNum(), 1, "Symbol(55) not found");
            return;
        }

        if (orderQty.length() == 0) {
            connection.sendReject(message.getMsgSeqNum(), 1, "OrderQty(38) not found");
            return;
        }

        if (price.length() == 0) {
            connection.sendReject(message.getMsgSeqNum(), 1, "Price(44) not found");
            return;
        }

        orderId.setInt(nextOrderId++);
        execId.setInt(nextExecId++);
        leavesQty.set(orderQty);

        connection.update(report);
        connection.send(report);
    }

    FIXConnection getConnection() {
        return connection;
    }

}
