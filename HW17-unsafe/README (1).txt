# Flight Landing Manager

This project demonstrates a flight landing manager that handles the takeoff and landing of flights using Java's concurrency features, such as locks and conditions.


The code consists of the following classes:

- `FlightLandingManager`: Manages the current capacity of the landing runway and provides methods for takeoff and landing. It uses a `ReentrantLock` and a `Condition` for synchronization.

- `LandingRunnable`: Implements the `Runnable` interface and represents a thread responsible for landing flights. It interacts with the `FlightLandingManager` to perform landing operations.

- `TakeoffRunnable`: Implements the `Runnable` interface and represents a thread responsible for takeoff operations. It interacts with the `FlightLandingManager` to perform takeoff operations.

- `Main`: The main class that creates instances of `FlightLandingManager`, `TakeoffRunnable`, and `LandingRunnable`, and starts the corresponding threads.

  
Program Flow:

1. The Main class creates an instance of FlightLandingManager and instances of TakeoffRunnable and LandingRunnable, passing the FlightLandingManager instance to them.
2. Three threads (t1, t2, t3) are created, where t1 and t3 run TakeoffRunnable, and t2 runs LandingRunnable.
3. The threads start and run concurrently, simulating flight takeoff and landing operations.
4. After a certain period (1 second in the provided code), the program interrupts the threads and sets the done flag to stop further operations.
5. The program exits.
