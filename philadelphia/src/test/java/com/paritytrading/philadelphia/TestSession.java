package com.paritytrading.philadelphia;

import static java.nio.charset.StandardCharsets.*;
import static java.util.Arrays.*;

import java.io.Closeable;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.List;

class TestSession implements Closeable {

    private SocketChannel channel;

    private ByteBuffer rxBuffer;
    private ByteBuffer txBuffer;

    private TestMessageParser parser;

    public TestSession(SocketChannel channel, TestMessageListener listener) {
        this.channel = channel;

        this.parser = new TestMessageParser(listener);

        this.rxBuffer = ByteBuffer.allocate(2048);
        this.txBuffer = ByteBuffer.allocate(2048);
    }

    public int receive() throws IOException {
        int bytes = channel.read(rxBuffer);

        if (bytes <= 0)
            return bytes;

        rxBuffer.flip();

        while (parser.parse(rxBuffer));

        rxBuffer.compact();

        return bytes;
    }

    public void send(String message) throws IOException {
        send(asList(message));
    }

    public void send(List<String> messages) throws IOException {
        txBuffer.clear();

        for (String message : messages)
            txBuffer.put(format(message).getBytes(US_ASCII));

        txBuffer.flip();

        while (txBuffer.hasRemaining())
            channel.write(txBuffer);
    }

    @Override
    public void close() throws IOException {
        channel.close();
    }

    private String format(String message) {
        StringBuilder builder = new StringBuilder();

        builder.append("8=FIX.4.2\u0001");
        builder.append("9=");
        builder.append(message.length());
        builder.append('\u0001');
        builder.append(message.replace('|', '\u0001'));

        String checkSum = checkSum(builder);

        builder.append("10=");
        builder.append(checkSum);
        builder.append('\u0001');

        return builder.toString();
    }

    private String checkSum(CharSequence buffer) {
        int checkSum = 0;

        for (int i = 0; i < buffer.length(); i++)
            checkSum += buffer.charAt(i);

        return String.format("%03d", checkSum % 256);
    }

}
