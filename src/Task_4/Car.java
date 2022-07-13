package Task_4;

public class Car {
    public String brand;
    public String model;
    public String color;
    public String registrationNumber;
    public double price;
    public int year;

    public Car(String brand, String model, int year, String color, double price, String registrationNumber) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.price = price;
        this.registrationNumber = registrationNumber;
    }
}
