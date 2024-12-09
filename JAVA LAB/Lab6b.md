 DESCRIPTION
Simulates a coffee shop scenario with multithreading. Baristas (producers)
prepare coffee and add it to a shared counter, while customers (consumers)
pick up coffee from the counter. A coffee reviewer (observer) samples coffee
when available. Synchronization between threads is achieved using wait() and
notifyAll() to ensure proper coordination and avoid race conditions.

 OUTPUT
Barista prepared coffee. Counter: 1                                                                                                                              
Barista prepared coffee. Counter: 2
Customer 3 picked up coffee. Counter: 1
Customer 2 picked up coffee. Counter: 0
Customer 1 is waiting. Counter is empty.
Reviewer is waiting. Counter is empty.
Barista prepared coffee. Counter: 1
Customer 1 picked up coffee. Counter: 0
Reviewer is waiting. Counter is empty.
Customer 2 is waiting. Counter is empty.
Barista prepared coffee. Counter: 1
Reviewer sampled coffee. Counter: 0
Customer 2 is waiting. Counter is empty.
Barista prepared coffee. Counter: 1
Customer 2 picked up coffee. Counter: 0
Simulation complete.
