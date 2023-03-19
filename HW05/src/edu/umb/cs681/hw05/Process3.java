package edu.umb.cs681.hw05;

import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Process3 extends Thread{
    private List<List<String>> csv;
    public Process3(List<List<String>> csv){
       this.csv = csv;
    }
    @Override
    public void run(){

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
    }
}
