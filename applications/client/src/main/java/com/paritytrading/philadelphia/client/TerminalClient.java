/*
 * Copyright 2015 Philadelphia authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.paritytrading.philadelphia.client;

import static java.nio.charset.StandardCharsets.*;
import static java.util.Collections.*;
import static org.jvirtanen.util.Applications.*;

import com.paritytrading.philadelphia.FIXConfig;
import com.paritytrading.philadelphia.FIXVersion;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigException;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.ClosedChannelException;
import java.nio.file.Files;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Stream;
import org.jline.reader.EndOfFileException;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.reader.UserInterruptException;
import org.jline.reader.impl.completer.ArgumentCompleter;
import org.jline.reader.impl.completer.NullCompleter;
import org.jline.reader.impl.completer.StringsCompleter;
import org.jvirtanen.config.Configs;

class TerminalClient implements Closeable {

    static final Command[] COMMANDS = new Command[] {
        new SendCommand(),
        new MessagesCommand(),
        new HelpCommand(),
        new ExitCommand(),
        new SleepCommand(),
        new WaitCommand(),
    };

    static final String[] COMMAND_NAMES = Stream.of(COMMANDS)
            .map(Command::getName)
            .toArray(String[]::new);

    private static final Locale LOCALE = Locale.US;

    private final Messages messages;

    private final Session session;

    private boolean closed;

    private TerminalClient(Messages messages, Session session) {
        this.messages = messages;
        this.session  = session;
    }

    static TerminalClient open(InetSocketAddress address, FIXConfig config) throws IOException {
        Messages messages = new Messages();

        Session session = Session.open(address, config, messages, messages);

        return new TerminalClient(messages, session);
    }

    Messages getMessages() {
        return messages;
    }

    Session getSession() {
        return session;
    }

    void run(List<String> lines) throws IOException {
        LineReader reader = LineReaderBuilder.builder()
            .completer(new ArgumentCompleter(
                        new StringsCompleter(COMMAND_NAMES),
                        new NullCompleter()))
            .build();

        if (lines.isEmpty())
            printf("Type 'help' for help.\n");

        for (String line : lines) {
            if (closed)
                break;

            printf("< %s\n", line);

            execute(line);
        }

        while (!closed) {
            String line = reader.readLine("> ");
            if (line == null)
                break;

            execute(line);
        }

        close();
    }

    private void execute(String line) throws IOException {
        if (line.trim().startsWith("#"))
            return;

        Scanner scanner = scan(line);

        if (!scanner.hasNext())
            return;

        Command command = findCommand(scanner.next());
        if (command == null) {
            printf("error: Unknown command\n");
            return;
        }

        try {
            command.execute(this, scanner);
        } catch (IllegalArgumentException e) {
            printf("Usage: %s\n", command.getUsage());
        } catch (ClosedChannelException e) {
            printf("error: Connection closed\n");
        }
    }

    @Override
    public void close() {
        session.close();

        closed = true;
    }

    static Command findCommand(String name) {
        for (Command command : COMMANDS) {
            if (name.equals(command.getName()))
                return command;
        }

        return null;
    }

    static void printf(String format, Object... args) {
        System.out.printf(LOCALE, format, args);
    }

    private Scanner scan(String text) {
        Scanner scanner = new Scanner(text);
        scanner.useLocale(LOCALE);

        return scanner;
    }

    public static void main(String[] args) {
        if (args.length != 1 && args.length != 2)
            usage("philadelphia-client <configuration-file> [<input-file>]");

        try {
            Config config = config(args[0]);

            List<String> lines = emptyList();

            if (args.length == 2)
                lines = readAllLines(args[1]);

            main(config, lines);
        } catch (EndOfFileException | UserInterruptException e) {
            // Ignore.
        } catch (ConfigException | FileNotFoundException e) {
            error(e);
        } catch (IOException e) {
            fatal(e);
        }
    }

    private static void main(Config config, List<String> lines) throws IOException {
        String      version      = config.getString("fix.version");
        String      senderCompId = config.getString("fix.sender-comp-id");
        String      targetCompId = config.getString("fix.target-comp-id");
        int         heartBtInt   = config.getInt("fix.heart-bt-int");
        InetAddress address      = Configs.getInetAddress(config, "fix.address");
        int         port         = Configs.getPort(config, "fix.port");

        FIXConfig.Builder builder = new FIXConfig.Builder()
            .setVersion(FIXVersion.valueOf(version))
            .setSenderCompID(senderCompId)
            .setTargetCompID(targetCompId)
            .setHeartBtInt(heartBtInt)
            .setMaxFieldCount(1024)
            .setFieldCapacity(1024)
            .setRxBufferCapacity(1024 * 1024)
            .setTxBufferCapacity(1024 * 1024);

        TerminalClient.open(new InetSocketAddress(address, port), builder.build()).run(lines);
    }

    private static List<String> readAllLines(String filename) throws IOException {
        return Files.readAllLines(new File(filename).toPath(), UTF_8);
    }

}
