package org.jvirtanen.philadelphia.acceptor;

import static org.jvirtanen.philadelphia.fix42.FIX42Enumerations.*;
import static org.jvirtanen.philadelphia.fix42.FIX42MsgTypes.*;
import static org.jvirtanen.philadelphia.fix42.FIX42Tags.*;

import java.io.IOException;
import java.nio.channels.SocketChannel;
import org.jvirtanen.philadelphia.FIXConfig;
import org.jvirtanen.philadelphia.FIXField;
import org.jvirtanen.philadelphia.FIXMessage;
import org.jvirtanen.philadelphia.FIXMessageListener;
import org.jvirtanen.philadelphia.FIXSession;
import org.jvirtanen.philadelphia.FIXStatusListener;
import org.jvirtanen.philadelphia.FIXValue;

class Session implements FIXMessageListener {

    private static final FIXConfig CONFIG = new FIXConfig.Builder().build();

    private FIXSession transport;

    private FIXMessage report;

    private FIXValue orderId;
    private FIXValue clOrdId;
    private FIXValue execId;
    private FIXValue symbol;
    private FIXValue side;
    private FIXValue orderQty;
    private FIXValue price;
    private FIXValue leavesQty;

    private long nextOrderId;
    private long nextExecId;

    public Session(SocketChannel channel) {
        transport = new FIXSession(channel, CONFIG, this, new FIXStatusListener() {

            @Override
            public void close(FIXSession session, String message) throws IOException {
                session.close();
            }

            @Override
            public void sequenceReset(FIXSession session) {
            }

            @Override
            public void tooLowMsgSeqNum(FIXSession session, long receivedMsgSeqNum, long expectedMsgSeqNum) {
            }

            @Override
            public void heartbeatTimeout(FIXSession session) throws IOException {
                session.close();
            }

            @Override
            public void reject(FIXSession session, FIXMessage message) throws IOException {
            }

            @Override
            public void logon(FIXSession session, FIXMessage message) throws IOException {
                session.sendLogon(true);

                session.updateCompID(report);
            }

            @Override
            public void logout(FIXSession session, FIXMessage message) throws IOException {
                session.sendLogout();
            }

        });

        report = transport.create();

        transport.prepare(report, ExecutionReport);

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
            FIXField field = message.getField(i);

            switch (field.getTag()) {
            case ClOrdID:
                clOrdId.set(field.getValue());
                break;
            case Symbol:
                symbol.set(field.getValue());
                break;
            case Side:
                side.set(field.getValue());
                break;
            case OrderQty:
                orderQty.set(field.getValue());
                break;
            case Price:
                price.set(field.getValue());
                break;
            }
        }

        if (clOrdId.length() == 0) {
            transport.sendReject(message.getMsgSeqNum(), 1, "ClOrdID(11) not found");
            return;
        }

        if (symbol.length() == 0) {
            transport.sendReject(message.getMsgSeqNum(), 1, "Symbol(55) not found");
            return;
        }

        if (orderQty.length() == 0) {
            transport.sendReject(message.getMsgSeqNum(), 1, "OrderQty(38) not found");
            return;
        }

        if (price.length() == 0) {
            transport.sendReject(message.getMsgSeqNum(), 1, "Price(44) not found");
            return;
        }

        orderId.setInt(nextOrderId++);
        execId.setInt(nextExecId++);
        leavesQty.set(orderQty);

        transport.update(report);
        transport.send(report);
    }

    public FIXSession getTransport() {
        return transport;
    }

}
