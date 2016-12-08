Philadelphia Test Acceptor
==========================

Philadelphia Test Acceptor is an example application implementing a simple
FIX acceptor.


Usage
-----

Run Philadelphia Test Acceptor with Java:

    java -jar philadelphia-acceptor.jar <port>

When started, the application listens for a FIX connection on the specified
port. After a FIX session is established, it responds to Order Single messages
with Execution Report messages.


License
-------

Released under the Apache License, Version 2.0.
