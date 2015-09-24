Developer Guide
===============

Welcome to Philadelphia Developer Guide. The purpose of this document is to
help you get started with developing Philadelphia on your own workstation.

Developing Philadelphia requires Java Development Kit (JDK) 7 or newer and
Maven.


Test
----

Run the tests with Maven:

    mvn test


Build
-----

Build the artifacts with Maven:

    mvn package

Maven puts the artifacts into a `target` directory under each module.


Run
---

After building the artifacts, the executables can be found in the `target`
directories. Their filenames have the following format:

    <module>-<version>.jar

Run an executable with Java:

    java -jar <executable>
