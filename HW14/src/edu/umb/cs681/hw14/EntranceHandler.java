package edu.umb.cs681.hw14;

public class EntranceHandler implements Runnable {
    private AdmissionMonitor monitor;
    private volatile boolean done = false;

    public void setDone() {
        done = true;
    }

    public EntranceHandler(AdmissionMonitor monitor) {
        this.monitor = monitor;
    }

    @Override
    public void run() {
        for (int i = 0; i < 16; i++) {
            if (done) {
                System.out.println("Stopping entrance");
                return;
            }
            monitor.enter();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
        }
    }
}
