# Upgrading to Philadelphia 2.1.0

Philadelphia 2.1.0 requires Java Runtime Environment (JRE) 11 or newer. If
you are still on JRE 8, feel free to continue using Philadelphia 2.0.x or
earlier.

Philadelphia 2.1.0 also contains minor API changes. See below for details.

## Message capacity

Philadelphia 2.1.0 introduces the concept of message capacity: the number
of fields a message container can hold. It provides two new configuration
parameters for this purpose: the initial message capacity and the maximum
message capacity. A message container will grow when necessary, but its
capacity will not exceed its maximum.

The default initial message capacity is 64 fields, and the default maximum
message capacity is 65536 fields. Use the `setMinMessageCapacity()` and
`setMaxMessageCapacity()` methods in `FIXConfig.Builder` to alter these.

The `FIXConfig.Builder#setMaxFieldCount()` method is now deprecated. If you
want to retain the same behavior, use the `setMessageCapacity()` method
instead. It sets both the initial and the maximum message capacity to the
same value. See below for an example.

Before:
```java
FIXConfig config = FIXConfig.newBuilder()
        .setMaxFieldCount(128)
        .build();
```

After:
```java
FIXConfig config = FIXConfig.newBuilder()
        .setMessageCapacity(128)
        .build();
```

## Java modules

Philadelphia 2.1.0 introduces rudimentary Java module support by setting module
names for all Philadelphia libraries. These correspond to their package names.
For example, the module name for Philadelphia Core is:
```
com.paritytrading.philadelphia
```

If you use Java modules in your application and currently reference
Philadelphia libraries using module names derived from their JAR names (as the
JDK does by default), start using module names that correspond to their package
names instead. See below for an example.

Before:
```java
module example {
    requires philadelphia.core;
    requires philadelphia.fix42;
}
```

After:
```java
module example {
    requires com.paritytrading.philadelphia;
    requires com.paritytrading.philadelphia.fix42;
}
```
