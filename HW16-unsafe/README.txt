# Flight Landing Manager

The Flight Landing Manager is a Java program that simulates the takeoff and landing of flights. It utilizes multi-threading and synchronization mechanisms to manage the current capacity of flights at an airport.

## Functionality

The Flight Landing Manager consists of the following classes:

- `FlightLandingManager`: Manages the current capacity of flights at the airport. It provides methods for takeoff and landing, which increment and decrement the current capacity, respectively.

- `TakeoffRunnable`: Represents a thread responsible for initiating takeoff operations. It interacts with the `FlightLandingManager` to increment the current capacity. The thread sleeps for 1 second between each takeoff operation.

- `LandingRunnable`: Represents a thread responsible for initiating landing operations. It interacts with the `FlightLandingManager` to decrement the current capacity. The thread sleeps for 1 second between each landing operation.

- `Main`: Contains the main method to start the program. It creates instances of `FlightLandingManager`, `TakeoffRunnable`, and `LandingRunnable`, and starts the corresponding threads. After a certain duration, the program interrupts the threads and stops the takeoff and landing operations.





