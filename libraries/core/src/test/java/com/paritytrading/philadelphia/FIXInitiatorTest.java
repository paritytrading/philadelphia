package com.paritytrading.philadelphia;

import static com.paritytrading.philadelphia.FIXConnectionStatus.*;
import static com.paritytrading.philadelphia.Strings.*;
import static java.util.Arrays.*;
import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class FIXInitiatorTest {

    @Rule
    public Timeout timeout = new Timeout(1000, TimeUnit.MILLISECONDS);

    private static final FIXConfig initiatorConfig = new FIXConfig.Builder()
        .setSenderCompID("initiator")
        .setTargetCompID("acceptor")
        .setFieldCapacity(1024)
        .build();

    private FIXMessage message;

    private FixedClock clock;

    private FIXMessages  initiatorMessages;
    private TestMessages acceptorMessages;

    private FIXConnectionStatus initiatorStatus;

    private FIXConnection  initiator;
    private TestConnection acceptor;

    @Before
    public void setUp() throws IOException {
        message = new FIXMessage(32, 32);

        clock = new FixedClock();

        ServerSocketChannel acceptorServerChannel = ServerSocketChannel.open();
        acceptorServerChannel.bind(null);

        SocketChannel initiatorChannel = SocketChannel.open(acceptorServerChannel.getLocalAddress());
        initiatorChannel.configureBlocking(false);

        SocketChannel acceptorChannel = acceptorServerChannel.accept();
        acceptorChannel.configureBlocking(false);

        acceptorServerChannel.close();

        initiatorMessages = new FIXMessages();
        acceptorMessages  = new TestMessages();

        initiatorStatus = new FIXConnectionStatus();

        initiator = new FIXConnection(clock, initiatorChannel, initiatorConfig, initiatorMessages, initiatorStatus);
        acceptor  = new TestConnection(acceptorChannel, acceptorMessages);
    }

    @Test
    public void heartbeat() throws IOException {
        clock.setCurrentTimeMillis(10_000);

        initiator.updateCurrentTimestamp();
        initiator.keepAlive();

        acceptor.send("35=0|34=1|");
        receiveBlocking(initiator);

        clock.setCurrentTimeMillis(35_000);

        initiator.updateCurrentTimestamp();
        initiator.keepAlive();

        String message = "8=FIX.4.2|9=60|35=0|49=initiator|56=acceptor|34=1|" +
            "52=19700101-00:00:35.000|10=223|";

        initiatorMessage(message);
    }

    @Test
    public void testRequest() throws IOException {
        clock.setCurrentTimeMillis(32_500);

        initiator.updateCurrentTimestamp();
        initiator.keepAlive();

        String heartbeat = "8=FIX.4.2|9=60|35=0|49=initiator|56=acceptor|34=1|" +
            "52=19700101-00:00:32.500|10=225|";

        clock.setCurrentTimeMillis(35_000);

        initiator.updateCurrentTimestamp();
        initiator.keepAlive();

        String testRequest = "8=FIX.4.2|9=86|35=1|49=initiator|56=acceptor|34=2|" +
            "52=19700101-00:00:35.000|112=19700101-00:00:35.000|10=213|";

        initiatorMessages(asList(heartbeat, testRequest));
    }

    @Test
    public void testResponse() throws IOException {
        clock.setCurrentTimeMillis(35_000);

        initiator.updateCurrentTimestamp();
        initiator.keepAlive();

        assertEquals(asList(), initiatorStatus.collect());

        clock.setCurrentTimeMillis(60_000);

        acceptor.send("35=0|34=1|");

        receiveBlocking(initiator);

        initiator.updateCurrentTimestamp();
        initiator.keepAlive();

        assertEquals(asList(), initiatorStatus.collect());

        clock.setCurrentTimeMillis(70_000);

        initiator.updateCurrentTimestamp();
        initiator.keepAlive();

        assertEquals(asList(), initiatorStatus.collect());

        clock.setCurrentTimeMillis(75_000);

        initiator.updateCurrentTimestamp();
        initiator.keepAlive();

        assertEquals(asList(), initiatorStatus.collect());
    }

    @Test
    public void heartbeatTimeout() throws IOException {
        clock.setCurrentTimeMillis(35_000);

        initiator.updateCurrentTimestamp();
        initiator.keepAlive();

        assertEquals(asList(), initiatorStatus.collect());

        clock.setCurrentTimeMillis(40_000);

        initiator.updateCurrentTimestamp();
        initiator.keepAlive();

        assertEquals(asList(), initiatorStatus.collect());

        clock.setCurrentTimeMillis(70_000);

        initiator.updateCurrentTimestamp();
        initiator.keepAlive();

        assertEquals(asList(new HeartbeatTimeout()), initiatorStatus.collect());

        clock.setCurrentTimeMillis(75_000);

        initiator.updateCurrentTimestamp();
        initiator.keepAlive();

        assertEquals(asList(new HeartbeatTimeout()), initiatorStatus.collect());
    }

    @Test
    public void receiveMessageWithoutMsgType() throws IOException {
        String message = "34=1|";
        Event  status  = new Close("MsgType(35) not found");

        acceptorMessageInitiatorStatus(message, status);
    }

    @Test
    public void receiveMessageWithoutMsgSeqNum() throws IOException {
        String request  = "35=0|";
        String response = "8=FIX.4.2|9=87|35=5|49=initiator|56=acceptor|34=1|" +
            "52=19700101-00:00:00.000|58=MsgSeqNum(34) not found|10=117|";

        acceptorRequestInitiatorResponse(request, response);
    }

    @Test
    public void receiveMessageWithTooLowMsgSeqNum() throws IOException {
        initiator.setIncomingMsgSeqNum(2);

        String message = "35=0|34=1|";
        Event status   = new TooLowMsgSeqNum(1, 2);

        acceptorMessageInitiatorStatus(message, status);
    }

    @Test
    public void receiveMessageWithTooHighMsgSeqNum() throws IOException {
        String request  = "35=0|34=2|";
        String response = "8=FIX.4.2|9=69|35=2|49=initiator|56=acceptor|34=1|" +
            "52=19700101-00:00:00.000|7=1|16=0|10=093|";

        acceptorRequestInitiatorResponse(request, response);
    }

    @Test
    public void receiveTestRequest() throws IOException {
        String request  = "35=1|34=1|112=foo|";
        String response = "8=FIX.4.2|9=68|35=0|49=initiator|56=acceptor|34=1|" +
            "52=19700101-00:00:00.000|112=foo|10=245|";

        acceptorRequestInitiatorResponse(request, response);
    }

    @Test
    public void receiveTestRequestWithoutTestReqID() throws IOException {
        String request  = "35=1|34=1|";
        String response = "8=FIX.4.2|9=99|35=3|49=initiator|56=acceptor|34=1|" +
            "52=19700101-00:00:00.000|45=1|373=1|58=TestReqID(112) not found|10=092|";

        acceptorRequestInitiatorResponse(request, response);
    }

    @Test
    public void receiveResendRequest() throws IOException {
        String request  = "35=2|34=1|7=2|16=4|";
        String response = "8=FIX.4.2|9=71|35=4|49=initiator|56=acceptor|34=2|" +
            "52=19700101-00:00:00.000|123=Y|36=5|10=231|";

        acceptorRequestInitiatorResponse(request, response);
    }

    @Test
    public void receiveResendRequestWithoutBeginSeqNo() throws IOException {
        String request  = "35=2|34=1|";
        String response = "8=FIX.4.2|9=98|35=3|49=initiator|56=acceptor|34=1|" +
            "52=19700101-00:00:00.000|45=1|373=1|58=BeginSeqNo(7) not found|10=116|";

        acceptorRequestInitiatorResponse(request, response);
    }

    @Test
    public void receiveResendRequestWithoutEndSeqNo() throws IOException {
        String request  = "35=2|34=1|7=1|";
        String response = "8=FIX.4.2|9=97|35=3|49=initiator|56=acceptor|34=1|" +
            "52=19700101-00:00:00.000|45=1|373=1|58=EndSeqNo(16) not found|10=213|";

        acceptorRequestInitiatorResponse(request, response);
    }

    @Test
    public void receiveSequenceResetReset() throws IOException {
        String message = "35=4|34=1|36=5|";
        Event  status  = new SequenceReset();

        acceptorMessageInitiatorStatus(message, status);
    }

    @Test
    public void receiveSequenceResetResetWithTooLowMsgSeqNum() throws IOException {
        initiator.setIncomingMsgSeqNum(2);

        String message = "35=4|34=1|36=5|";
        Event  status  = new SequenceReset();

        acceptorMessageInitiatorStatus(message, status);
    }

    @Test
    public void receiveSequenceResetResetWithTooHighMsgSeqNum() throws IOException {
        String message = "35=4|34=2|36=5|";
        Event  status  = new SequenceReset();

        acceptorMessageInitiatorStatus(message, status);
    }

    @Test
    public void receiveSequenceResetResetWithoutNewSeqNo() throws IOException {
        String request  = "35=4|34=1|";
        String response = "8=FIX.4.2|9=97|35=3|49=initiator|56=acceptor|34=1|" +
            "52=19700101-00:00:00.000|45=1|373=1|58=NewSeqNo(36) not found|10=234|";

        acceptorRequestInitiatorResponse(request, response);
    }

    @Test
    public void receiveSequenceResetGapFill() throws IOException {
        acceptor.send("35=4|34=1|123=Y|36=5|");

        while (initiator.getIncomingMsgSeqNum() != 5)
            initiator.receive();
    }

    @Test
    public void receiveLogon() throws IOException {
        String message = "35=A|49=acceptor|56=initiator|34=1|";
        Event  status  = new Logon();

        acceptorMessageInitiatorStatus(message, status);
    }

    @Test
    public void receiveLogout() throws IOException {
        String message = "35=5|34=1|";
        Event  status  = new Logout();

        acceptorMessageInitiatorStatus(message, status);
    }

    @Test
    public void receiveFullBuffer() throws IOException {
        acceptor.send(asList("35=5|34=1|58=" + repeat('A', 512) + "|",
                "35=5|34=2|58=" + repeat('A', 512) + "|"));

        while (initiator.getIncomingMsgSeqNum() != 3)
            initiator.receive();

        assertEquals(asList(), acceptorMessages.collect());
        assertEquals(asList(), initiatorMessages.collect());
        assertEquals(asList(new Logout(), new Logout()), initiatorStatus.collect());
    }

    @Test(expected=FIXMessageOverflowException.class)
    public void receiveTooLongMessage() throws IOException {
        acceptor.send("35=5|34=1|58=" + repeat('A', 1024));

        while (true)
            initiator.receive();
    }

    @Test
    public void sendLogon() throws IOException {
        initiator.sendLogon(false);

        String logon = "8=FIX.4.2|9=72|35=A|49=initiator|56=acceptor|34=1|" +
            "52=19700101-00:00:00.000|98=0|108=30|10=004|";

        initiatorMessage(logon);
    }

    @Test
    public void sendLogonWithResetSeqNumFlag() throws IOException {
        initiator.sendLogon(true);

        String logon = "8=FIX.4.2|9=78|35=A|49=initiator|56=acceptor|34=1|" +
            "52=19700101-00:00:00.000|98=0|108=30|141=Y|10=055|";

        initiatorMessage(logon);
    }

    @Test
    public void sendLogout() throws IOException {
        initiator.sendLogout();

        String logout = "8=FIX.4.2|9=60|35=5|49=initiator|56=acceptor|34=1|" +
            "52=19700101-00:00:00.000|10=220|";

        initiatorMessage(logout);
    }

    private void receiveBlocking(FIXConnection connection) throws IOException {
        SocketChannel channel = connection.getChannel();

        if (channel.isBlocking()) {
            connection.receive();
        } else {
            channel.configureBlocking(true);

            try {
                connection.receive();
            } finally {
                channel.configureBlocking(false);
            }
        }
    }

    private void initiatorMessage(String message) throws IOException {
        initiatorMessages(asList(message));
    }

    private void initiatorMessages(List<String> messages) throws IOException {
        while (acceptorMessages.collect().size() < messages.size())
            acceptor.receive();

        assertEquals(messages, acceptorMessages.collect());
        assertEquals(asList(), initiatorMessages.collect());
        assertEquals(asList(), initiatorStatus.collect());
    }

    private void acceptorRequestInitiatorResponse(String request, String response) throws IOException {
        acceptor.send(request);

        while (acceptorMessages.collect().size() < 1) {
            initiator.receive();
            acceptor.receive();
        }

        assertEquals(asList(response), acceptorMessages.collect());
        assertEquals(asList(), initiatorMessages.collect());
        assertEquals(asList(), initiatorStatus.collect());
    }

    private void acceptorMessageInitiatorStatus(String request, Event status) throws IOException {
        acceptor.send(request);

        while (initiatorStatus.collect().size() < 1)
            initiator.receive();

        assertEquals(asList(), acceptorMessages.collect());
        assertEquals(asList(), initiatorMessages.collect());
        assertEquals(asList(status), initiatorStatus.collect());
    }

}
