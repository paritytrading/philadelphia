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

import static com.paritytrading.philadelphia.client.TerminalClient.*;

import java.util.List;
import java.util.Scanner;

class MessagesCommand implements Command {

    @Override
    public void execute(TerminalClient client, Scanner arguments) {
        if (arguments.hasNext()) {
            int index = arguments.nextInt();

            List<Message> messages = client.getMessages().collect();

            if (index >= 0 && index < +messages.size())
                printf("%s\n", messages.get(index));

            if (index >= -messages.size() && index < 0)
                printf("%s\n", messages.get(index + messages.size()));

            if (arguments.hasNext())
                throw new IllegalArgumentException();
        }
        else {
            for (Message message : client.getMessages().collect())
                printf("%s\n", message);
        }
    }

    @Override
    public String getName() {
        return "messages";
    }

    @Override
    public String getDescription() {
        return "Display received messages";
    }

    @Override
    public String getUsage() {
        return "messages [<index>]";
    }

}
