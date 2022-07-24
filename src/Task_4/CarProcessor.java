package Task_4;

import java.util.Objects;

public class CarProcessor {
    Car[] cars;

    public CarProcessor() {
        this.cars = new Car[] {};
    }
    public CarProcessor(Car[] cars) {
        this.cars = cars;
    }

    public void getByBrand(Car[] cars, String brand) {
        for (Car car : cars) {
            if (Objects.equals(brand, car.brand)) {
                print(car);
            }
        }
    }

    public void getByBrand(String brand) {
        if (cars.length != 0) {
            getByBrand(cars, brand);
        }
    }

    public void getByOperating(Car[] cars, String model, int operation, int actualYear) {
        for (Car car : cars) {
            if (Objects.equals(model, car.model) && (actualYear - car.year) > operation) {
                print(car);
            }
        }
    }

    public void getByOperating(String model, int operation, int actualYear) {
        if (cars.length != 0) {
            getByOperating(cars, model, operation, actualYear);
        }
    }

    public void getByPrice(Car[] cars, int year, double price) {
        for (Car car : cars) {
            if (year == car.year && car.price > price) {
                print(car);
            }
        }
    }

    public void getByPrice(int year, double price) {
        if (cars.length != 0) {
            getByPrice(cars, year, price);
        }
    }

    public void print(Car car) {
        System.out.println("Car = { Brand: " + car.brand +
                ", Model: " + car.model +
                ", Year: " + car.year +
                ", Color: " + car.color +
                ", Price: " + car.price +
                ", Registration Number: " + car.registrationNumber + " }");
    }
}
