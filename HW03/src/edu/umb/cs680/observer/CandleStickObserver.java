package edu.umb.cs680.observer;

public class CandleStickObserver implements Observer<WKSummary>{




    @Override
    public void update(Observable<WKSummary> sender, WKSummary event) {
        System.out.println(event.getHigh());
        System.out.println(event.getLow());
        System.out.println(event.getClose());
        System.out.println(event.getOpen());

    }
}
