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

import java.util.Scanner;

class SleepCommand implements Command {

    @Override
    public void execute(TerminalClient client, Scanner arguments) {
        if (!arguments.hasNext())
            throw new IllegalArgumentException();

        long millis = arguments.nextLong();

        if (arguments.hasNext())
            throw new IllegalArgumentException();

        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
        }
    }

    @Override
    public String getName() {
        return "sleep";
    }

    @Override
    public String getDescription() {
        return "Sleep for a number of milliseconds";
    }

    @Override
    public String getUsage() {
        return "sleep <milliseconds>";
    }

}
