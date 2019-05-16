# Philadelphia Test Initiator

Philadelphia Test Initiator is an example application implementing a simple
FIX initiator.

## Usage

Run Philadelphia Test Initiator with Java:

```
java -jar philadelphia-initiator.jar <host> <port> <orders> <orders-per-second>
```

The application measures the round-trip time (RTT) between sending an Order
Single message and receiving an Execution Report message.

## Results

The following results have been obtained running both Philadelphia Test
Acceptor and Philadelphia Test Initiator on one Amazon Web Services (AWS)
c4.xlarge EC2 instance running Amazon Linux 2016.09 and OpenJDK 8:

```
Warming up...
Benchmarking...
Results (n = 50000)

   50.00%:       7.68 µs
   90.00%:       8.36 µs
   99.00%:      14.00 µs
   99.90%:      19.02 µs
   99.99%:      43.84 µs
  100.00%:      79.04 µs
```

## License

Released under the Apache License, Version 2.0.
