package com.paritytrading.philadelphia;

import static com.paritytrading.philadelphia.FIX.*;
import static com.paritytrading.philadelphia.FIXTags.*;

import java.io.IOException;
import java.nio.ByteBuffer;

class FIXMessageParser {

    private FIXMessageListener listener;

    private FIXMessage message;

    private FIXField beginString;
    private FIXField bodyLength;
    private FIXField checkSum;

    public FIXMessageParser(FIXMessageListener listener, FIXMessage message) {
        this.listener = listener;

        this.message = message;

        this.beginString = new FIXField(BEGIN_STRING_FIELD_CAPACITY);
        this.bodyLength  = new FIXField(BODY_LENGTH_FIELD_CAPACITY);
        this.checkSum    = new FIXField(CHECK_SUM_FIELD_CAPACITY);
    }

    public boolean parse(ByteBuffer buffer) throws IOException {
        while (true) {
            buffer.mark();

            int beginning = buffer.position();

            // Partial message
            if (!beginString.get(buffer)) {
                buffer.reset();

                return false;
            }

            // Garbled message
            if (beginString.getTag() != BeginString)
                continue;

            int position = buffer.position();

            // Partial message
            if (!bodyLength.get(buffer)) {
                buffer.reset();

                return false;
            }

            // Garbled message
            if (bodyLength.getTag() != BodyLength) {
                buffer.position(position);

                continue;
            }

            int length = (int)bodyLength.getValue().asInt();

            // Partial message
            if (buffer.remaining() < length + 7) {
                buffer.reset();

                return false;
            }

            position = buffer.position();

            buffer.position(position + length);

            // Garbled message
            if (!checkSum.get(buffer))
                continue;

            // Garbled message
            if (checkSum.getTag() != CheckSum)
                continue;

            // Garbled message
            if (FIXCheckSums.sum(buffer, beginning, position - beginning + length) % 256
                    != checkSum.getValue().asCheckSum())
                continue;

            int limit = buffer.limit();

            buffer.position(position);
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
