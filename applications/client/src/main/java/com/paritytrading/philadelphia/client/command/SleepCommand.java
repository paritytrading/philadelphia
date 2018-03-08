package com.paritytrading.philadelphia.client.command;

import com.paritytrading.philadelphia.client.TerminalClient;
import java.util.Scanner;

class SleepCommand implements Command {

    @Override
    public void execute(TerminalClient client, Scanner arguments) throws CommandException {
        if (!arguments.hasNext())
            throw new CommandException();

        long millis = arguments.nextLong();

        if (arguments.hasNext())
            throw new CommandException();

        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
        }
    }

    @Override
    public String getName() {
        return "sleep";
    }

    @Override
    public String getDescription() {
        return "Sleep for a number of milliseconds";
    }

    @Override
    public String getUsage() {
        return "sleep <milliseconds>";
    }

}
