package edu.umb.cs681.hw17;

public class Main {
    public static void main(String[] args){
        FlightLandingManager flightLandingManager = new FlightLandingManager();
        TakeoffRunnable takeoffRunnable = new TakeoffRunnable(flightLandingManager);
        TakeoffRunnable takeoffRunnable2 = new TakeoffRunnable(flightLandingManager);
        LandingRunnable landingRunnable = new LandingRunnable(flightLandingManager);
        Thread t1 = new Thread(takeoffRunnable);
        Thread t2 = new Thread(landingRunnable);
        Thread t3 = new Thread(takeoffRunnable);
        t1.start();
        t2.start();
        t3.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        takeoffRunnable.setDone();
        landingRunnable.setDone();
        takeoffRunnable2.setDone();
        t1.interrupt();
        t2.interrupt();
        t3.interrupt();

    }
}
