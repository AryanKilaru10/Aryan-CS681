package edu.umb.cs681.hw14;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class AdmissionMonitor {
    private final ReentrantReadWriteLock lock;
    private final Condition admissionCondition;
    private int currentVisitors;

    public AdmissionMonitor() {
        this.lock = new ReentrantReadWriteLock();
        this.admissionCondition = lock.writeLock().newCondition();
        this.currentVisitors = 0;
    }

    public void enter() {
        lock.writeLock().lock();
        try {
            while (currentVisitors >= 10) {
                System.out.println("Too many visitors, please wait for a while!");
                this.admissionCondition.await();
            }
            currentVisitors++;
            System.out.println("capacity after enter: " + currentVisitors);
        } catch (InterruptedException e) {
            System.out.println(e.toString());
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void exit() {
        lock.writeLock().lock();
        try {
            currentVisitors--;
            System.out.println("capacity after exit " + currentVisitors);
            admissionCondition.signalAll();
        } finally {
            lock.writeLock().unlock();
        }
    }

    public int countCurrentVisitors() {
        lock.readLock().lock();
        try {
            return currentVisitors;
        } finally {
            lock.readLock().unlock();
        }
    }
    public static void main(String[] args){
        AdmissionMonitor admissionMonitor = new AdmissionMonitor();
         EntranceHandler entranceHandler = new EntranceHandler(admissionMonitor);
        EntranceHandler entranceHandler1 = new EntranceHandler(admissionMonitor);
        EntranceHandler entranceHandler2 = new EntranceHandler(admissionMonitor);
         ExitHandler exitHandler = new ExitHandler(admissionMonitor);
         Thread entranceThread = new Thread(entranceHandler);
         Thread entranceThread1 = new Thread(entranceHandler1);
         Thread exitThread = new Thread(exitHandler);
         entranceThread.start();
         entranceThread1.start();
         exitThread.start();
         try {
             Thread.sleep(19000);
         }
         catch (InterruptedException ex){
             System.out.println(ex.toString());
         }
         entranceHandler.setDone();
         entranceThread.interrupt();
         entranceHandler1.setDone();
         entranceThread1.interrupt();
         exitHandler.setDone();
         exitThread.interrupt();


    }
}
