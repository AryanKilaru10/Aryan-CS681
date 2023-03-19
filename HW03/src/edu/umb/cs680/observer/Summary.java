package edu.umb.cs680.observer;

public class Summary {
    private double open;
    private double close;
    private double high;
    private double low;
    public Summary(double open, double close, double high, double low){
        this.open = open;
        this.close = close;
        this.high = high;
        this.low = low;
    }

    public double getClose() {
        return close;
    }

    public double getHigh() {
        return high;
    }

    public double getLow() {
        return low;
    }

    public double getOpen() {
        return open;
    }
}
