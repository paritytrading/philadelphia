# Philadelphia

Philadelphia is a fast Financial Information Exchange (FIX) protocol library
for the JVM.

You can use Philadelphia to connect to stock exchanges, brokerage firms, and
other network endpoints that use the FIX protocol. You can also use it to
provide your own services using the FIX protocol.

Philadelphia is designed to exhibit low and predictable latency. To achieve
this, it supports non-blocking networking and does not allocate memory on
message reception or transmission.

Philadelphia requires Java Runtime Environment (JRE) 8 or newer.

## Download

See the [latest release][] on GitHub.

  [latest release]: https://github.com/paritytrading/philadelphia/releases/latest

## Modules

Philadelphia contains the following libraries:

- [**Core**](libraries/core) implements the FIX protocol.

- [**FIX 4.0**](libraries/fix40), [**FIX 4.1**](libraries/fix41),
  [**FIX 4.2**](libraries/fix42), [**FIX 4.3**](libraries/fix43),
  [**FIX 4.4**](libraries/fix44), [**FIX 5.0**](libraries/fix50),
  [**FIX 5.0 SP1**](libraries/fix50sp1), [**FIX 5.0 SP2**](libraries/fix50sp2),
  [**FIX Latest**](libraries/fixlatest), and [**FIXT 1.1**](libraries/fixt11)
  implement profiles for the corresponding FIX protocol versions.

See the [FIX Trading Community][] for the protocol specifications.

  [FIX Trading Community]: http://www.fixtrading.org

Philadelphia contains the following applications:

- [**Terminal Client**](applications/client) is a simple console application
  for interacting with a FIX acceptor.

- [**Code Generator**](applications/generate) is a simple console application
  for generating profiles for FIX dialects.

Philadelphia contains the following example applications:

- [**Test Acceptor**](examples/acceptor) implements a simple FIX acceptor.

- [**Test Initiator**](examples/initiator) implements a simple FIX initiator.

Philadelphia contains the following test applications:

- [**Performance Test**](tests/perf-test) contains microbenchmarks
  for the FIX protocol implementation.

See [Philadelphia Extras][] for additional extensions.

  [Philadelphia Extras]: https://github.com/paritytrading/philadelphia-extras

## Links

For more information on Philadelphia:

- Follow [@paritytrading](https://twitter.com/paritytrading) on Twitter for
  news and announcements
- Join [the community][GitHub Discussions] on GitHub for discussions

  [GitHub Discussions]: https://github.com/paritytrading/philadelphia/discussions

## License

Copyright 2015 Philadelphia authors.

Released under the Apache License, Version 2.0. See `LICENSE.txt` for details.
