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
import java.nio.channels.ByteChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.Pipe;
import java.nio.channels.ScatteringByteChannel;

class PipeChannel implements ByteChannel, ScatteringByteChannel, GatheringByteChannel {
    private final Pipe.SinkChannel sink;
    private final Pipe.SourceChannel source;

    public PipeChannel(Pipe.SinkChannel sink, Pipe.SourceChannel source)  throws IOException {
        this.sink = sink;
        this.source = source;
        sink.configureBlocking(false);
        source.configureBlocking(false);
    }

    @Override
    public long write(ByteBuffer[] srcs, int offset, int length) throws IOException {
        return sink.write(srcs, offset, length);
    }

    @Override
    public long write(ByteBuffer[] srcs) throws IOException {
        return sink.write(srcs);
    }

    @Override
    public int write(ByteBuffer src) throws IOException {
        return sink.write(src);
    }

    @Override
    public long read(ByteBuffer[] dsts, int offset, int length) throws IOException {
        return source.read(dsts, offset, length);
    }

    @Override
    public long read(ByteBuffer[] dsts) throws IOException {
        return source.read(dsts);
    }

    @Override
    public int read(ByteBuffer dst) throws IOException {
        return source.read(dst);
    }

    @Override
    public boolean isOpen() {
        return sink.isOpen() && source.isOpen();
    }

    @Override
    public void close() throws IOException {
        sink.close();
        source.close();
    }
}
