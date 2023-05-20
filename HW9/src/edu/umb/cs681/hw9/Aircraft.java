package edu.umb.cs681.hw9;

import java.util.concurrent.locks.ReentrantLock;

public class Aircraft {
    private Position position;
    private ReentrantLock l1 = new ReentrantLock();
    public Aircraft(Position position){
        this.position = position;
    }


    public void setPosition(double newLat, double newLong, double newAlt){
        l1.lock();
        try{
            this.position = this.position.change(newLat,newLong,newAlt);
        }
        finally {
            l1.unlock();
        }
    }

    public Position getPosition() {
        l1.lock();
        try {
            return position;
        }finally {
            l1.unlock();
        }
    }
}
