# Philadelphia

Philadelphia is a low-latency Financial Information Exchange (FIX) engine for
the JVM.

You can use Philadelphia to connect to stock exchanges, brokerage firms, and
other network endpoints that use the FIX protocol. You can also use it to
provide your own services using the FIX protocol.

Philadelphia is designed to exhibit low and predictable latency. To achieve
this, it supports non-blocking, zero-copy networking and does not allocate
any memory on message reception or transmission. It can achieve [7.7 µs
round-trip time (RTT)](examples/initiator) over the loopback interface.

Philadelphia requires Java Runtime Environment (JRE) 8 or newer.

## Download

See the [latest release][] on GitHub.

  [latest release]: https://github.com/paritytrading/philadelphia/releases/latest

## Modules

Philadelphia contains the following libraries:

- [**Core**](libraries/core) implements the Financial Information Exchange
  (FIX) protocol.

- [**FIX 4.2**](libraries/fix42), [**FIX 4.3**](libraries/fix43),
  [**FIX 4.4**](libraries/fix44), [**FIX 5.0**](libraries/fix50),
  [**FIX 5.0 SP1**](libraries/fix50sp1),
  [**FIX 5.0 SP2**](libraries/fix50sp2), and
  [**FIXT 1.1**](libraries/fixt11) implement the FIX protocol versions.

See the [FIX Trading Community][] for the protocol specifications and
[Philadelphia Extras][] for additional FIX dialects.

  [FIX Trading Community]: http://www.fixtrading.org
  [Philadelphia Extras]: https://github.com/paritytrading/philadelphia-extras

Philadelphia contains the following applications:

- [**Terminal Client**](applications/client) is a simple console application
  for interacting with a FIX acceptor.

- [**Code Generator**](applications/generate) is a simple console application
  for generating Philadelphia profiles for FIX dialects.

Philadelphia contains the following example applications:

- [**Test Acceptor**](examples/acceptor) implements a simple FIX acceptor.

- [**Test Initiator**](examples/initiator) implements a simple FIX initiator.

Philadelphia contains the following test applications:

- [**Performance Test**](tests/perf-test) contains microbenchmarks
  for the FIX protocol implementation.

## Links

For more information on Philadelphia:

- Follow [@paritytrading](https://twitter.com/paritytrading) on Twitter for
  news and announcements
- Join [paritytrading/chat](https://gitter.im/paritytrading/chat) on Gitter
  for discussions

## License

Copyright 2015 Philadelphia authors.

Released under the Apache License, Version 2.0. See `LICENSE.txt` for details.
