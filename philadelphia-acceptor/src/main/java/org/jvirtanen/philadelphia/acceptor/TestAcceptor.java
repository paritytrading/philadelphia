package org.jvirtanen.philadelphia.acceptor;

import java.io.IOException;
import java.net.InetSocketAddress;

class TestAcceptor {

    public static void main(String[] args) {
        if (args.length != 1)
            usage();

        try {
            main(Integer.parseInt(args[0]));
        } catch (NumberFormatException e) {
            usage();
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
            if (session.getTransport().receive() < 0)
                break;

            if (i % 1000 == 0) {
                session.getTransport().updateCurrentTimestamp();
                session.getTransport().keepAlive();
            }

            i++;
        }

        session.getTransport().close();
    }

    private static void fatal(Throwable throwable) {
        System.err.println("fatal: " + throwable.getMessage());
        System.err.println();
        throwable.printStackTrace(System.err);
        System.err.println();
        System.exit(1);
    }

    private static void usage() {
        System.err.println("Usage: philadelphia-acceptor <port>");
        System.exit(2);
    }

}
