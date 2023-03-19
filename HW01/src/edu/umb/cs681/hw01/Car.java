
package edu.umb.cs681.hw01;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Car {
    private int denominationCount ;
    private String make, model;
    private int mileage, year;
    private float price;


    public Car(String make, String model, int price, int mileage, int year) {
        this.make = make;
        this.model = model;
        this.price = price;
        this.mileage = mileage;
        this.year = year;
    }

    public String getMake() {
        return this.make;
    }

    public String getModel() {
        return this.model;
    }

    public int getMileage() {
        return this.mileage;
    }

    public int getYear() {
        return this.year;
    }

    public float getPrice() {
        return this.price;
    }


    public void setDomination(List<Car> car) {
        int x = 0;
        for (Car c : car) {
            if ((c.getPrice() >= this.getPrice()) && (c.getMileage() >= this.getMileage()) && (c.getYear() <= this.getYear())) {
                x++;
            }
        }
        this.denominationCount = x;
    }

    public int getDenominationCount() {
        return denominationCount;
    }
    public static void main(String[] args){
        Car ca1 = new Car("Bentley","Bacalar",67823,23,2067);
        Car ca2 = new Car("Hispano","SuizaCarmen",68373,27,2056);
        Car ca3 = new Car("Vayanne","Deus",69452,31,2043);
        Car ca4 = new Car("SSC","Tuatara",72134,45,2022);
        Car ca5 = new Car("Emira","Eletre",75313,53,2017);
        Car ca6 = new Car("Vulcan","Aston",78111,67,2016);
        Car ca7 = new Car("Delage","D12",79453,69,2012);
        Car ca8 = new Car("McLaren","Speedtail",81315,71,2005);
        List<Car> car_ = new ArrayList<Car>();
        car_.add(ca1);
        car_.add(ca2);
        car_.add(ca3);
        car_.add(ca4);
        car_.add(ca5);
        car_.add(ca6);
        car_.add(ca7);
        car_.add(ca8);

     System.out.println("-Price-");
     double MinInLowList = car_.stream().filter(car -> car.getPrice() < 72134).collect(Collectors.toList()).stream().map((Car::getPrice)).min(Double::compare).get();
     System.out.println("Latest car in Low List is Manufactured in the year "+MinInLowList);
     double MaxInLowList = car_.stream().filter(car -> car.getPrice() < 72134).collect(Collectors.toList()).stream().map((Car::getYear)).max(Double::compare).get();
     System.out.println("Oldest car in Low List is Manufactured in the year "+MaxInLowList);
     double MinInHighList = car_.stream().filter(car -> car.getPrice() >= 72134).collect(Collectors.toList()).stream().map((Car::getYear)).min(Double::compare).get();
     System.out.println("Latest car in High List is Manufactured in the year "+MinInHighList);
     double MaxInHighList = car_.stream().filter(car -> car.getPrice() >= 72134).collect(Collectors.toList()).stream().map((Car::getYear)).min(Double::compare).get();
     System.out.println("Oldest car in High List is Manufactured in the year "+MaxInHighList);
     System.out.println();
     System.out.println();
     System.out.println("-Mileage-");
     double MinInLowListMileage = car_.stream().filter(car -> car.getMileage() < 53).collect(Collectors.toList()).stream().map((Car::getPrice)).min(Double::compare).get();
     System.out.println("Cheapest car in the Low List(Mileage) "+MinInLowListMileage);
     double MaxInLowListMileage = car_.stream().filter(car -> car.getMileage() < 53).collect(Collectors.toList()).stream().map((Car::getPrice)).max(Double::compare).get();
     System.out.println("Expensive car in Low List(Mileage) "+MaxInLowListMileage);
     double MinInHighListMileage = car_.stream().filter(car -> car.getMileage() >= 53).collect(Collectors.toList()).stream().map((Car::getPrice)).min(Double::compare).get();
     System.out.println("Cheapest car in High List(Mileage) "+MinInHighListMileage);
     double MaxInHighListMileage = car_.stream().filter(car -> car.getMileage() >= 53).collect(Collectors.toList()).stream().map((Car::getPrice)).max(Double::compare).get();
     System.out.println("Expensive car in High List(Mileage) "+MaxInHighListMileage);
     System.out.println();
     System.out.println();
        System.out.println("-Domination Count-");
        for(Car c: car_){
            c.setDomination(car_);
        }
        double MinInLowListDom = car_.stream().filter(car -> car.getDenominationCount() < 2).collect(Collectors.toList()).stream().map((Car::getDenominationCount)).min(Double::compare).get();
        System.out.println("Car with smallest Domination Count in Low List "+MinInLowListDom);
        double MaxInLowListDom = car_.stream().filter(car -> car.getDenominationCount() < 4).collect(Collectors.toList()).stream().map((Car::getDenominationCount)).max(Double::compare).get();
        System.out.println("Car with Largest Domination Count in Low List "+MaxInLowListDom);
        double MinInHighListDom = car_.stream().filter(car -> car.getDenominationCount() >= 4).collect(Collectors.toList()).stream().map((Car::getDenominationCount)).min(Double::compare).get();
        System.out.println("Car with Lowest Domination Count in High List "+MinInHighListDom);
        double MaxInHighListDom = car_.stream().filter(car -> car.getDenominationCount() >= 4).collect(Collectors.toList()).stream().map((Car::getDenominationCount)).max(Double::compare).get();
        System.out.println("Car with Highest Domination Count in High List "+MaxInHighListDom);
        System.out.println();
        System.out.println();

        System.out.println("-Year-");
        double MinInLowListYear_ = car_.stream().filter(car -> car.getYear() < 2017).collect(Collectors.toList()).stream().map((Car::getYear)).min(Double::compare).get();
        System.out.println("Oldest car in Low List "+MinInLowListYear_);
        double MaxInLowListYear_ = car_.stream().filter(car -> car.getYear() < 2017).collect(Collectors.toList()).stream().map((Car::getYear)).max(Double::compare).get();
        System.out.println("Latest car in Low List "+MaxInLowListYear_);
        double MinInHighListYear_ = car_.stream().filter(car -> car.getYear() >= 2017).collect(Collectors.toList()).stream().map((Car::getYear)).min(Double::compare).get();
        System.out.println("Oldest car in High List "+MinInHighListYear_);
        double MaxInHighListYear_ = car_.stream().filter(car -> car.getYear() >= 2017).collect(Collectors.toList()).stream().map((Car::getYear)).max(Double::compare).get();
        System.out.println("Latest car in High List "+MaxInHighListYear_);
        System.out.println();
        System.out.println();











    }
}
