package org.jvirtanen.philadelphia.client.command;

import java.io.IOException;
import java.util.Scanner;
import org.jvirtanen.philadelphia.client.TerminalClient;

public interface Command {

    void execute(TerminalClient client, Scanner arguments) throws CommandException, IOException;

    String getName();

    String getDescription();

    String getUsage();

}
