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

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.SocketChannel;

/**
 * Philadelphia only relies on methods {@link java.nio.channels.Channel#close}, {@link java.nio.channels.ReadableByteChannel#read}, {@link java.nio.channels.GatheringByteChannel#write(java.nio.ByteBuffer[], int, int)}
 * and hence this interface is introduced to allow third parties to easily implement adapters to other types of Channels.
 */
public interface FIXChannel extends ReadableByteChannel, GatheringByteChannel {

    /**
     * Third parties are free to implement their own adapters to implement this interface
     */
    static FIXChannel ofSocketChannel(SocketChannel channel) {
        return new FIXChannel() {
            @Override
            public long write(ByteBuffer[] srcs, int offset, int length) throws IOException {
                return channel.write(srcs, offset, length);
            }

            @Override
            public long write(ByteBuffer[] srcs) throws IOException {
                return channel.write(srcs);
            }

            @Override
            public int read(ByteBuffer dst) throws IOException {
                return channel.read(dst);
            }

            @Override
            public int write(ByteBuffer src) throws IOException {
                return channel.write(src);
            }

            @Override
            public boolean isOpen() {
                return channel.isOpen();
            }

            @Override
            public void close() throws IOException {
                channel.close();
            }
        };
    }

}
