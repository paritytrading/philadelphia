package org.jvirtanen.philadelphia.client.command;

import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.block.predicate.Predicate;
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
        return COMMANDS.select(new Predicate<Command>() {

            @Override
            public boolean accept(Command command) {
                return command.getName().equals(name);
            }

        }).getFirst();
    }

    public static ImmutableList<String> names() {
        return COMMANDS.collect(new Function<Command, String>() {

            @Override
            public String valueOf(Command command) {
                return command.getName();
            }

        });
    }

}
