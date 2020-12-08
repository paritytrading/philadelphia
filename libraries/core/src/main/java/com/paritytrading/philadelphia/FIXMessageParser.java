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

import static com.paritytrading.philadelphia.FIX.*;

import java.io.IOException;
import java.nio.ByteBuffer;

/**
 * A message parser.
 */
public class FIXMessageParser {

    private final FIXMessageListener listener;

    private final FIXMessage message;

    private final boolean checkSumEnabled;

    /**
     * Create a message parser.
     *
     * @param config the parser configuration
     * @param listener the message listener
     */
    public FIXMessageParser(FIXConfig config, FIXMessageListener listener) {
        this.message = new FIXMessage(config);

        this.checkSumEnabled = config.isCheckSumEnabled();

        this.listener = listener;
    }

    /**
     * Attempt to parse a message from a buffer. If a message is parsed
     * successfully, invoke the message listener.
     *
     * @param buffer a buffer
     * @return true if a message was parsed successfully, otherwise false
     * @throws IOException if an I/O error occurs
     */
    public boolean parse(ByteBuffer buffer) throws IOException {
        boolean garbled;

        while (true) {
            buffer.mark();

            int beginning = buffer.position();

            // Partial message
            if (buffer.remaining() < 2)
                return false;

            // Garbled message
            garbled = buffer.get() != '8' || buffer.get() != '=';

            // Partial message
            if (!skipValue(buffer)) {
                buffer.reset();

                return false;
            }

            // Garbled message
            if (garbled)
                continue;

            int position = buffer.position();

            // Partial message
            if (buffer.remaining() < 2) {
                buffer.reset();

                return false;
            }

            // Garbled message
            garbled = buffer.get() != '9' || buffer.get() != '=';

            int bodyLength = getInt(buffer);

            // Partial message
            if (bodyLength == -1) {
                buffer.reset();

                return false;
            }

            if (garbled) {
                buffer.position(position);

                continue;
            }

            // Partial message
            if (buffer.remaining() < bodyLength + 7) {
                buffer.reset();

                return false;
            }

            position = buffer.position();

            if (checkSumEnabled && !acceptCheckSum(buffer, beginning, position, bodyLength))
                continue;

            int limit = buffer.limit();

            buffer.limit(position + bodyLength);

            // Garbled message
            garbled = message.get(buffer) == false;

            buffer.limit(limit);
            buffer.position(position + bodyLength + 7);

            if (garbled)
                continue;

            listener.message(message);

            return true;
        }
    }

    private boolean acceptCheckSum(ByteBuffer buffer, int beginning, int position, int bodyLength) throws IOException {
        buffer.position(position + bodyLength);

        boolean garbled = buffer.get() != '1' || buffer.get() != '0' || buffer.get() != '=';

        int checkSum = getInt(buffer);

        // Garbled message
        if (checkSum == -1)
            return false;

        // Garbled message
        if (garbled)
            return false;

        // Garbled message
        if ((FIXCheckSums.sum(buffer, beginning, position - beginning + bodyLength) & 0xff) != checkSum)
            return false;

        buffer.position(position);

        return true;
    }

    private static int getInt(ByteBuffer buffer) {
        int value = 0;

        while (buffer.hasRemaining()) {
            byte b = buffer.get();

            if (b == SOH)
                return value;

            value = 10 * value + b - '0';
        }

        return -1;
    }

    private static boolean skipValue(ByteBuffer buffer) {
        while (buffer.hasRemaining()) {
            if (buffer.get() == SOH)
                return true;
        }

        return false;
    }

}
