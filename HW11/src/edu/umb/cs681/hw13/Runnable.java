package edu.umb.cs681.hw13;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

public class Runnable implements java.lang.Runnable {
        private static final Path[] files = {
                Paths.get("a.html"),
                Paths.get("b.html"),
                Paths.get("c.html")
        };

        private volatile boolean Done = false;

        private final AccessCounter accessCounter;
        private final Random random;

        public Runnable(AccessCounter accessCounter) {
            this.accessCounter = accessCounter;
            this.random = new Random();
        }
        public void setDone(){
            Done = true;
        }
    @Override
    public void run() {
        while (true) {
            if (Done) {
                System.out.println("Stopping the thread");
                break;
            }

            int randomIndex = random.nextInt(files.length);
            Path randomFile = files[randomIndex];
            accessCounter.increment(randomFile);
            int count = accessCounter.getCount(randomFile);
            System.out.println("File: " + randomFile + ", Count: " + count);

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Interrupting");
            }
        }
    }
    public static void main(String[] args){
            for (int i = 0; i < 5; i++){
            AccessCounter accessCounter = new AccessCounter();
            Runnable runnable1 = new Runnable(accessCounter);
            Thread thread = new Thread(runnable1);
            thread.start();
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException ex){
                System.out.println(ex.getLocalizedMessage());
            }
            runnable1.setDone();
            thread.interrupt();
            }



    }


}
