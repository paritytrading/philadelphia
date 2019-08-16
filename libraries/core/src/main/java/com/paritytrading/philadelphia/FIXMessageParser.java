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
import static com.paritytrading.philadelphia.FIXTags.*;

import java.io.IOException;
import java.nio.ByteBuffer;

/**
 * A message parser.
 */
public class FIXMessageParser {

    private final FIXMessageListener listener;

    private final FIXMessage message;

    private final boolean checkSumEnabled;

    private final FIXValue beginString;
    private final FIXValue bodyLength;
    private final FIXValue checkSum;

    /**
     * Create a message parser.
     *
     * @param config the parser configuration
     * @param listener the message listener
     */
    public FIXMessageParser(FIXConfig config, FIXMessageListener listener) {
        this.message = new FIXMessage(config.getMaxFieldCount(), config.getFieldCapacity());

        this.checkSumEnabled = config.isCheckSumEnabled();

        this.listener = listener;

        this.beginString = new FIXValue(BEGIN_STRING_FIELD_CAPACITY);
        this.bodyLength  = new FIXValue(BODY_LENGTH_FIELD_CAPACITY);
        this.checkSum    = new FIXValue(CHECK_SUM_FIELD_CAPACITY);
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
        int tag;

        while (true) {
            buffer.mark();

            int beginning = buffer.position();

            // Partial message
            tag = FIXTags.get(buffer);
            if (tag == 0) {
                buffer.reset();

                return false;
            }

            // Partial message
            if (!beginString.get(buffer)) {
                buffer.reset();

                return false;
            }

            // Garbled message
            if (tag != BeginString)
                continue;

            int position = buffer.position();

            // Partial message
            tag = FIXTags.get(buffer);
            if (tag == 0) {
                buffer.reset();

                return false;
            }

            // Partial message
            if (!bodyLength.get(buffer)) {
                buffer.reset();

                return false;
            }

            // Garbled message
            if (tag != BodyLength) {
                buffer.position(position);

                continue;
            }

            int length = (int)bodyLength.asInt();

            // Partial message
            if (buffer.remaining() < length + 7) {
                buffer.reset();

                return false;
            }

            position = buffer.position();

            if (checkSumEnabled) {
                buffer.position(position + length);

                // Garbled message
                tag = FIXTags.get(buffer);
                if (tag == 0)
                    continue;

                // Garbled message
                if (!checkSum.get(buffer))
                    continue;

                // Garbled message
                if (tag != CheckSum)
                    continue;

                // Garbled message
                if ((FIXCheckSums.sum(buffer, beginning, position - beginning + length) & 0xff)
                        != checkSum.asInt())
                    continue;

                buffer.position(position);
            }

            int limit = buffer.limit();

            buffer.limit(position + length);

            // Garbled message
            boolean garbled = message.get(buffer) == false;

            buffer.limit(limit);
            buffer.position(position + length + 7);

            if (garbled)
                continue;

            listener.message(message);

            return true;
        }
    }

}
