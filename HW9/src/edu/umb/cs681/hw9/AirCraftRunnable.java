package edu.umb.cs681.hw9;

public class AirCraftRunnable implements Runnable {
    @Override
    public void run() {
        Position position = new Position(190.9, 837.23, 236.2);
        Aircraft aircraft = new Aircraft(position);
        System.out.println(aircraft.getPosition());
        aircraft.setPosition(32.2, 233.32, 232.43);
        System.out.println(aircraft.getPosition());
    }

    public static void main(String[] args) {
        for (int z = 0; z < 13; z++) {
            AirCraftRunnable airCraftRunnable = new AirCraftRunnable();
            Thread thread = new Thread(airCraftRunnable);
            thread.start();
        }
    }
}