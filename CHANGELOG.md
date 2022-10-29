# Release Notes

## 2.0.0 (????-??-??)

See the [upgrade instructions](UPGRADE-2.0.0.md).

- Make `FIXCheckSums` package-private (Jussi Virtanen)

  Despite being public, `FIXCheckSums` is essentially an internal utility
  class. Make it package-private to reflect this and gain more flexibility
  for the future.

- Make `FIXTags` package-private (Jussi Virtanen)

  See above.

- Remove `FIXTimestamps` (Jussi Virtanen)

  See above.

- Improve `FIXValue` (Jussi Virtanen)

  Make the `FIXValue` class implement the `CharSequence` interface. Change the
  return type of the `FIXValue#asString` method from `String` to `CharSequence`
  to avoid memory allocation, and remove the `FIXValue#asString(Appendable)`
  and `FIXValue#asString(StringBuilder)` methods as superfluous.

  Split the `FIXValue#setTimeOnly` method into `FIXValue#setTimeOnlyMillis`
  and `FIXTimeOnly#setTimeOnlySecs`, and split the
  `FIXValue#setTimestamp` method into `FIXValue#setTimestampMillis` and
  `FIXValue#setTimestampSecs`.

  Remove the `FIXValue#asCheckSum` method.

- Improve `FIXConnection` (Dimitar Dimitrov, dmech, Jussi Virtanen)

  Remove the `Clock` interface, and make the `FIXConnection` constructors to
  take the current timestamp in milliseconds instead. Replace the
  `FIXConnection#updateCurrentTimestamp` method with
  `FIXConnection#setCurrentTimeMillis`.

  Remove the `FIXConnection#updateCompID` method. Use
  `FIXConnection#getSenderCompID` and `FIXValue#getTargetCompID` together with
  the `FIXValue` methods instead.

  Add support for other channel types besides `SocketChannel`, and add support
  for separate channels for receiving and transmitting data. Remove the
  `FIXConnection#getChannel` method to facilitate this.

  Remove the `FIXConnectionStatusListener#heartbeatTimeout` method, and add the
  `FIXHeartbeatTimeoutException` class. Throw this exception when a heartbeat
  timeout is detected in the `FIXConnection#keepAlive` method.

  Make `FIXConnectionStatusListener`, and therefore the default administrative
  message handling, optional. This makes it possible for applications to handle
  inbound administrative messages themselves.

  Add the methods `FIXConnection#setInMsgSeqNum`,
  `FIXConnection#setOutMsgSeqNum`, `FIXConnection#setSenderCompID`, and
  `FIXConnection#setTargetCompID`. Rename the
  `FIXConnection#getIncomingMsgSeqNum` method to `getInMsgSeqNum`, and rename
  the `FIXConnection#getOutgoingMsgSeqNum` method to `setOutMsgSeqNum`.

- Add `FIXTimestamp` (Jussi Virtanen)

  Replace uses of Joda-Time's `MutableDateTime` class and `ReadableDateTime`
  interface with a `FIXTimestamp` class. While its design is inspired by the
  `java.time` package and the `LocalDateTime` class in particular, it is
  mutable unlike `LocalDateTime`.

  With `FIXTimestamp`, the date and time operations on `FIXValue` become at
  best over three times as fast as they were with `MutableDateTime`. These
  benchmarks include the conversion from date and time fields into a timestamp
  in millisecods or vice versa. However, as `FIXTimestamp` internally stores
  the instant it represents in date and time fields rather than as a timestamp
  in milliseconds, these conversions only take place when explicitly invoking
  the `FIXTimestamp#getEpochMilli` and `FIXTimestamp#setEpochMilli` methods.

  This change removes the Joda-Time 2.x dependency.

- Update FIX 4.3 support (Jussi Virtanen)

  Regenerate the FIX 4.3 support from the latest FIX Repository version.

- Update FIXT 1.1 support (Jussi Virtanen)

  Regenerate the FIXT 1.1 support from the latest FIX Ochestra version.

- Add FIX 4.0 support (Jussi Virtanen)

- Add FIX 4.1 support (Jussi Virtanen)

- Improve `FIXConfig` (Jussi Virtanen)

  Define constants for default values. Add a static `FIXConfig.newBuilder`
  method to simplify `FIXConfig.Builder` construction. Add a
  `FIXConfig.DEFAULTS` constant to simplify default configuration usage.

  Replace the `FIXConfig#getVersion` method with a `FIXConfig#getBeginString`
  method.

  Rename the `FIXConfig#getIncomingMsgSeqNum` method to
  `FIXConfig#getInMsgSeqNum` and the `FIXConfig.Builder#getOutgoingMsgSeqNum`
  method to `FIXConfig#getOutMsgSeqNum`. Rename the corresponding methods in
  `FIXConfig.Builder` similarly to `FIXConfig.Builder#setInMsgSeqNum` and
  `FIXConfig.Builder#setOutMsgSeqNum`.

- Update FIX Latest support (Jussi Virtanen)

  Regenerate the FIX Latest support from the latest FIX Orchestra version,
  including Extension Packs up to EP272.

## 1.3.2 (2022-10-28)

- Improve Logon(A) handling (dmech)

  Handle a Logon(A) message with too high MsgSeqNum(34) value, but send a
  Logout(5) message when receiving a Logon(A) message with too low
  MsgSeqNum(34) value.

## 1.3.1 (2022-05-21)

- Fix MsgSeqNum(34) handling on SequenceReset(4) (Vadim Platonov, Jussi
  Virtanen)

  Do not increment the outgoing MsgSeqNum(34) value when sending a
  SequenceReset(4) message.

