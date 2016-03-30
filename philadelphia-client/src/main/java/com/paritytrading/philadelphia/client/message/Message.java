package com.paritytrading.philadelphia.client.message;

import com.paritytrading.philadelphia.FIXField;
import com.paritytrading.philadelphia.FIXMessage;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.collections.api.set.primitive.ImmutableIntSet;
import org.eclipse.collections.impl.factory.primitive.IntSets;

public class Message {

    private static final ImmutableIntSet UNPRINTED_TAGS = IntSets.immutable.with(
        49, // SenderCompID
        56, // TargetCompID
        34, // MsgSeqNum
        52  // SendingTime
    );

    private static final int MsgType = 35;

    private String msgType;

    private List<Field> fields;

    private Message(String msgType, List<Field> fields) {
        this.msgType = msgType;
        this.fields  = fields;
    }

    public static Message get(String input) {
        List<Field> fields = new ArrayList<>();

        String msgType = null;

        for (String part : input.split("\\|")) {
            Field field = Field.get(part);

            if (field.getTag() == MsgType)
                msgType = field.getValue();
            else
                fields.add(field);
        }

        if (msgType == null)
            throw new IllegalArgumentException("MsgType(35) missing");

        return new Message(msgType, fields);
    }

    public static Message get(FIXMessage message) {
        List<Field> fields = new ArrayList<>();

        String msgType = null;

        for (int i = 0; i < message.getFieldCount(); i++) {
            FIXField field = message.getField(i);
            int      tag   = field.getTag();
            String   value = field.getValue().asString();

            if (tag == MsgType)
                msgType = value;
            else
                fields.add(new Field(tag, value));
        }

        if (msgType == null)
            throw new IllegalArgumentException("MsgType(35) missing");

        return new Message(msgType, fields);
    }

    public String getMsgType() {
        return msgType;
    }

    public void put(FIXMessage message) {
        for (Field field : fields)
            message.addField(field.getTag()).setString(field.getValue());
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append(MsgType);
        builder.append('=');
        builder.append(msgType);

        for (Field field : fields) {
            if (UNPRINTED_TAGS.contains(field.getTag()))
                continue;

            builder.append('|');
            builder.append(field);
        }

        return builder.toString();
    }

}
