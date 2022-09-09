# Upgrading to Philadelphia 2.0.0

Philadelphia 2.0.0 contains major changes. See below for details.

## Dependencies

Philadelphia 2.0.0 no longer depends on Joda-Time 2.x.

If you are upgrading from Philadelphia 1.2.0 or newer and have a Joda-Time 2.x
dependency in your application just because of Philadelphia, you can now remove
it.

## Dates and times

Philadelphia 2.0.0 introduces a new `FIXTimestamp` class to replace uses of
Joda-Time's `MutableDateTime` class and `ReadableDateTime` interface. This not
only removes the dependency on Joda-Time but also improves the performance of
date and time operations.

See below for examples on how to update your code to use `FIXTimestamp` instead
of `MutableDateTime` and `ReadableDateTime`.

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
