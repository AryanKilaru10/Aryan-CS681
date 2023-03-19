package edu.umb.cs680.observer;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DJIAWKSummaryObservable extends Observable{
    private List<DSummary> ds = new LinkedList<DSummary>();

    public  void addSummary(DSummary dsummary) throws IOException {
        CandleStickObserver observer = new CandleStickObserver();

        if(ds.size()>=5) {
            ds.add(dsummary);
            WKSummary wk = new WKSummary(ds.get(0).getOpen(), ds.get(4).getClose(), ds.stream().map((DSummary d) -> d.getHigh()).max(Double::compare).get(), ds.stream().map((DSummary d) -> d.getHigh()).min(Double::compare).get());
            addObserver(observer);
            notifyObservers(wk);
            ds.clear();
        }
    }





}
