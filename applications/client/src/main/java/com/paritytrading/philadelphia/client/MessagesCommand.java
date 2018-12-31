package com.paritytrading.philadelphia.client;

import static com.paritytrading.philadelphia.client.TerminalClient.*;

import java.util.List;
import java.util.Scanner;

class MessagesCommand implements Command {

    @Override
    public void execute(TerminalClient client, Scanner arguments) {
        if (arguments.hasNext()) {
            int index = arguments.nextInt();

            List<Message> messages = client.getMessages().collect();

            if (index >= 0 && index < +messages.size())
                printf("%s\n", messages.get(index));

            if (index >= -messages.size() && index < 0)
                printf("%s\n", messages.get(index + messages.size()));

            if (arguments.hasNext())
                throw new IllegalArgumentException();
        }
        else {
            for (Message message : client.getMessages().collect())
                printf("%s\n", message);
        }
    }

    @Override
    public String getName() {
        return "messages";
    }

    @Override
    public String getDescription() {
        return "Display received messages";
    }

    @Override
    public String getUsage() {
        return "messages [<index>]";
    }

}
