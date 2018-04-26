package com.paritytrading.philadelphia.client.command;

import com.paritytrading.philadelphia.client.TerminalClient;
import com.paritytrading.philadelphia.client.message.Message;
import com.paritytrading.philadelphia.client.message.Messages;

import java.util.Scanner;

import org.eclipse.collections.api.list.ImmutableList;


class WaitCommand implements Command {
    private static final long WAIT_TIME_MILLIS = 50;

    @Override
    public void execute(TerminalClient client, Scanner arguments) throws CommandException {
        if (!arguments.hasNext())
            throw new CommandException();

        String msgType = arguments.next();

        if (arguments.hasNext())
            throw new CommandException();

        while (true) {
            try {
                Thread.sleep(WAIT_TIME_MILLIS);

                if (msgType.equals(getLastMsgType(client.getMessages())))
                    break;

            } catch (InterruptedException e) {
                break;
            }
        }
    }

    @Override
    public String getName() {
        return "wait";
    }

    @Override
    public String getDescription() {
        return "Wait for a specific MsgType(35)";
    }

    @Override
    public String getUsage() {
        return "wait <MsgType(35)>";
    }

    private String getLastMsgType(Messages messages) {
        ImmutableList<Message> collect = messages.collect();

        if (collect.isEmpty())
            return null;

        return collect.getLast().getMsgType();
    }
}
