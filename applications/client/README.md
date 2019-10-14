# Philadelphia Terminal Client

Philadelphia Terminal Client is a simple console application for interacting
with a FIX acceptor.

## Usage

Run Philadelphia Terminal Client with Java:

```
java -jar philadelphia-client.jar <configuration-file>
```

When started, the terminal client displays a command prompt:

```
Type 'help' for help.
>
```

You can interact with the terminal client by entering commands into the
command prompt. For example, to send a message, use the `send` command:

```
> send 35=A|98=0|108=30|553=foo|554=bar
```

The terminal client automatically generates the message header apart from
MsgType(35) as well as the message trailer.

To list received messages, use the `messages` command:

```
> messages
```

Use the `help` command to see a list of all available commands.

## Configuration

Philadelphia Terminal Client uses a configuration file to specify how to
connect to a FIX acceptor.

The following configuration parameters are required:

```
fix {

  # The FIX protocol version: FIX_4_2, FIX_4_3, FIX_4_4, or FIXT_1_1.
  version = FIX_4_2

  # SenderCompID(49) for the terminal client.
  sender-comp-id = initiator

  # TargetCompID(56) for the terminal client.
  target-comp-id = acceptor

  # HeartBtInt(108) for the terminal client.
  heart-bt-int = 30

  # The IP address of the FIX acceptor.
  address = 127.0.0.1

  # The TCP port of the FIX acceptor.
  port = 4000

}
```

See the `etc` directory for an example configuration file.

## License

Released under the Apache License, Version 2.0.
