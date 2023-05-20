package edu.umb.cs681.hw17;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class FlightLandingManager {
    private double CurrentCapacity = 0;
    private ReentrantLock reentrantLock = new ReentrantLock();
    private final Condition unloadCondition = reentrantLock.newCondition();
    public void Takeoff(){
        reentrantLock.lock();
        try {
            CurrentCapacity++;
            System.out.println("Current capacity after takeoff: "+CurrentCapacity);
            unloadCondition.signalAll();
        }finally {
            reentrantLock.unlock();
        }

    }

    public void Land(){
        reentrantLock.lock();
        try {
            while (CurrentCapacity < 2){
                System.out.println("Cannot Land as runway is not free");
                try {
                    System.out.println("Await()");
                    unloadCondition.await();
                }catch (InterruptedException e){}
            }
            CurrentCapacity--;
            System.out.println("Current capacity after landing "+ CurrentCapacity);
        }finally {
            reentrantLock.unlock();
        }

    }

}