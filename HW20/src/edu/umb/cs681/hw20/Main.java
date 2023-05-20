package edu.umb.cs681.hw20;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static List<List<String>> getCSV(){
        Path path = Paths.get("src/edu/umb/cs681/hw20/bos-housing.csv");
        List<List<String>> csv = null;
        try (Stream<String> lines = Files.lines(path)) {
            csv = lines.map(line -> {
                return Stream.of(line.split(",")).map(value -> value.substring(0)).collect(Collectors.toList());
            }).collect(Collectors.toList());
        } catch (IOException ex) {
        }
        return csv;
    }
    public static void main(String args[]){
        List<List<String>> csv = getCSV();
        csv.remove(0);

        //----------------------------------------------------------------------------------------------------------------------------------------------------------
        // Solution to Question 1

        double maxMedv = csv.stream().parallel()
                .filter(row -> Double.parseDouble(row.get(3).replace("\"", "")) == 1) // Assuming chas is the fourth column (index 3)
                .mapToDouble(row -> Double.parseDouble(row.get(13))) // Assuming medv is the last column (index 13)
                .max()
                .orElse(0);

        OptionalDouble avgMedv = csv.stream().parallel()
                .filter(row -> Double.parseDouble(row.get(3).replace("\"", "")) == 1)
                .mapToDouble(row -> Double.parseDouble(row.get(13)))
                .average();

        OptionalDouble minMedv = csv.stream().parallel()
                .filter(row -> Double.parseDouble(row.get(3).replace("\"", "")) == 1) // Assuming chas is the fourth column (index 3)
                .mapToDouble(row -> Double.parseDouble(row.get(13))) // Assuming medv is the last column (index 13)
                .min();

        System.out.println("Hightest price of house near the charles river "+maxMedv);
        System.out.println("Lowest price of house near the charles river "+minMedv.getAsDouble());
        System.out.println("Average price of a house near the charles river "+avgMedv.getAsDouble());

        //Solution to Question 2
        Stream<List<String>> recordsStream = csv.stream().parallel();

        int numRecords = (int) Math.ceil(recordsStream.count() * 0.1);

        List<List<String>> sorted = csv.stream().parallel()
                .sorted(Comparator.comparingDouble(lst -> Double.parseDouble(lst.get(0))))
                .limit(numRecords)
                .collect(Collectors.toList());
        LinkedList<Double> nox_ = new LinkedList<Double>();
        sorted.stream().parallel().forEach((a)->{nox_.add(Double.parseDouble(a.get(4).replace("\"", "")));});
        double maxnox = nox_.stream().parallel().max(Double::compare).get();
        double minnox = nox_.stream().parallel().min(Double::compare).get();
        double avgnox = nox_.stream().parallel()
                .mapToDouble(Double::doubleValue)
                .average().getAsDouble();

        System.out.println("maximum nox among the top 10% areas among less crime rate areas "+maxnox);
        System.out.println("minimum nox among the top 10% areas among less crime rate areas "+minnox);
        System.out.println("Average nox among the top 10% areas among less crime rate areas "+avgnox);

        LinkedList<Double> medv_ = new LinkedList<Double>();
        sorted.stream().parallel().forEach((a)->{medv_.add(Double.parseDouble(a.get(13).replace("\"", "")));});
        double maxMedv_ = medv_.stream().parallel().max(Double::compare).get();
        double minMedv_ = medv_.stream().parallel().min(Double::compare).get();
        double avgMedv_ = medv_.stream().parallel()
                .mapToDouble(Double::doubleValue)
                .average().getAsDouble();
        System.out.println("maxprice of rooms aroung top 10% of less crime rate areas "+maxMedv_);
        System.out.println("minprice of rooms aroung top 10% of less crime rate areas "+minMedv_);
        System.out.println("AvgPrice of rooms among top 10% of less crime rate areas "+avgMedv_);

        LinkedList<Double> room = new LinkedList<Double>();
        sorted.stream().parallel().forEach((a)->{room.add(Double.parseDouble(a.get(5).replace("\"", "")));});
        double roomMax = room.stream().parallel().max(Double::compare).get();
        double roomMin = room.stream().parallel().min(Double::compare).get();
        double roomAvg = room.stream().parallel()
                .mapToDouble(Double::doubleValue)
                .average().getAsDouble();

        System.out.println("Max no of rooms in the area among top 10% of less crime rate areas "+roomMax);
        System.out.println("Min no of rooms in the area among top 10% of less crime rate areas "+roomMin);
        System.out.println("Avg no of rooms in the area among top 10% of less crime rate areas "+roomAvg);



        Stream<List<String>> recordStream = csv.stream().parallel();

        int num_of_Records = (int) Math.ceil(recordStream.count() * 0.1);

        List<List<String>> srtd = csv.stream().parallel()
                .sorted(Comparator.comparingDouble(lst -> Double.parseDouble(lst.get(10))))
                .limit(num_of_Records)
                .collect(Collectors.toList());
        LinkedList<Double> pt_nox = new LinkedList<Double>();
        srtd.stream().parallel().forEach((a)->{pt_nox.add(Double.parseDouble(a.get(4).replace("\"", "")));});
        double max_Pt_nox = pt_nox.stream().parallel().max(Double::compare).get();
        double min_Pt_nox = pt_nox.stream().parallel().min(Double::compare).get();
        double avg_Pt_nox = pt_nox.stream().parallel()
                .mapToDouble(Double::doubleValue)
                .average().getAsDouble();

        System.out.println("maximum nox among the top 10% areas among pt ratios "+max_Pt_nox);
        System.out.println("minimum nox among the top 10% areas among pt ratios "+min_Pt_nox);
        System.out.println("Average nox among the top 10% areas among pt ratios "+avg_Pt_nox);

        LinkedList<Double> pt_medv = new LinkedList<Double>();
        srtd.stream().parallel().forEach((a)->{pt_medv.add(Double.parseDouble(a.get(13).replace("\"", "")));});
        double max_pt_Medv = pt_medv.stream().parallel().max(Double::compare).get();
        double min_pt_Medv = pt_medv.stream().parallel().min(Double::compare).get();
        double avg_pt_Medv = pt_medv.stream().parallel()
                .mapToDouble(Double::doubleValue)
                .average().getAsDouble();
        System.out.println("maxprice of rooms aroung top 10% of pt ratios "+max_pt_Medv);
        System.out.println("minprice of rooms aroung top 10% of pt ratios "+min_pt_Medv);
        System.out.println("AvgPrice of rooms among top 10% of pt ratios "+avg_pt_Medv);

        LinkedList<Double> pt_room = new LinkedList<Double>();
        srtd.stream().parallel().forEach((a)->{pt_room.add(Double.parseDouble(a.get(5).replace("\"", "")));});
        double room_pt_Max = pt_room.stream().parallel().max(Double::compare).get();
        double room_pt_Min = pt_room.stream().parallel().min(Double::compare).get();
        double room_pt_Avg = pt_room.stream().parallel()
                .mapToDouble(Double::doubleValue)
                .average().getAsDouble();

        System.out.println("Max no of rooms in the area among top 10% of pt ratios "+room_pt_Max);
        System.out.println("Min no of rooms in the area among top 10% of pt ratios "+room_pt_Min);
        System.out.println("Avg no of rooms in the area among top 10% of pt ratios "+room_pt_Avg);

        //Solution to Question 3 - applying filters on our own





        List<List<String>> dis_srtd = csv.stream().parallel()
                .sorted(Comparator.comparingDouble(lst -> Double.parseDouble(lst.get(7))))
                .limit(num_of_Records)
                .collect(Collectors.toList());
        LinkedList<Double> dis_medv = new LinkedList<Double>();
        srtd.stream().parallel().forEach((a)->{dis_medv.add(Double.parseDouble(a.get(13).replace("\"", "")));});
        double max_dis_Medv = dis_medv.stream().parallel().max(Double::compare).get();
        double min_dis_Medv = dis_medv.stream().parallel().min(Double::compare).get();
        double avg_dis_Medv = dis_medv.stream().parallel()
                .mapToDouble(Double::doubleValue)
                .average().getAsDouble();
        System.out.println("max no of rooms around top 10% areas of nearest distance "+max_dis_Medv);
        System.out.println("min no of rooms around top 10% areas of nearest distance "+min_dis_Medv);
        System.out.println("Avg no of rooms around top 10% areas of nearest distance "+avg_dis_Medv);

        LinkedList<Double> dis_room = new LinkedList<Double>();
        srtd.stream().parallel().forEach((a)->{dis_room.add(Double.parseDouble(a.get(5).replace("\"", "")));});
        double room_dis_Max = dis_room.stream().parallel().max(Double::compare).get();
        double room_dis_Min = dis_room.stream().parallel().min(Double::compare).get();
        double room_dis_Avg = dis_room.stream().parallel()
                .mapToDouble(Double::doubleValue)
                .average().getAsDouble();

        System.out.println("Max no of rooms in the area among top 10% area with nearest distance "+room_dis_Max);
        System.out.println("Min no of rooms in the area among top 10% area with nearest distance "+room_dis_Min);
        System.out.println("Average no of rooms in the area among top 10% area with nearest distance "+room_dis_Avg);


        //Solution to Question 4 - applying filters on our own

        double max_Medv = csv.stream().parallel()
                .filter(row -> Double.parseDouble(row.get(3).replace("\"", "")) == 0) // Assuming chas is the fourth column (index 3)
                .mapToDouble(row -> Double.parseDouble(row.get(13))) // Assuming medv is the last column (index 13)
                .max()
                .orElse(0);

        OptionalDouble avg_Medv = csv.stream().parallel()
                .filter(row -> Double.parseDouble(row.get(3).replace("\"", "")) == 0)
                .mapToDouble(row -> Double.parseDouble(row.get(13)))
                .average();

        OptionalDouble min_Medv = csv.stream().parallel()
                .filter(row -> Double.parseDouble(row.get(3).replace("\"", "")) == 0) // Assuming chas is the fourth column (index 3)
                .mapToDouble(row -> Double.parseDouble(row.get(13))) // Assuming medv is the last column (index 13)
                .min();

        System.out.println("Hightest price of house far from the charles river "+max_Medv);
        System.out.println("Lowest price of house far from the charles river "+min_Medv.getAsDouble());
        System.out.println("Average price of a house far from the charles river "+avg_Medv.getAsDouble());


    }







}