Philadelphia
============

Philadelphia is a low latency Financial Information Exchange (FIX) engine for
the JVM.

You can use Philadelphia to connect to stock exchanges, brokerage firms, and
other network endpoints that use the FIX protocol. You can also use it to
provide your own services using the FIX protocol.

Philadelphia is designed to exhibit low and predictable latency. To achieve
this, it supports non-blocking, zero-copy networking and does not allocate
any memory on message reception or transmission. It can achieve [7.7 µs
round-trip time (RTT)](philadelphia-initiator) over the loopback interface.

Philadelphia requires Java Runtime Environment (JRE) 8 or newer.


Features
--------

Philadelphia implements the following FIX protocol versions:

- [**FIX 4.2**](libraries/fix42)
- [**FIX 4.3**](libraries/fix43)
- [**FIX 4.4**](philadelphia-fix44)
- [**FIX 5.0**](philadelphia-fix50)
- [**FIX 5.0 Service Pack 1**](philadelphia-fix50sp1)
- [**FIX 5.0 Service Pack 2**](philadelphia-fix50sp2)
- [**FIXT 1.1**](philadelphia-fixt11)

See the [FIX Trading Community][] for the protocol specifications and
[Philadelphia Extras][] for additional FIX dialects.

  [FIX Trading Community]: http://www.fixtradingcommunity.org
  [Philadelphia Extras]: https://github.com/paritytrading/philadelphia-extras

Besides the library, Philadelphia contains the following applications:

- [**Terminal Client**](philadelphia-client) is a simple console application
  for interacting with a FIX acceptor

- [**Test Acceptor**](philadelphia-acceptor) is an example application
  implementing a simple FIX acceptor

- [**Test Initiator**](philadelphia-initiator) is an example application
  implementing a simple FIX initiator

- [**Performance Test**](philadelphia-perf-test) contains microbenchmarks
  for the FIX protocol implementation


Download
--------

Add a Maven dependency to Philadelphia:

    <dependency>
      <groupId>com.paritytrading.philadelphia</groupId>
      <artifactId>philadelphia-core</artifactId>
      <version><!-- latest version --></version>
    </dependency>


Links
-----

For more information on Philadelphia:

- See [Parity Guide](https://github.com/paritytrading/documentation) for the
  user and developer documentation
- Follow [@paritytrading](https://twitter.com/paritytrading) on Twitter for
  news and announcements
- Join [paritytrading/chat](https://gitter.im/paritytrading/chat) on Gitter
  for discussions


License
-------

Copyright 2015 Jussi Virtanen and contributors.

Released under the Apache License, Version 2.0. See `LICENSE.txt` for details.
