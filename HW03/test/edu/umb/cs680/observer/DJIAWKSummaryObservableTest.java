package edu.umb.cs680.observer;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class DJIAWKSummaryObservableTest extends Observable {
    public static List<List<String>> csv() {
        Path path = Paths.get("src/edu/umb/cs680/observer/HistoricalPrices.csv");
        List<List<String>> csv = null;
        try (Stream<String> lines = Files.lines(path)) {
            csv = lines.map(line -> {
                return Stream.of(line.split(",")).map(value -> value.substring(0)).collect(Collectors.toList());
            }).collect(Collectors.toList());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return csv;
    }

    @Test
    public void test(){
        List<List<String>> csv_ = csv();
        csv_.remove(0);
        System.out.println(csv_);
        CandleStickObserver candle = new CandleStickObserver();
        DJIAWKSummaryObservable obj = new DJIAWKSummaryObservable();
        List<DSummary> dsum = new LinkedList<DSummary>();
        for (List<String> t: csv_) {
            DSummary d = new DSummary(Double.parseDouble(t.get(0).replace("\"", "")), Double.parseDouble(t.get(3).replace("\"", "")), Double.parseDouble(t.get(1).replace("\"", "")), Double.parseDouble(t.get(2).replace("\"", "")));
            dsum.add(d);
        }
        WKSummary wk = new WKSummary(dsum.get(0).getOpen(),dsum.get(4).getClose() ,dsum.stream().map((DSummary d)-> d.getHigh()).max(Double::compare).get(), dsum.stream().map((DSummary d)-> d.getLow()).min(Double::compare).get());
        addObserver(candle);
        notifyObservers(wk);
        dsum.clear();


    }

}