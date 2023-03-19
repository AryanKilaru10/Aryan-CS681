
package edu.umb.cs681.hw02;
import java.util.ArrayList;
import java.util.List;
public class Car {
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

    public int denominationCount = 0;

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

        CarPriceResultHolder result = car_.stream()
                .map(Car::getPrice)
                .reduce(new CarPriceResultHolder(),
                        (res, price) -> {
                            res.setAverage(res.getAverage() + price);
                            res.setNumCarsExamined(res.getNumCarsExamined() + 1);
                            return res;
                        },
                        (res1, res2) -> {
                            res1.setAverage(res1.getAverage() + res2.getAverage());
                            res1.setNumCarsExamined(res1.getNumCarsExamined() + res2.getNumCarsExamined());
                            return res1;
                        });

        double averageCarPrice = result.getAverage() / (double) result.getNumCarsExamined();
        System.out.println(averageCarPrice);



    }
}
