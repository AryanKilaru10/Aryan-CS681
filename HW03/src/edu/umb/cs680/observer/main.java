package edu.umb.cs680.observer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class main {
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
    public static void main(String[] args) throws IOException {
        DJIAWKSummaryObservable dj = new DJIAWKSummaryObservable();
        List<List<String>> csv_ = csv();
        csv_.remove(0);
        for (List<String> t: csv_) {
            DSummary d = new DSummary(Double.parseDouble(t.get(0).replace("\"", "")), Double.parseDouble(t.get(3).replace("\"", "")), Double.parseDouble(t.get(1).replace("\"", "")), Double.parseDouble(t.get(2).replace("\"", "")));
            dj.addSummary(d);

        }

    }
}
