package com.paritytrading.philadelphia.client;

import java.io.IOException;
import java.util.Scanner;

public interface Command {

    void execute(TerminalClient client, Scanner arguments) throws CommandException, IOException;

    String getName();

    String getDescription();

    String getUsage();

}
