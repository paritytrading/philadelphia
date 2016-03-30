package com.paritytrading.philadelphia.client.command;

import com.paritytrading.philadelphia.client.TerminalClient;
import com.paritytrading.philadelphia.client.message.Message;
import java.io.IOException;
import java.util.Scanner;

class SendCommand implements Command {

    @Override
    public void execute(TerminalClient client, Scanner arguments) throws CommandException, IOException {
        if (!arguments.hasNext())
            throw new CommandException();

        String message = arguments.next();

        if (arguments.hasNext())
            throw new CommandException();

        try {
            client.getSession().send(Message.get(message));
        } catch (IllegalArgumentException e) {
            throw new CommandException();
        }
    }

    @Override
    public String getName() {
        return "send";
    }

    @Override
    public String getDescription() {
        return "Send a message";
    }

    @Override
    public String getUsage() {
        return "send <message>";
    }

}
