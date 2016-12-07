package com.paritytrading.philadelphia;

import static com.paritytrading.philadelphia.FIX.*;

import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ReadOnlyBufferException;

/**
 * Utilities for working with tags.
 */
public class FIXTags {

    static final int BeginSeqNo          =   7;
    static final int BeginString         =   8;
    static final int BodyLength          =   9;
    static final int CheckSum            =  10;
    static final int EndSeqNo            =  16;
    static final int MsgSeqNum           =  34;
    static final int MsgType             =  35;
    static final int NewSeqNo            =  36;
    static final int PossDupFlag         =  43;
    static final int RefSeqNum           =  45;
    static final int SenderCompID        =  49;
    static final int SendingTime         =  52;
    static final int TargetCompID        =  56;
    static final int Text                =  58;
    static final int TransactTime        =  60;
    static final int EncryptMethod       =  98;
    static final int HeartBtInt          = 108;
    static final int TestReqID           = 112;
    static final int GapFillFlag         = 123;
    static final int ResetSeqNumFlag     = 141;
    static final int SessionRejectReason = 373;

    private FIXTags() {
    }

    /**
     * Read a tag from a buffer.
     *
     * @param buffer a buffer
     * @return the tag if it was successfully read from the buffer, otherwise
     *     zero
     */
    public static int get(ByteBuffer buffer) {
        int tag = 0;

        while (buffer.hasRemaining()) {
            byte b = buffer.get();

            if (b == EQUALS)
                return tag;

            tag = 10 * tag + (b - '0');
        }

        return 0;
    }

    /**
     * Write a tag to a buffer.
     *
     * @param buffer a buffer
     * @param tag a tag
     * @throws IllegalArgumentException if the tag is less than 1 or greater than 99999
     * @throws BufferOverflowException if there are fewer bytes remaining in
     *   the buffer than what this tag consists of
     * @throws ReadOnlyBufferException if the buffer is read-only
     */
    public static void put(ByteBuffer buffer, int tag) {
        if (tag < 1 || tag > 99999)
            throw new IllegalArgumentException("Too large tag");

        byte b1 = (byte)('0' + tag % 10);

        tag /= 10;

        if (tag != 0) {
            byte b2 = (byte)('0' + tag % 10);

            tag /= 10;

            if (tag != 0) {
                byte b3 = (byte)('0' + tag % 10);

                tag /= 10;

                if (tag != 0) {
                    byte b4 = (byte)('0' + tag % 10);

                    tag /= 10;

                    if (tag != 0) {
                        byte b5 = (byte)('0' + tag % 10);

                        buffer.put(b5);
                    }

                    buffer.put(b4);
                }

                buffer.put(b3);
            }

            buffer.put(b2);
        }

        buffer.put(b1);
        buffer.put(EQUALS);
    }

}
