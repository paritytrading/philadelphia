package com.paritytrading.philadelphia.acceptor;

import static org.jvirtanen.util.Applications.*;

import java.io.IOException;
import java.net.InetSocketAddress;

class TestAcceptor {

    private static final String USAGE = "philadelphia-acceptor <port>";

    public static void main(String[] args) {
        if (args.length != 1)
            usage(USAGE);

        try {
            main(Integer.parseInt(args[0]));
        } catch (NumberFormatException e) {
            usage(USAGE);
        } catch (IOException e) {
            fatal(e);
        }
    }

    private static void main(int port) throws IOException {
        Acceptor acceptor = Acceptor.open(new InetSocketAddress(port));

        Session session = acceptor.accept();

        acceptor.close();

        int i = 0;

        while (true) {
            if (session.getConnection().receive() < 0)
                break;

            if (i % 1000 == 0) {
                session.getConnection().updateCurrentTimestamp();
                session.getConnection().keepAlive();
            }

            i++;
        }

        session.getConnection().close();
    }

}
