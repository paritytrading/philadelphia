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

import java.io.IOException;
import java.util.Scanner;

class SendCommand implements Command {

    @Override
    public void execute(TerminalClient client, Scanner arguments) throws IOException {
        if (!arguments.hasNext())
            throw new IllegalArgumentException();

        String message = arguments.next();

        if (arguments.hasNext())
            throw new IllegalArgumentException();

        client.getSession().send(Message.get(message));
    }

    @Override
    public String getName() {
        return "send";
    }

    @Override
    public String getDescription() {
        return "Send a message";
    }

    @Override
    public String getUsage() {
        return "send <message>";
    }

}
