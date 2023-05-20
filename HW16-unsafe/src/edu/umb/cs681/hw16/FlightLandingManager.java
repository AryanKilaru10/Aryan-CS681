package edu.umb.cs681.hw16;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class FlightLandingManager {
    private double CurrentCapacity = 0;
    public void Takeoff(){
            CurrentCapacity++;
            System.out.println("Current capacity after takeoff: "+CurrentCapacity);

    }

    public void Land(){
            CurrentCapacity--;
            System.out.println("Current capacity after landing "+ CurrentCapacity);
        }

    }
