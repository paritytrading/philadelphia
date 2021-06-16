package com.paritytrading.philadelphia.client;

import static com.paritytrading.philadelphia.client.TerminalClient.IGNORED_TAGS;
import static com.paritytrading.philadelphia.client.TerminalClient.printf;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

class ExpectCommand implements Command {

    private static final Set<String> IGNORED_MESSAGES = new HashSet<>();

    private static final long WAIT_TIME_MILLIS = 50;

    static {
        IGNORED_MESSAGES.add("0"); // Heartbeat (0)
        IGNORED_MESSAGES.add("1"); // Test Request (1)
    }

    @Override
    public void execute(TerminalClient client, Scanner arguments) {
        if (!arguments.hasNext())
            throw new IllegalArgumentException();

        String message = arguments.next();

        if (arguments.hasNext())
            throw new IllegalArgumentException();

        Message expectedMessage = Message.get(message);
        List<Field> expectedFields = expectedMessage.getFields();

        int offset = 0;
        while (true) {
            try {
                Thread.sleep(WAIT_TIME_MILLIS);

                List<Message> collection = client.getMessages().collect();
                if (collection.isEmpty() || offset == collection.size() - 1) continue;

                while (offset < collection.size() - 1) {
                    Message receivedMessage = collection.get(offset);
                    offset++;

                    if (IGNORED_MESSAGES.contains(receivedMessage.getMsgType()))
                        continue;

                    List<Field> actualFields = receivedMessage.getFields();

                    if (compareMsgsFields(expectedFields, actualFields)) {
                        printf("%s\n", receivedMessage);
                        return;
                    }
                }
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    @Override
    public String getName() {
        return "expect";
    }

    @Override
    public String getDescription() {
        return "Expect for a specific message";
    }

    @Override
    public String getUsage() {
        return "expect <message>";
    }

    private static boolean compareMsgsFields(List<Field> expectedFields, List<Field> actualFields) {
        if (expectedFields.size() > actualFields.size())
            return false;

        Iterator<Field> expectedFieldIterator = expectedFields.iterator();

        Iterator<Field> actualFieldIterator = actualFields.iterator();

        while (actualFieldIterator.hasNext() & expectedFieldIterator.hasNext()) {
            Field actual = actualFieldIterator.next();

            if (IGNORED_TAGS.contains(actual.getTag()))
                continue;

            Field expected = expectedFieldIterator.next();

            if (!compareField(expected, actual))
                return false;
        }

        return !actualFieldIterator.hasNext() & !expectedFieldIterator.hasNext();
    }

    private static boolean compareField(Field expected, Field actual) {
        return expected.getTag() == actual.getTag() & (expected.getValue() == null || expected.getValue().equals(actual.getValue()));
    }
}
