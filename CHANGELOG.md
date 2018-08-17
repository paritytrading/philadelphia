# Release Notes

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
