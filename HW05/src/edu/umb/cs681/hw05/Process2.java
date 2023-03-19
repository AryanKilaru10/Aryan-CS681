package edu.umb.cs681.hw05;

import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Process2 extends Thread{
    private List<List<String>> csv;
    public Process2(List<List<String>> csv){
        this.csv = csv;
    }
    @Override
    public void run(){
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
    }
}
