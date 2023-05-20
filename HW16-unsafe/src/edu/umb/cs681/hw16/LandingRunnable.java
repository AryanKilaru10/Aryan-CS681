package edu.umb.cs681.hw16;

public class LandingRunnable implements Runnable{
    private FlightLandingManager flightLandingManager;
    public LandingRunnable(FlightLandingManager flightLandingManager){
        this.flightLandingManager = flightLandingManager;
    }
    private volatile boolean done = false;
    public void setDone(){
        done = true;
    }
    @Override
    public void run() {
        for (int i = 0; i < 3; i++){
            if(done){
                System.out.println("Stopping Landing");
                break;
            }
            flightLandingManager.Land();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Interrupting");
            }
        }
    }
}
