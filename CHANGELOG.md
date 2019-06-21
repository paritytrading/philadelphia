# Release Notes

## 1.1.0 (2019-06-21)

- Improve `FIXValue` class (Jonathan Heusser, Jussi Virtanen)

  Make `FIXValue#set()` work correctly if the specified value container
  contains a value at a non-zero offset.

  Optimize the bytecode sizes of various methods so that they are under
  HotSpot's default maximum inline size of 35 bytes. Move the logic to
  construct and throw exceptions off the fast path. Replace a modulo
  operation with a bitwise AND operation.

- Improve `FIXConnection` class (Jussi Virtanen)

  Simplify message header and trailer handling. Move the logic to handle
  unexpected MsgSeqNum(34) values as well as construct and throw exceptions
  off the fast path. Simplify TestRequest(1) and SequenceReset(4) handling.

  After sending a TestRequest(1) message, consider the keep-alive procedure
  successful on receiving any data from the other party, not just a
  Heartbeat(0) message.

  Optimize the bytecode sizes of `FIXConnection#update()` and
  `FIXConnection#updateCompID()` so that they are under HotSpot's default
  maximum inline size of 35 bytes. Note that after this change, these methods
  will throw a `NullPointerException` instead of an `IllegalStateException`
  if any of the required fields are not found.

- Optimize `FIXMessage` class (Jussi Virtanen)

  Move the logic to construct and throw exceptions off the fast path.

- Optimize `FIXTimestamps` class (Jussi Virtanen)

  Add a buffer to make formatting operations faster.

- Improve `FIXMessageParser` class (Jonathan Heusser, Sergey Khomich, Jussi
  Virtanen)

  Make the class public. Replace a modulo operation with a bitwise AND
  operation. Add a performance test.

- Add `FIXValue#asBoolean()` and `FIXValue#setBoolean()` methods (Jussi
  Virtanen)

- Optimize `FIXTags` class (Jussi Virtanen)

  Move the logic to construct and throw exceptions off the fast path.

- Improve code quality (Jan Nielsen, Jussi Virtanen)

  Clean up project dependencies. Clean up imports. Remove superfluous `public`
  modifiers. Use `final` modifier.

- Improve Philadelphia Code Generator (Jussi Virtanen)

  Make Philadelphia Code Generator's version track Philadelphia's version.
  Add a comment to output files indicating that they have been automatically
  generated.

- Improve Philadelphia Terminal Client (Jussi Virtanen)

  Handle Ctrl+C and Ctrl+D. Fix command completion.

- Improve Philadelphia Example Initiator (Arturo Salinas)

  Fix coordinated omission: instead of sending the next message right after
  receiving the previous message, send messages at regular intervals.

- Upgrade to Joda-Time 2.10.2 (Jussi Virtanen)

## 1.0.0 (2018-08-17)

- Remove `FIXField` class
- Add `FIXMessage#tagAt()` method
- Add `FIXMessage#valueAt()` method
- Rename `FIXMessage#findIndex()` method to `indexOf()`
- Rename `FIXMessage#findField()` method to `valueOf()`
- Optimize TCP socket handling
- Add `FIXMessage.fromString()` method
- Rename `FIXSession` class to `FIXConnection`
- Rename `FIXStatusListener` class to `FIXConnectionStatusListener`
- Upgrade to Joda-Time 2.10

See the [upgrade instructions](UPGRADE-1.0.0.md) for more details.

## 0.7.0 (2018-06-25)

- Add comment support to Philadelphia Terminal Client
- Add input file support to Philadelphia Terminal Client
- Improve `messages` command in Philadelphia Terminal Client
- Add `sleep` command to Philadelphia Terminal Client
- Add `wait` command to Philadelphia Terminal Client
- Make `Clock` interface public
- Add `FIXMessage#findIndex()` method
- Clean up MatchType(574) handling in Philadelphia FIX 5.0
- Add Philadelphia Code Generator

## 0.6.1 (2018-03-06)

- Add `FIXMessage#toString()` method
- Add `FIXConfig#toString()` method
- Use `System.arraycopy()` in `FIXValue#set()` method

## 0.6.0 (2017-08-13)

- Extract Philadelphia FIX 4.2 module
- Extract Philadelphia FIX 4.3 module
- Extract Philadelphia FIX 4.4 module
- Extract Philadelphia FIX 5.0 module
- Extract Philadelphia FIX 5.0 SP1 module
- Extract Philadelphia FIX 5.0 SP2 module
- Extract Philadelphia FIXT 1.1 module
- Add alias for CxlRejResponseTo(434) value
- Add `FIXValue#copyTo()` method
- Clean up QuoteCondition(276) values
- Make incoming CheckSum(10) check optional
- Use direct byte buffer
- Improve `FIXSession` performance
- Improve project structure
- Upgrade to Joda-Time 2.9.9

## 0.5.0 (2016-08-23)

- Fix links in documentation
- Add access to byte by index

## 0.4.0 (2016-05-24)

- Expose next incoming and outgoing MsgSeqNum(34)
- Expose SenderCompID(49) and TargetCompID(56)
- Fix handling of incoming message too long to fit into receive buffer

## 0.3.0 (2016-03-30)

- Move to `com.paritytrading` namespace

## 0.2.2 (2016-03-28)

- Add support for running data reception and transmission on different threads
- Fix FIXT 1.1 support for inbound messages

## 0.2.1 (2016-03-25)

- Fix FIXT 1.1 support for outbound messages

## 0.2.0 (2016-03-15)

- Add session parameter to session status listener
- Add FIXT 1.1 support
- Handle incoming message too long to fit into receive buffer
- Add terminal client
- Add FIX 5.0 support
- Add FIX 5.0 Service Pack 1 support
- Add FIX 5.0 Service Pack 2 support
- Upgrade to Java 8

## 0.1.0 (2015-12-25)

- Initial release
