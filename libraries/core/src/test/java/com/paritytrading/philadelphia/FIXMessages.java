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
package com.paritytrading.philadelphia;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

class FIXMessages implements FIXMessageListener {

    private List<String> messages;

    private ByteBuffer buffer;

    public FIXMessages() {
        this.messages = new ArrayList<>();

        this.buffer = ByteBuffer.allocateDirect(1024);
    }

    public List<String> collect() {
        return messages;
    }

    @Override
    public void message(FIXMessage message) {
        buffer.clear();
        message.put(buffer);
        buffer.flip();

        messages.add(ByteBuffers.getString(buffer));
    }

}
