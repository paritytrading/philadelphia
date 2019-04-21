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

import java.io.Closeable;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.StandardSocketOptions;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

class Acceptor implements Closeable {

    private final ServerSocketChannel serverChannel;

    private Acceptor(ServerSocketChannel serverChannel) {
        this.serverChannel = serverChannel;
    }

    static Acceptor open(InetSocketAddress address) throws IOException {
        ServerSocketChannel serverChannel = ServerSocketChannel.open();

        serverChannel.bind(address);

        return new Acceptor(serverChannel);
    }

    Session accept() throws IOException {
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
