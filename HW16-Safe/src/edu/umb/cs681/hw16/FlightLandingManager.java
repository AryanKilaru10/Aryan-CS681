package edu.umb.cs681.hw16;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class FlightLandingManager {
    private double CurrentCapacity = 0;
    private final ReentrantLock reentrantLock = new ReentrantLock();
    public void Takeoff(){
        reentrantLock.lock();
        try {
            CurrentCapacity++;
            System.out.println("Current capacity after takeoff: "+CurrentCapacity);
        }finally {
            reentrantLock.unlock();
        }


    }

    public void Land(){
        reentrantLock.lock();
        try {
            CurrentCapacity--;
            System.out.println("Current capacity after landing "+ CurrentCapacity);
        }finally {
            reentrantLock.unlock();
        }

        }

    }
