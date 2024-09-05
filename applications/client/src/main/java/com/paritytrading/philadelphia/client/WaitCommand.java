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

import static java.util.stream.Collectors.*;

import java.util.List;
import java.util.Scanner;

class WaitCommand implements Command {

    private static final long WAIT_TIME_MILLIS = 50;

    @Override
    public void execute(TerminalClient client, Scanner arguments) {
        if (!arguments.hasNext())
            throw new IllegalArgumentException();

        var msgType = arguments.next();

        if (arguments.hasNext())
            throw new IllegalArgumentException();

        int fromIndex = client.getMessages().collect().size();

        while (true) {
            try {
                Thread.sleep(WAIT_TIME_MILLIS);

                if (getMsgTypes(client.getMessages(), fromIndex).contains(msgType))
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
        return "wait <msg-type>";
    }

    private static List<String> getMsgTypes(Messages messages, int fromIndex) {
        return messages.collect()
            .stream()
            .skip(fromIndex)
            .map(Message::getMsgType)
            .collect(toList());
    }

}
