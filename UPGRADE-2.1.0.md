# Upgrading to Philadelphia 2.1.0

Philadelphia 2.1.0 contains minor API changes. See below for details.

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
