package com.paritytrading.philadelphia.acceptor;

import java.io.Closeable;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.StandardSocketOptions;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

class Acceptor implements Closeable {

    private ServerSocketChannel serverChannel;

    private Acceptor(ServerSocketChannel serverChannel) {
        this.serverChannel = serverChannel;
    }

    public static Acceptor open(InetSocketAddress address) throws IOException {
        ServerSocketChannel serverChannel = ServerSocketChannel.open();

        serverChannel.bind(address);

        return new Acceptor(serverChannel);
    }

    public Session accept() throws IOException {
        SocketChannel channel = serverChannel.accept();

        channel.setOption(StandardSocketOptions.TCP_NODELAY, true);
        channel.configureBlocking(false);

        return new Session(channel);
    }

    @Override
    public void close() throws IOException {
        serverChannel.close();
    }

}
