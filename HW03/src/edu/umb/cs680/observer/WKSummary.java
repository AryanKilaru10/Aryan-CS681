package edu.umb.cs680.observer;

public class WKSummary extends Summary{

    public WKSummary(double open, double close, double high, double low) {
        super(open, close, high, low);
    }

    @Override
    public double getOpen() {
        return super.getOpen();
    }

    @Override
    public double getLow() {
        return super.getLow();
    }

    @Override
    public double getHigh() {
        return super.getHigh();
    }

    @Override
    public double getClose() {
        return super.getClose();
    }

}
