package edu.umb.cs680.observer;

public class DSummary extends Summary{
    public DSummary(double open, double close, double high, double low) {
        super(open, close, high, low);
    }

    @Override
    public double getClose() {
        return super.getClose();
    }

    @Override
    public double getHigh() {
        return super.getHigh();
    }

    @Override
    public double getLow() {
        return super.getLow();
    }

    @Override
    public double getOpen() {
        return super.getOpen();
    }
}