- Improve Logout(5) handling (Vadim Platonov, Jussi Virtanen)

  Handle a Logout(5) message with too low MsgSeqNum(34) value, but still send
  a ResendRequest(2) message when receiving a Logout(5) message with too high
  MsgSeqNum(34) value.

## 1.3.0 (2021-05-21)

- Improve `FIXValueTest` (Jussi Virtanen)

  Make test cases that rely on the side effect of an attempt to read an
  incomplete value from a buffer partially populating the value container to
  actually read a complete value.

  Improve test coverage for all `FIXValue` methods.

- Optimize `FIXValue` (Jussi Virtanen)

  Decrease the bytecode size of the `FIXValue#setDigits` method from 44 to 31
  bytes, which is within HotSpot's default maximum inline size of 35 bytes.
  This makes the following methods faster:

  - `FIXValue#setCheckSum`
  - `FIXValue#setDate`
  - `FIXValue#setTimeOnly`
  - `FIXValue#setTimestamp`

  Decrease the bytecode size of the `FIXValue#setInt` method from 102 to 79
  bytes, making it faster.

  Decrease the bytecode size of the `FIXValue#setFloat` method from 177 to 161
  bytes, making it faster.

- Add `FIXMessage(FIXConfig)` (Jussi Virtanen)

- Add `FIXValue#toString` (Jussi Virtanen)

- Add `FIXMessage#valueOf(int,int)` and `FIXMessage#indexOf(int,int)` (Kasimir
  Torri)

  Make it possible to get the index or the value container of the first
  instance of a field with a specific tag, starting from a specific index.

- Optimize `FIXTimestamps` (Jussi Virtanen)

  Decrease the bytecode size of the `FIXTimestamps.setDigits` method from 36 to
  28 bytes, which is within HotSpot's default maximum inline size of 35 bytes.
  This makes the `FIXTimestamps.append` method faster.

- Add `FIXValue#asString(Appendable)` (Jussi Virtanen)

- Add `FIXValue#contentEquals` (Jussi Virtanen)

- Add FIX Orchestra support to Philadelphia Code Generator (Jussi Virtanen)

- Add FIX Latest support (Jussi Virtanen)

- Improve `FIXMessageParser` (Jussi Virtanen)

  Optimize parsing of the BeginString(8), BodyLength(9), and CheckSum(10)
  values, making message parsing faster.

- Fix EndSeqNo(16) handling (Marcus Harte, Jussi Virtanen)

  Handle the value 0 for the EndSeqNo(16) field in a ResendRequest(2) message
  correctly. This value represents infinity and corresponds to all subsequent
  messages after the message referred to by the BeginSeqNo(7) field.

- Improve BeginSeqNo(7) handling (Marcus Harte, Jussi Virtanen)

  Respond with a Reject(3) message if the BeginSeqNo(7) value in a
  ResendRequest(2) message exceeds the current MsgSeqNum(34) value.

- Improve NewSeqNo(36) handling (Marcus Harte, Jussi Virtanen)

  Limit the NewSeqNo(36) value in a subsequent SequenceReset(4) message to
  the current MsgSeqNum(34) if the EndSeqNo(16) value in the preceding
  ResendRequest(2) message exceeds it.

## 1.2.0 (2020-03-03)

See the [upgrade instructions](UPGRADE-1.2.0.md).

- Improve MsgType(35) handling (Jonathan Heusser, Jussi Virtanen)

  When checking for SequenceReset(4), check the first byte of the MsgType(35)
  value before checking its length. This avoids one conditional check for most
  messages.

  Remove a dead branch from the MsgType(35) switch statement following the
  MsgSeqNum(34) handling.

- Fix `send` command in Philadelphia Terminal Client (Jussi Virtanen)

  Make it possible to send a message containing a field with whitespace
  characters.

- Improve `FIXValue#asFloat` and `FIXValue#setFloat` (Jussi Virtanen)

- Improve `FIXValueTest` (Jussi Virtanen)

- Improve `FIXConfigTest` (Jan Nielsen)

- Add example script for Philadelphia Terminal Client (Jussi Virtanen)

- Mark `FIXValue#asCheckSum()` as deprecated (Jussi Virtanen)

- Improve Philadelphia Terminal Client documentation (Jussi Virtanen)

- Improve `FIXMessageParserBenchmark` (Jussi Virtanen)

  Add a benchmark for when the incoming CheckSum(10) check is disabled.

- Improve `FIXMessageParser` (Jussi Virtanen)

  Having the incoming CheckSum(10) check in a separate method makes message
  parsing 9.6% faster in the performance test when the incoming CheckSum(10)
  check is disabled and 3.7% faster when it is enabled.

  Inlining parsing of BeginString(8), BodyLength(9), and CheckSum(10) tags
  makes message parsing further 5.9% faster in the performance test when the
  incoming CheckSum(10) check is disabled and 6.1% faster when it is enabled.

- Fix `wait` command in Philadelphia Terminal Client (Jussi Virtanen)

  The `wait` command looked at received messages at an interval, stopping if
  the last received message had a matching MsgType(35) value. If two or more
  messages were received within one interval, the `wait` command might have
  missed a matching MsgType(35) value and erroneously continued waiting.

- Remove transitive Joda-Time dependency (Jussi Virtanen)

  Replace the transitive Joda-Time 2.10.5 dependency with a Joda-Time 2.x
  dependency. This makes it possible for applications to manage their Joda-Time
  2.x and Philadelphia Core dependencies independently.

- Improve `FIXValue#asTimeOnly` (Jussi Virtanen)

  Set the fields all at once rather than one by one. This makes the method 33%
  faster.

## 1.1.1 (2019-06-25)

- Fix message header buffer handling (Jussi Virtanen)

  Before manipulating the message header, invoke `ByteBuffer#clear()` to reset
  the buffer's limit back to its capacity.

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
