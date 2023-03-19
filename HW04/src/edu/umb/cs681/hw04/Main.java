package edu.umb.cs681.hw04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Path path = Paths.get("src/edu/umb/cs681/hw04/bos-housing.csv");
        List<List<String>> csv = null;
        try (Stream<String> lines = Files.lines(path)) {
            csv = lines.map(line -> {
                return Stream.of(line.split(",")).map(value -> value.substring(0)).collect(Collectors.toList());
            }).collect(Collectors.toList());
        } catch (IOException ex) {
        }
      csv.remove(0);

        List<Double> medvList = csv.stream()
                .filter(row -> row.get(3).equals("\"1\"")) // Assuming chas is the fourth column (index 3)
                .map(row -> Double.parseDouble(row.get(13))) // Assuming medv is the last column (index 13)
                .collect(Collectors.toList());

        double maxMedv = medvList.stream().mapToDouble(Double::doubleValue).max().orElse(0);
        double minMedv = medvList.stream().mapToDouble(Double::doubleValue).min().orElse(0);
        OptionalDouble avgMedv = csv.stream()
                .filter(row -> row.get(3).equals("\"1\"")) // Assuming chas is the fourth column (index 3)
                .mapToDouble(row -> Double.parseDouble(row.get(13))) // Assuming medv is the last column (index 13)
                .average();
        System.out.println("Question - 1");
        System.out.println("Highest House Price near to charles river is "+maxMedv);
        System.out.println("Lowest House Price near to charles river is "+minMedv);
        System.out.println("Average House price near to charles river is "+avgMedv.getAsDouble());
        System.out.println();

        // Solution to Question - 2

        System.out.println("Question - 2");
        List<List<String>> sorted = csv.stream()
                .sorted(Comparator.comparingDouble(lst -> Double.parseDouble(lst.get(0))))
                .limit((int) Math.ceil(csv.size() * 0.1))
                .collect(Collectors.toList());
        double min = sorted.stream().map(row -> Double.parseDouble(row.get(4))).min(Double::compare).get();
        double max = sorted.stream().map(row -> Double.parseDouble(row.get(4))).max(Double::compare).get();
        OptionalDouble avg = sorted.stream()
                .mapToDouble(row -> Double.parseDouble(row.get(4))) // Assuming medv is the last column (index 13)
                .average();
        System.out.println("After sorting top 10% Crim rate");
        System.out.println("Max Nox: "+max);
        System.out.println("Min Nox "+min);
        System.out.println("Average Nox "+avg.getAsDouble());

        double min_ = sorted.stream().map(row -> Double.parseDouble(row.get(5))).min(Double::compare).get();
        double max_ = sorted.stream().map(row -> Double.parseDouble(row.get(5))).max(Double::compare).get();
        OptionalDouble avg_ = sorted.stream()
                .mapToDouble(row -> Double.parseDouble(row.get(5))) // Assuming medv is the last column (index 13)
                .average();
        System.out.println("Max RM: "+max_);
        System.out.println("Min RM "+min_);
        System.out.println("Average RM "+avg_.getAsDouble());

        double min__ = sorted.stream().map(row -> Double.parseDouble(row.get(13))).min(Double::compare).get();
        double max__ = sorted.stream().map(row -> Double.parseDouble(row.get(13))).max(Double::compare).get();
        OptionalDouble avg__ = sorted.stream()
                .mapToDouble(row -> Double.parseDouble(row.get(13))) // Assuming medv is the last column (index 13)
                .average();
        System.out.println("Max Price "+max__);
        System.out.println("Min Price "+min__);
        System.out.println("Average Price "+avg__.getAsDouble());
        List<List<String>> sorted_ = csv.stream()
                .sorted(Comparator.comparingDouble(lst -> Double.parseDouble(lst.get(10))))
                .limit((int) Math.ceil(csv.size() * 0.1))
                .collect(Collectors.toList());

        double min_p = sorted_.stream().map(row -> Double.parseDouble(row.get(4))).min(Double::compare).get();
        double max_p = sorted_.stream().map(row -> Double.parseDouble(row.get(4))).max(Double::compare).get();
        OptionalDouble avg_p = sorted_.stream()
                .mapToDouble(row -> Double.parseDouble(row.get(4))) // Assuming medv is the last column (index 13)
                .average();
        System.out.println("After sorting top 10% PTRatio");
        System.out.println("Max Nox: "+max_p);
        System.out.println("Min Nox "+min_p);
        System.out.println("Average Nox "+avg_p.getAsDouble());
        double min_p_ = sorted_.stream().map(row -> Double.parseDouble(row.get(5))).min(Double::compare).get();
        double max_p_ = sorted_.stream().map(row -> Double.parseDouble(row.get(5))).max(Double::compare).get();
        OptionalDouble avg_p_ = sorted_.stream()
                .mapToDouble(row -> Double.parseDouble(row.get(5))) // Assuming medv is the last column (index 13)
                .average();
        System.out.println("Max RM: "+max_p_);
        System.out.println("Min RM "+min_p_);
        System.out.println("Average RM "+avg_p_.getAsDouble());
        double min_p__ = sorted_.stream().map(row -> Double.parseDouble(row.get(13))).min(Double::compare).get();
        double max_p__ = sorted_.stream().map(row -> Double.parseDouble(row.get(13))).max(Double::compare).get();
        OptionalDouble avg_p__ = sorted_.stream()
                .mapToDouble(row -> Double.parseDouble(row.get(13))) // Assuming medv is the last column (index 13)
                .average();
        System.out.println("Max Price : "+max_p__);
        System.out.println("Min Price  "+min_p__);
        System.out.println("Average Price  "+avg_p__.getAsDouble());
        System.out.println("Question 3");

        //Question - 3


      List<List<String>> age_sorted = csv.stream()
              .sorted(Comparator.comparingDouble(lst -> Double.parseDouble(lst.get(6))))
              .limit((int) Math.ceil(csv.size() * 0.1))
              .collect(Collectors.toList());

      double min_age_p = age_sorted.stream().map(row -> Double.parseDouble(row.get(4))).min(Double::compare).get();
      double max_age_p = age_sorted.stream().map(row -> Double.parseDouble(row.get(4))).max(Double::compare).get();
      OptionalDouble avg_age_p = age_sorted.stream()
              .mapToDouble(row -> Double.parseDouble(row.get(4)))
              .average();
      System.out.println("After sorting top 10% Age");
      System.out.println("Max Nox: "+max_age_p);
      System.out.println("Min Nox "+min_age_p);
      System.out.println("Average Nox "+avg_age_p.getAsDouble());
      double min_rm_p = age_sorted.stream().map(row -> Double.parseDouble(row.get(5))).min(Double::compare).get();
      double max_rm_p = age_sorted.stream().map(row -> Double.parseDouble(row.get(5))).max(Double::compare).get();
      OptionalDouble avg_rm_p = age_sorted.stream()
              .mapToDouble(row -> Double.parseDouble(row.get(5)))
              .average();
      System.out.println("Max RM: "+max_rm_p);
      System.out.println("Min RM "+min_rm_p);
      System.out.println("Average RM "+avg_rm_p.getAsDouble());
      double min_price = age_sorted.stream().map(row -> Double.parseDouble(row.get(13))).min(Double::compare).get();
      double max_price = age_sorted.stream().map(row -> Double.parseDouble(row.get(13))).max(Double::compare).get();
      OptionalDouble avg_price = age_sorted.stream()
              .mapToDouble(row -> Double.parseDouble(row.get(13))) // Assuming medv is the last column (index 13)
              .average();
      System.out.println("Max Price : "+max_price);
      System.out.println("Min Price  "+min_price);
      System.out.println("Average Price  "+avg_price.getAsDouble());
      System.out.println("Question 4");

      // Solution - 4

      List<List<String>> tax_sorted = csv.stream()
              .sorted(Comparator.comparingDouble(lst -> Double.parseDouble(lst.get(9))))
              .limit((int) Math.ceil(csv.size() * 0.1))
              .collect(Collectors.toList());

      double min_tx_p = tax_sorted.stream().map(row -> Double.parseDouble(row.get(4))).min(Double::compare).get();
      double max_tx_p = tax_sorted.stream().map(row -> Double.parseDouble(row.get(4))).max(Double::compare).get();
      OptionalDouble avg_tx_p = tax_sorted.stream()
              .mapToDouble(row -> Double.parseDouble(row.get(4))) // Assuming medv is the last column (index 13)
              .average();
      System.out.println("After sorting top 10% Tax");
      System.out.println("Max Nox: "+max_tx_p);
      System.out.println("Min Nox "+min_tx_p);
      System.out.println("Average Nox "+avg_tx_p.getAsDouble());
      double min_tx_rm = tax_sorted.stream().map(row -> Double.parseDouble(row.get(5))).min(Double::compare).get();
      double max_tx_rm = tax_sorted.stream().map(row -> Double.parseDouble(row.get(5))).max(Double::compare).get();
      OptionalDouble avg_tx_rm = tax_sorted.stream()
              .mapToDouble(row -> Double.parseDouble(row.get(5))) // Assuming medv is the last column (index 13)
              .average();
      System.out.println("Max RM: "+max_tx_rm);
      System.out.println("Min RM "+min_tx_rm);
      System.out.println("Average RM "+avg_tx_rm.getAsDouble());
      double min_tx_price = tax_sorted.stream().map(row -> Double.parseDouble(row.get(13))).min(Double::compare).get();
      double max_tx_price = tax_sorted.stream().map(row -> Double.parseDouble(row.get(13))).max(Double::compare).get();
      OptionalDouble avg_tx_price = tax_sorted.stream()
              .mapToDouble(row -> Double.parseDouble(row.get(13))) // Assuming medv is the last column (index 13)
              .average();
      System.out.println("Max Price : "+max_tx_price);
      System.out.println("Min Price  "+min_tx_price);
      System.out.println("Average Price  "+avg_tx_price.getAsDouble());

    }
}