package org.jvirtanen.philadelphia;

import static org.junit.Assert.*;
import static org.jvirtanen.philadelphia.fix42.FIX42Tags.*;

import java.nio.ByteBuffer;
import org.joda.time.MutableDateTime;
import org.junit.Before;
import org.junit.Test;

public class FIXMessageTest {

    private FIXMessage message;

    @Before
    public void setUp() {
        message = new FIXMessage(32, 32);
    }

    @Test
    public void format() {
        MutableDateTime timestamp = new MutableDateTime(2015, 9, 24, 9, 30, 5, 250);

        message.addField(ClOrdID).setString("123");
        message.addField(HandlInst).setChar('1');
        message.addField(Symbol).setString("FOO");
        message.addField(Side).setChar('1');
        message.addField(TransactTime).setTimestamp(timestamp, true);
        message.addField(OrderQty).setInt(100);
        message.addField(OrdType).setChar('2');
        message.addField(Price).setFloat(150.25, 2);

        ByteBuffer buffer = ByteBuffer.allocate(256);

        message.put(buffer);
        buffer.flip();

        assertEquals("11=123\u000121=1\u000155=FOO\u000154=1\u0001" +
                "60=20150924-09:30:05.250\u000138=100\u000140=2\u0001" +
                "44=150.25\u0001", ByteBuffers.getString(buffer));
    }

}
