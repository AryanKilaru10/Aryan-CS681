package edu.umb.cs681.hw05;

import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Process1 extends Thread {
    List<List<String>> csv;
    public Process1(List<List<String>> csv){
      this.csv = csv;
    }
    @Override
    public void run(){

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

        System.out.println("Highest House Price near to charles river is "+maxMedv);
        System.out.println("Lowest House Price near to charles river is "+minMedv);
        System.out.println("Average House price near to charles river is "+avgMedv.getAsDouble());
        System.out.println();

    }

}
