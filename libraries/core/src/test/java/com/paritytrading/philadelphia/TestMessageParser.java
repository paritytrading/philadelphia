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

import static com.paritytrading.philadelphia.FIXTags.*;

import java.io.IOException;
import java.nio.ByteBuffer;

class TestMessageParser {

    private TestMessageListener listener;

    private StringBuilder message;

    private FIXValue value;

    public TestMessageParser(TestMessageListener listener) {
        this.listener = listener;

        this.message = new StringBuilder();

        this.value = new FIXValue(32);
    }

    public boolean parse(ByteBuffer buffer) throws IOException {
        buffer.mark();

        message.setLength(0);

        while (true) {
            int tag = FIXTags.get(buffer);
            if (tag == 0) {
                buffer.reset();

                return false;
            }

            if (!value.get(buffer)) {
                buffer.reset();

                return false;
            }

            message.append(tag);
            message.append('=');
            value.asString(message);
            message.append('|');

            if (tag == CheckSum) {
                listener.message(message.toString());

                return true;
            }
        }
    }

}
