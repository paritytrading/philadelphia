# Upgrading to Philadelphia 1.0.0

Philadelphia 1.0.0 contains major API changes. See below for details.

- `FIXSession` is now called `FIXConnection`. This name better reflects the
  role of this class.

- `FIXStatusListener` is now called `FIXConnectionStatusListener`. This name
  better reflects the role of this class.

- `FIXField` does not exist anymore. Use `FIXMessage#tagAt(int)` and
  `FIXMessage#valueAt(int)` to directly access the tags and values in a
  message. Note that methods that operate on indexes have the "at"
  preposition in their names.

- `FIXMessage#findField(int)` and `FIXMessage#findIndex(int)` are now called
  `FIXMessage#valueOf(int)` and `FIXMessage#indexOf(int)`, respectively.
  Note that methods that operate on tags have the "of" preposition in their
  names.
