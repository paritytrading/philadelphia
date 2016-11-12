Philadelphia Terminal Client
============================

Philadelphia Terminal Client is a simple console application for interacting
with a FIX acceptor.


Usage
-----

Run Philadelphia Terminal Client with Java:

    java -jar <executable> <configuration-file>

When started, the terminal client displays a command prompt:

    Type 'help' for help.
    >

You can interact with the terminal client by entering commands into the
command prompt. For example, to send a message, use the `send` command:

    > send 35=A|98=0|108=30|553=foo|554=bar

The terminal client automatically generates the message header apart from
MsgType(35) as well as the message trailer.

To list received messages, use the `messages` command:

    > messages

Use the `help` command to see a list of all available commands.


License
-------

Released under the Apache License, Version 2.0.
