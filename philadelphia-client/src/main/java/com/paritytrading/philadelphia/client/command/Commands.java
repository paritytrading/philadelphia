package com.paritytrading.philadelphia.client.command;

import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.impl.factory.Lists;

public class Commands {

    private static final ImmutableList<Command> COMMANDS = Lists.immutable.of(
            new SendCommand(),
            new MessagesCommand(),
            new HelpCommand(),
            new ExitCommand()
        );

    private Commands() {
    }

    public static ImmutableList<Command> all() {
        return COMMANDS;
    }

    public static Command find(final String name) {
        return COMMANDS.select(c -> c.getName().equals(name)).getFirst();
    }

    public static ImmutableList<String> names() {
        return COMMANDS.collect(c -> c.getName());
    }

}
