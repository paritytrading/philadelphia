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

import com.paritytrading.philadelphia.FIXConfig;
import com.paritytrading.philadelphia.FIXVersion;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigException;
import com.typesafe.config.ConfigFactory;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ClosedChannelException;
import java.nio.file.Files;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Stream;
import org.jline.reader.EndOfFileException;
import org.jline.reader.LineReaderBuilder;
import org.jline.reader.UserInterruptException;
import org.jline.reader.impl.completer.ArgumentCompleter;
import org.jline.reader.impl.completer.NullCompleter;
import org.jline.reader.impl.completer.StringsCompleter;

class TerminalClient implements Closeable {

    static final Command[] COMMANDS = {
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
        this.session = session;
    }

    static TerminalClient open(InetSocketAddress address, FIXConfig config) throws IOException {
        var messages = new Messages();
        var session = Session.open(address, config, messages, messages);

        return new TerminalClient(messages, session);
    }

    Messages getMessages() {
        return messages;
    }

    Session getSession() {
        return session;
    }

    void run(List<String> lines) throws IOException {
        var reader = LineReaderBuilder.builder()
            .completer(new ArgumentCompleter(
                        new StringsCompleter(COMMAND_NAMES),
                        new NullCompleter()))
            .build();

        if (lines.isEmpty())
            printf("Type 'help' for help.\n");

        for (var line : lines) {
            if (closed)
                break;

            printf("< %s\n", line);

            execute(line);
        }

        while (!closed) {
            var line = reader.readLine("> ");
            if (line == null)
                break;

            execute(line);
        }

        close();
    }

    private void execute(String line) throws IOException {
        if (line.trim().startsWith("#"))
            return;

        var scanner = scan(line);
        if (!scanner.hasNext())
            return;

        var command = findCommand(scanner.next());
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
        for (var command : COMMANDS) {
            if (name.equals(command.getName()))
                return command;
        }

        return null;
    }

    static void printf(String format, Object... args) {
        System.out.printf(LOCALE, format, args);
    }

    private Scanner scan(String text) {
        var scanner = new Scanner(text);
        scanner.useLocale(LOCALE);

        return scanner;
    }

    public static void main(String[] args) {
        if (args.length != 1 && args.length != 2)
            usage();

        try {
            var config = config(args[0]);

            List<String> lines = List.of();

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
        var version = config.getString("fix.version");
        var senderCompId = config.getString("fix.sender-comp-id");
        var targetCompId = config.getString("fix.target-comp-id");
        int heartBtInt = config.getInt("fix.heart-bt-int");
        var address = config.getString("fix.address");
        int port = config.getInt("fix.port");

        var builder = FIXConfig.newBuilder()
            .setVersion(FIXVersion.valueOf(version))
            .setSenderCompID(senderCompId)
            .setTargetCompID(targetCompId)
            .setHeartBtInt(heartBtInt)
            .setFieldCapacity(1024)
            .setRxBufferCapacity(1024 * 1024)
            .setTxBufferCapacity(1024 * 1024);

        TerminalClient.open(new InetSocketAddress(address, port), builder.build()).run(lines);
    }

    private static List<String> readAllLines(String filename) throws IOException {
        return Files.readAllLines(new File(filename).toPath(), UTF_8);
    }

    private static Config config(String filename) throws FileNotFoundException {
        var file = new File(filename);
        if (!file.exists() || !file.isFile())
            throw new FileNotFoundException(filename + ": No such file");

        return ConfigFactory.parseFile(file);
    }

    private static void usage() {
        System.err.println("Usage: philadelphia-client <configuration-file> [<input-file>]");
        System.exit(2);
    }

    private static void error(Throwable throwable) {
        System.err.println("error: " + throwable.getMessage());
        System.exit(1);
    }

    private static void fatal(Throwable throwable) {
        System.err.println("fatal: " + throwable.getMessage());
        System.err.println();
        throwable.printStackTrace(System.err);
        System.err.println();
        System.exit(1);
    }

}
