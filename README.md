Philadelphia
============

Philadelphia is a Financial Information Exchange (FIX) engine for the JVM.

Philadelphia requires Java Runtime Environment (JRE) 7 or newer.


Features
--------

Philadelphia implements the following FIX protocol versions:

  - **FIX 4.2**

Besides the library, Philadelphia contains the following applications:

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
      <groupId>org.jvirtanen.philadelphia</groupId>
      <artifactId>philadelphia</artifactId>
      <version><!-- latest version --></version>
    </dependency>


Development
-----------

See the [Developer Guide](HACKING.md).


License
-------

Philadelphia is released under the Apache License, Version 2.0. See `LICENSE`
for details.
