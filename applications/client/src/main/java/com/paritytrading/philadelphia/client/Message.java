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
package com.paritytrading.philadelphia.client;

import static com.paritytrading.philadelphia.client.TerminalClient.IGNORED_TAGS;

import com.paritytrading.philadelphia.FIXMessage;
import java.util.ArrayList;
import java.util.List;

class Message {

    private static final int MsgType = 35;

    private final String msgType;

    private final List<Field> fields;

    private Message(String msgType, List<Field> fields) {
        this.msgType = msgType;
        this.fields  = fields;
    }

    static Message get(String input) {
        List<Field> fields = new ArrayList<>();

        String msgType = null;

        for (String part : input.split("\\|")) {
            Field field = part.contains("=") ? Field.get(part) : new Field(Integer.parseInt(part), null);

            if (field.getTag() == MsgType)
                msgType = field.getValue();
            else
                fields.add(field);
        }

        if (msgType == null)
            throw new IllegalArgumentException("MsgType(35) missing");

        return new Message(msgType, fields);
    }

    static Message get(FIXMessage message) {
        List<Field> fields = new ArrayList<>();

        String msgType = null;

        for (int i = 0; i < message.getFieldCount(); i++) {
            int    tag   = message.tagAt(i);
            String value = message.valueAt(i).asString();

            if (tag == MsgType)
                msgType = value;
            else
                fields.add(new Field(tag, value));
        }

        if (msgType == null)
            throw new IllegalArgumentException("MsgType(35) missing");

        return new Message(msgType, fields);
    }

    String getMsgType() {
        return msgType;
    }

    List<Field> getFields() {
        return fields;
    }

    void put(FIXMessage message) {
        for (Field field : fields)
            message.addField(field.getTag()).setString(field.getValue());
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append(MsgType);
        builder.append('=');
        builder.append(msgType);

        for (Field field : fields) {
            if (IGNORED_TAGS.contains(field.getTag()))
                continue;

            builder.append('|');
            builder.append(field);
        }

        return builder.toString();
    }

}
