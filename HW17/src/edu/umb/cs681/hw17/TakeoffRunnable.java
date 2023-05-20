package edu.umb.cs681.hw17;

public class TakeoffRunnable implements java.lang.Runnable {
    private FlightLandingManager flightLandingManager;
    public TakeoffRunnable(FlightLandingManager flightLandingManager){
        this.flightLandingManager = flightLandingManager;
    }
    private volatile boolean done = false;
    public void setDone(){
        done = true;
    }
    @Override
    public void run() {
        for (int i = 0; i < 2; i++){
            if(done){
                System.out.println("Stopping takeoff");
                break;
            }
            flightLandingManager.Takeoff();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Interrupting");
            }
        }

    }
}
