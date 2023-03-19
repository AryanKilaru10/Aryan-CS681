package edu.umb.cs681.hw05;

import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Process4 extends Thread{
    private List<List<String>> csv ;
    public Process4(List<List<String>> csv){
        this.csv = csv;
    }
    @Override
    public void run(){

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
