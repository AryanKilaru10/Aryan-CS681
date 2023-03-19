package edu.umb.cs681.hw05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Path path = Paths.get("src/edu/umb/cs681/hw05/bos-housing.csv");
        List<List<String>> csv = null;
        try (Stream<String> lines = Files.lines(path)) {
            csv = lines.map(line -> {
                return Stream.of(line.split(",")).map(value -> value.substring(0)).collect(Collectors.toList());
            }).collect(Collectors.toList());
        } catch (IOException ex) {
        }
      csv.remove(0);
        Process1 p1 = new Process1(csv);
        Process2 p2 = new Process2(csv);
        Process3 p3 = new Process3(csv);
        Process4 p4 = new Process4(csv);
        p1.start();
        try {
            p1.join();
        }
        catch (Exception ex){

        }
        p2.start();
        try {
            p2.join();
        }
        catch (Exception ex){

        }
        p3.start();
        try {
            p3.join();
        }
        catch (Exception ex){

        }
        p4.start();
        try {
            p4.join();
        }
        catch (Exception ex){

        }




    }
}