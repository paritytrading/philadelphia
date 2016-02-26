package org.jvirtanen.philadelphia.client.command;

import java.util.Scanner;
import org.jvirtanen.philadelphia.client.TerminalClient;
import org.jvirtanen.philadelphia.client.message.Message;
import org.jvirtanen.philadelphia.client.message.Messages;

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
