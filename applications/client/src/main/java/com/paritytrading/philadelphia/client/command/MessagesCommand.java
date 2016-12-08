package com.paritytrading.philadelphia.client.command;

import com.paritytrading.philadelphia.client.TerminalClient;
import com.paritytrading.philadelphia.client.message.Message;
import com.paritytrading.philadelphia.client.message.Messages;
import java.util.Scanner;

class MessagesCommand implements Command {

    @Override
    public void execute(TerminalClient client, Scanner arguments) throws CommandException {
        if (arguments.hasNext())
            throw new CommandException();

        for (Message message : client.getMessages().collect())
            client.printf("%s\n", message);
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
        return "messages";
    }

}
