package com.paritytrading.philadelphia.client;

import static org.jvirtanen.util.Applications.*;

import com.paritytrading.philadelphia.FIXConfig;
import com.paritytrading.philadelphia.FIXVersion;
import com.paritytrading.philadelphia.client.command.Command;
import com.paritytrading.philadelphia.client.command.CommandException;
import com.paritytrading.philadelphia.client.command.Commands;
import com.paritytrading.philadelphia.client.message.Messages;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigException;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.ClosedChannelException;
import java.util.Locale;
import java.util.Scanner;
import jline.console.ConsoleReader;
import jline.console.completer.StringsCompleter;
import org.jvirtanen.config.Configs;

public class TerminalClient implements Closeable {

    public static final Locale LOCALE = Locale.US;

    private Messages messages;

    private Session session;

    private boolean closed;

    private TerminalClient(Messages messages, Session session) {
        this.messages = messages;
        this.session  = session;
    }

    public static TerminalClient open(InetSocketAddress address, FIXConfig config) throws IOException {
        Messages messages = new Messages();

        Session session = Session.open(address, config, messages, messages);

        return new TerminalClient(messages, session);
    }

    public Messages getMessages() {
        return messages;
    }

    public Session getSession() {
        return session;
    }

    public void run() throws IOException {
        ConsoleReader reader = new ConsoleReader();

        reader.addCompleter(new StringsCompleter(Commands.names().castToList()));

        printf("Type 'help' for help.\n");

        while (!closed) {
            String line = reader.readLine("> ");
            if (line == null)
                break;

            Scanner scanner = scan(line);

            if (!scanner.hasNext())
                continue;

            Command command = Commands.find(scanner.next());
            if (command == null) {
                printf("error: Unknown command\n");
                continue;
            }

            try {
                command.execute(this, scanner);
            } catch (CommandException e) {
                printf("Usage: %s\n", command.getUsage());
            } catch (ClosedChannelException e) {
                printf("error: Connection closed\n");
            }
        }

        close();
    }

    @Override
    public void close() {
        session.close();

        closed = true;
    }

    public void printf(String format, Object... args) {
        System.out.printf(LOCALE, format, args);
    }

    private Scanner scan(String text) {
        Scanner scanner = new Scanner(text);
        scanner.useLocale(LOCALE);

        return scanner;
    }

    public static void main(String[] args) {
        if (args.length != 1)
            usage("philadelphia-client <configuration-file>");

        try {
            main(config(args[0]));
        } catch (ConfigException | FileNotFoundException e) {
            error(e);
        } catch (IOException e) {
            fatal(e);
        }
    }

    public static void main(Config config) throws IOException {
        String      version      = config.getString("fix.version");
        String      senderCompId = config.getString("fix.sender-comp-id");
        String      targetCompId = config.getString("fix.target-comp-id");
        int         heartBtInt   = config.getInt("fix.heart-bt-int");
        InetAddress address      = Configs.getInetAddress(config, "fix.address");
        int         port         = Configs.getPort(config, "fix.port");

        FIXConfig.Builder builder = new FIXConfig.Builder()
            .setVersion(Enum.valueOf(FIXVersion.class, version))
            .setSenderCompID(senderCompId)
            .setTargetCompID(targetCompId)
            .setHeartBtInt(heartBtInt)
            .setMaxFieldCount(1024)
            .setFieldCapacity(1024)
            .setRxBufferCapacity(1024 * 1024)
            .setTxBufferCapacity(1024 * 1024);

        TerminalClient.open(new InetSocketAddress(address, port), builder.build()).run();
    }

}
