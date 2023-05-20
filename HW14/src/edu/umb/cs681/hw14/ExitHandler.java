package edu.umb.cs681.hw14;

import java.util.concurrent.locks.ReentrantLock;

public class ExitHandler implements Runnable{
    private AdmissionMonitor monitor;
    public ExitHandler(AdmissionMonitor monitor){
        this.monitor = monitor;
    }
    private boolean done = false;
    private ReentrantLock lock = new ReentrantLock();
    public void setDone(){
        lock.lock();
        try {
            done = true;
        }finally {
            lock.unlock();
        }

    }
    @Override
    public void run() {
        for (int i = 0; i < 14; i++) {
            if (done) {
                System.out.println("Stopping exit");
                return;
            }
            monitor.exit();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
        }
    }
}
