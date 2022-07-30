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
package com.paritytrading.philadelphia.initiator;

import static com.paritytrading.philadelphia.fix42.FIX42Enumerations.*;
import static com.paritytrading.philadelphia.fix42.FIX42MsgTypes.*;
import static com.paritytrading.philadelphia.fix42.FIX42Tags.*;

import com.paritytrading.philadelphia.FIXMessage;
import com.paritytrading.philadelphia.FIXValue;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Locale;

class TestInitiator {

    private static final Locale LOCALE = Locale.US;

    public static void main(String[] args) {
        if (args.length != 4)
            usage();

        try {
            String host            = args[0];
            int    port            = Integer.parseInt(args[1]);
            int    orders          = Integer.parseInt(args[2]);
            int    ordersPerSecond = Integer.parseInt(args[3]);

            main(new InetSocketAddress(host, port), orders, ordersPerSecond);
        } catch (IllegalArgumentException e) {
            usage();
        } catch (IOException e) {
            fatal(e);
        }
    }

    private static void main(InetSocketAddress address, int orders, int ordersPerSecond) throws IOException {
        try (final Initiator initiator = Initiator.open(address)) {
            initiator.setIntervalNanos(1_000_000_000 / ordersPerSecond);

            FIXMessage message = initiator.getTransport().create();

            initiator.getTransport().prepare(message, OrderSingle);

            FIXValue clOrdId = message.addField(ClOrdID);

            message.addField(HandlInst).setChar(HandlInstValues.AutomatedExecutionNoIntervention);
            message.addField(Symbol).setString("FOO");
            message.addField(Side).setChar(SideValues.Buy);

            FIXValue transactTime = message.addField(TransactTime);
            transactTime.setString(initiator.getTransport().getCurrentTimestamp());

            message.addField(OrderQty).setFloat(100.00, 2);
            message.addField(OrdType).setChar(OrdTypeValues.Limit);
            message.addField(Price).setFloat(25.50, 2);

            printf("Warming up...\n");

            initiator.sendAndReceive(message, clOrdId, orders);

            initiator.reset();

            printf("Benchmarking...\n");

            initiator.sendAndReceive(message, clOrdId, orders);

            initiator.getTransport().close();

            printf("Results (n = %d)\n", orders);
            printf("\n");
            printf("   50.00%%: %10.2f µs\n", initiator.getHistogram().getValueAtPercentile( 50.00) / 1000.0);
            printf("   90.00%%: %10.2f µs\n", initiator.getHistogram().getValueAtPercentile( 90.00) / 1000.0);
            printf("   99.00%%: %10.2f µs\n", initiator.getHistogram().getValueAtPercentile( 99.00) / 1000.0);
            printf("   99.90%%: %10.2f µs\n", initiator.getHistogram().getValueAtPercentile( 99.90) / 1000.0);
            printf("   99.99%%: %10.2f µs\n", initiator.getHistogram().getValueAtPercentile( 99.99) / 1000.0);
            printf("  100.00%%: %10.2f µs\n", initiator.getHistogram().getValueAtPercentile(100.00) / 1000.0);
            printf("\n");
        }
    }

    private static void printf(String format, Object... args) {
        System.out.printf(LOCALE, format, args);
    }

    private static void usage() {
        System.err.println("Usage: philadelphia-initiator <host> <port> <orders> <orders-per-second>");
        System.exit(2);
    }

    private static void fatal(Throwable throwable) {
        System.err.println("fatal: " + throwable.getMessage());
        System.err.println();
        throwable.printStackTrace(System.err);
        System.err.println();
        System.exit(1);
    }

}
