package ua.ithillel.hw13;

import ua.ithillel.hw13.entity.Bus;
import ua.ithillel.hw13.entity.Car;
import ua.ithillel.hw13.entity.Truck;
import ua.ithillel.hw13.entity.Vehicle;
import ua.ithillel.hw13.service.TaxiParkService;
import java.util.Arrays;

/*  Переделать Таксопарк. Реализовать метод по сортировке автомобилей по
    расходу топлива с помощью Arrays.sort, который принимает компаратор.
    Компаратор реализовать тремя способами: реализация интерфейса,
    лямбда-выражение и ссылка на метод.  */

public class Main {
    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[] {
                new Car("Volkswagen Golf", 34500, 7.8, 204, Car.Type.PASSENGER),
                new Car("Aston Martin Vanquish", 280000, 13.1, 324, Car.Type.SPORTS),
                new Car("Volvo XC60", 21900, 7.2, 220, Car.Type.OFF_ROAD),
                new Bus("Liaz 529000 \"Cruise\"", 375000, 31, 100, 48),
                new Bus("Scania (Higer) Touring", 400000, 30, 100, 49),
                new Truck("Mercedes-Benz Actros", 190000, 50, 162, 135000),
                new Truck("IVECO S-WAY", 100000, 30, 120, 90000)
        };
        TaxiParkService taxiParkService = new TaxiParkService(vehicles);
        taxiParkService.sortByFuelAscMethod();
        taxiParkService.sortByFuelAscLambda();
        taxiParkService.sortByFuelAscInterface();
        System.out.println(Arrays.toString(vehicles));
    }
}
