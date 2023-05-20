package edu.umb.cs681.hw19;

public class Runnable implements java.lang.Runnable {
    @Override
    public void run() {
        Observer<StockEvent> obs1 = (newStockSender, Event)->{
            System.out.println("obs1");
        };
        Observer<StockEvent> obs2 = (newStockSender, Event)->{
            System.out.println("obs2");
        };
        Observer<StockEvent> obs3 = (newStockSender, Event)->{
            System.out.println("obs3");
        };
        StockQuoteObservable observable = new StockQuoteObservable();
        observable.addObserver(obs1);
        observable.addObserver(obs2);
        observable.addObserver(obs3);

        observable.changeQuote("Ticker1", 62.0);

    }
    public static void main(String[] args){
        for(int i = 0; i < 5; i++){
            new Thread(new Runnable()).start();
        }
    }
}
