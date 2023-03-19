package edu.umb.cs680.observer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class getcsv {
    public List<List<String>> getCsv(){
        Path path = Paths.get("src/edu/umb/cs680/observer/HistoricalPrices.csv");
        List<List<String>> csv = null;
        try (Stream<String> lines = Files.lines(path)) {
            csv = lines.map(line -> {
                return Stream.of(line.split(",")).map(value -> value.substring(0)).collect(Collectors.toList());
            }).collect(Collectors.toList());
        } catch (IOException ex) {
        }
        return csv;
    }

}
