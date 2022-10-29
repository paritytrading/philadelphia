# Upgrading to Philadelphia 2.0.0

Philadelphia 2.0.0 contains major changes. See below for details.

## Dependencies

Philadelphia 2.0.0 no longer depends on Joda-Time 2.x.

If you are upgrading from Philadelphia 1.2.0 or newer and have a Joda-Time 2.x
dependency in your application just because of Philadelphia, you can now remove
it.

## Configuration

Philadelphia 2.0.0 renames some of the `FIXConfig` and `FIXConfig.Builder`
methods.

  Old name                                   | New name
  -------------------------------------------|--------------------------------------
  `FIXConfig#getIncomingMsgSeqNum()`         | `FIXConfig#getInMsgSeqNum()`
  `FIXConfig#getOutgoingMsgSeqNum()`         | `FIXConfig#setOutMsgSeqNum()`
  `FIXConfig.Builder#setIncomingMsgSeqNum()` | `FIXConfig.Builder#setInMsgSeqNum()`
  `FIXConfig.Builder#setOutgoingMsgSeqNum()` | `FIXConfig.Builder#setOutMsgSeqNum()`

Philadelphia 2.0.0 also replaces the `FIXConfig#getVersion()` method with a
`FIXConfig#getBeginString()` method.

## Connections

The bulk of the changes in Philadelphia 2.0.0 concern the `FIXConnection`
class.

### Naming changes

Philadelphia 2.0.0 renames some of the `FIXConnection` methods.

  Old name                               | New name
  ---------------------------------------|----------------------------------
  `FIXConnection#getIncomingMsgSeqNum()` | `FIXConnection#getInMsgSeqNum()`
  `FIXConnection#getOutgoingMsgSeqNum()` | `FIXConnection#getOutMsgSeqNum()`

### Channel management

Philadelphia 2.0.0 no longer provides the `FIXConnection#getChannel()` method.
This is because it adds support for other channel types besides `SocketChannel`
and even separate channels for receiving and transmitting data.

### Time handling

Philadelphia 2.0.0 no longer provides the `Clock` interface. Instead, the
`FIXConnection` class now takes the current timestamp in milliseconds both in
its constructors as well as in the `FIXConnection#setCurrentTimeMillis()`
method, which replaces the `FIXConnection#updateCurrentTimestamp()` method.
See below for examples on how to update your code to account for this change. 

Before:
```java
// Construct an instance.
FIXConnection connection = new FIXConnection(channel, config, listener,
        statusListener);

// Update the current time.
connection.updateCurrentTimestamp();
```

After:
```java
// Construct an instance.
FIXConnection connection = new FIXConnection(channel, config, listener,
        statusListener, System.currentTimeMillis());

// Update the current time.
connection.setCurrentTimeMillis(System.currentTimeMillis());
```

### Keep-alive mechanism

Philadelphia 2.0.0 replaces the
`FIXConnectionStatusListener#heartbeatTimeout()` method with the
`FIXHeartbeatTimeoutException` class. The `FIXConnection#keepAlive()` method
throws this exception when it detects a heartbeat timeout. See below for an
example on how to update your code to account for this change.

Before:
```java
FIXConnectionStatusListener statusListener = new FIXConnectionStatusListener() {

    @Override
    public void heartbeatTimeout(FIXConnection connection) {
        System.err.println("Heartbeat timeout");
    }

    ...
```

After:
```java
try {
    connection.keepAlive();
} catch (FIXHeartbeatTimeoutException e) {
    System.err.println("Heartbeat timeout");
}
```

### Message routing

Philadelphia 2.0.0 removes the `FIXConnection#updateCompID()` method. See below
for an example on how to update your code to account for this change.

Before:
```java
connection.updateCompID(message);
```

After:
```java
message.valueOf(SenderCompID).setString(connection.getSenderCompID());
message.valueOf(TargetCompID).setString(connection.getTargetCompID());
```

## Values

Philadelphia 2.0.0 introduces a number of changes to the `FIXValue` class.

`FIXValue` now implements the `CharSequence` interface. This has an impact on
some of the string methods: `FIXValue#asString()` now returns a `CharSequence`
rather than a `String`, and `FIXValue#asString(Appendable)` and
`FIXValue#asString(StringBuilder)` no longer exist. See below for examples on
how to update your code to account for these changes.

Before:
```java
// Convert an instance to a 'String' object.
String string = value.asString();
...
// Append an instance into an 'Appendable' object.
StringBuilder builder = new StringBuilder();
value.asString(builder);
```

After:
```java
// Convert an instance to a 'String' object.
String string = value.toString();
...
// Append an instance into an 'Appendable' object.
StringBuilder builder = new StringBuilder();
builder.append(value);
```

The `FIXValue#setTimeOnly()` and `FIXValue#setTimestamp()` methods are now both
split into two variants and the `millis` parameter is removed. See below for
examples on how to update your code to account for this change.

Before:
```java
// Set a time only into an instance with the granularity of seconds.
value.setTimeOnly(timestamp, false);
...
// Set a time only into an instance with the granularity of milliseconds.
value.setTimeOnly(timestamp, true);
...
// Set a timestamp into an instance with the granularity of seconds.
value.setTimestamp(timestamp, false);
...
// Set a timestamp into an instance with the granularity of milliseconds.
value.setTimestamp(timestamp, true);
```

After:
```java
// Set a time only into an instance with the granularity of seconds.
value.setTimeOnlySecs(timestamp);
...
// Set a time only into an instance with the granularity of milliseconds.
value.setTimeOnlyMillis(timestamp);
...
// Set a timestamp into an instance with the granularity of seconds.
value.setTimestampSecs(timestamp);
...
// Set a timestamp into an instance with the granularity of milliseconds.
value.setTimestampMillis(timestamp);
```

The `FIXValue#asCheckSum()` method no longer exists. Use the `FIXValue#asInt()`
method instead.

## Dates and times

Philadelphia 2.0.0 introduces a new `FIXTimestamp` class to replace uses of
Joda-Time's `MutableDateTime` class and `ReadableDateTime` interface. This not
only removes the dependency on Joda-Time but also improves the performance of
date and time operations. See below for examples on how to update your code to
account for this change.

Before:
```java
// Construct an instance.
MutableDateTime timestamp = new MutableDateTime();
...
// Set the instance to the current timestamp in milliseconds.
timestamp.setMillis(System.currentTimeMillis());
...
// Format the instance into a value.
value.setTimestamp(timestamp, true);
...
// Parse a value into the instance.
value.getTimestamp(timestamp);
...
// Get the millisecond field from the instance.
int milli = timestamp.getMillisOfSecond();
```

After:
```java
// Construct an instance.
FIXTimestamp timestamp = new FIXTimestamp();
...
// Set the instance to the current timestamp in milliseconds.
timestamp.setEpochMilli(System.currentTimeMillis());
...
// Format the instance into a value.
value.setTimestampMillis(timestamp);
...
// Parse a value into the instance.
value.getTimestamp(timestamp);
...
// Get the millisecond field from the instance.
int milli = timestamp.getMilli();
```

## Miscellanea

Philadelphia 2.0.0 no longer provides the following classes: `FIXCheckSums`,
`FIXTags`, and `FIXTimestamps`. Applications that rely on their functionality
now need to provide it themselves.
