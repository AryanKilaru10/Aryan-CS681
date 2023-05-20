package edu.umb.cs681.hw19;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class StockQuoteObservable extends Observable{
    private ReentrantLock lock = new ReentrantLock();
    Map<String, Double> map = new HashMap<>();
    public void changeQuote(String t, double q){
        lock.lock();
        try {
            map.put(t, q);
        }
        finally {
            lock.unlock();
        }

        notifyObservers(new StockEvent(t, q));
        System.out.println("Ticker: "+t);
        System.out.println("Quote: "+q);
    }
}
