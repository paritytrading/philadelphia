# Upgrading to Philadelphia 1.2.0

Philadelphia 1.2.0 contains a change in its dependency management.

Philadelphia Core 1.2.0 replaces the transitive Joda-Time 2.10.2 dependency
with a Joda-Time 2.x dependency. This makes it possible for applications to
manage their Joda-Time 2.x and Philadelphia Core dependencies independently.

If you do not already use Joda-Time 2.x in your application, you need to add
a Maven dependency to it. For example:

```xml
<dependency>
  <groupId>joda-time</groupId>
  <artifactId>joda-time</artifactId>
  <version>2.10.5</version>
</dependency>
```
