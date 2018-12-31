package com.paritytrading.philadelphia.client;

import java.io.IOException;
import java.util.Scanner;

class SendCommand implements Command {

    @Override
    public void execute(TerminalClient client, Scanner arguments) throws IOException {
        if (!arguments.hasNext())
            throw new IllegalArgumentException();

        String message = arguments.next();

        if (arguments.hasNext())
            throw new IllegalArgumentException();

        client.getSession().send(Message.get(message));
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
