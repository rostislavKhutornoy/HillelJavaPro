package Task_4;

public class CarProcessor {
    public void getByBrand(Car[] cars, String brand) {
        for (Car car : cars) {
            if (brand == car.brand) {
                print(car);
            }
        }
    }

    public void getByOperating(Car[] cars, String model, int operation, int actualYear) {
        for (Car car : cars) {
            if (model == car.model && (actualYear - car.year) > operation) {
                print(car);
            }
        }
    }

    public void getByPrice(Car[] cars, int year, double price) {
        for (Car car : cars) {
            if (year == car.year && car.price > price) {
                print(car);
            }
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
