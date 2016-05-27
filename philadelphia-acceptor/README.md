Philadelphia Test Acceptor
==========================

Philadelphia Test Acceptor is an example application implementing a simple
FIX acceptor.


Usage
-----

Run Philadelphia Test Acceptor with Java:

    java -jar <executable> <port>

When started, the application listens for a FIX connection on the specified
port. After a FIX session is established, it responds to Order Single messages
with Execution Report messages.


Build
-----

See [Parity Guide][].

  [Parity Guide]: https://github.com/paritytrading/documentation


License
-------

Philadelphia Test Acceptor is released under the Apache License, Version 2.0.
