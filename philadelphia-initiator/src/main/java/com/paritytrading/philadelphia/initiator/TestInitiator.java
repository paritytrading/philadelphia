package com.paritytrading.philadelphia.initiator;

import static com.paritytrading.philadelphia.fix42.FIX42Enumerations.*;
import static com.paritytrading.philadelphia.fix42.FIX42MsgTypes.*;
import static com.paritytrading.philadelphia.fix42.FIX42Tags.*;
import static org.jvirtanen.util.Applications.*;

import com.paritytrading.philadelphia.FIXMessage;
import com.paritytrading.philadelphia.FIXValue;
import java.io.IOException;
import java.net.InetSocketAddress;

class TestInitiator {

    private static final String USAGE = "philadelphia-initiator <host> <port> <orders>";

    public static void main(String[] args) {
        if (args.length != 3)
            usage(USAGE);

        try {
            String host   = args[0];
            int    port   = Integer.parseInt(args[1]);
            int    orders = Integer.parseInt(args[2]);

            main(new InetSocketAddress(host, port), orders);
        } catch (IllegalArgumentException e) {
            usage(USAGE);
        } catch (IOException e) {
            fatal(e);
        }
    }

    private static void main(InetSocketAddress address, int orders) throws IOException {
        Initiator initiator = Initiator.open(address);

        long nextClOrdId = 1;

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

        System.out.println("Warming up...");

        for (int i = 0; i < orders; i++) {
            clOrdId.setInt(nextClOrdId++);

            initiator.send(message);

            initiator.receive();
        }

        initiator.getHistogram().reset();

        System.out.println("Benchmarking...");

        for (int i = 0; i < orders; i++) {
            clOrdId.setInt(nextClOrdId++);

            initiator.send(message);

            initiator.receive();
        }

        initiator.getTransport().close();

        System.out.printf("Results (n = %d)\n", orders);
        System.out.printf("\n");
        System.out.printf("   50.00%%: %10.2f µs\n", initiator.getHistogram().getValueAtPercentile( 50.00) / 1000.0);
        System.out.printf("   90.00%%: %10.2f µs\n", initiator.getHistogram().getValueAtPercentile( 90.00) / 1000.0);
        System.out.printf("   99.00%%: %10.2f µs\n", initiator.getHistogram().getValueAtPercentile( 99.00) / 1000.0);
        System.out.printf("   99.90%%: %10.2f µs\n", initiator.getHistogram().getValueAtPercentile( 99.90) / 1000.0);
        System.out.printf("   99.99%%: %10.2f µs\n", initiator.getHistogram().getValueAtPercentile( 99.99) / 1000.0);
        System.out.printf("  100.00%%: %10.2f µs\n", initiator.getHistogram().getValueAtPercentile(100.00) / 1000.0);
        System.out.printf("\n");
    }

}
