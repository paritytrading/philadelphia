package com.paritytrading.philadelphia.client.command;

import java.util.stream.Stream;

public class Commands {

    private static final Command[] COMMANDS = new Command[] {
        new SendCommand(),
        new MessagesCommand(),
        new HelpCommand(),
        new ExitCommand(),
        new SleepCommand(),
        new WaitCommand(),
    };

    private Commands() {
    }

    public static Command[] all() {
        return COMMANDS;
    }

    public static Command find(final String name) {
        return Stream.of(COMMANDS)
                .filter(c -> c.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public static String[] names() {
        return Stream.of(COMMANDS).map(Command::getName).toArray(String[]::new);
    }

}
