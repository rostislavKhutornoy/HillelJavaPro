package ua.ithillel.hw16;

import ua.ithillel.hw16.entity.Bus;
import ua.ithillel.hw16.entity.Car;
import ua.ithillel.hw16.entity.Truck;
import ua.ithillel.hw16.entity.Vehicle;
import ua.ithillel.hw16.service.TaxiParkService;

import java.util.ArrayList;
import java.util.Arrays;

/* Переделать методы таксопарка на использование потоков данных */

public class Main {
    public static void main(String[] args) {
        Vehicle[] vehiclesArray = new Vehicle[] {
                new Car("Volkswagen Golf", 34500, 7.8, 204, Car.Type.PASSENGER),
                new Car("Aston Martin Vanquish", 280000, 13.1, 324, Car.Type.SPORTS),
                new Car("Volvo XC60", 21900, 7.2, 220, Car.Type.OFF_ROAD),
                new Bus("Liaz 529000 \"Cruise\"", 375000, 31, 100, 48),
                new Bus("Scania (Higer) Touring", 400000, 30, 100, 49),
                new Truck("Mercedes-Benz Actros", 190000, 50, 162, 135000),
                new Truck("IVECO S-WAY", 100000, 30, 120, 90000)
        };
        ArrayList<Vehicle> vehiclesList = new ArrayList<>(Arrays.asList(vehiclesArray));
        TaxiParkService taxiParkService = new TaxiParkService(vehiclesList);
        taxiParkService.sortByFuelConsumption();
        System.out.println(taxiParkService.fleetCost());
        System.out.println(taxiParkService.findBySpeed(200, 500));
        System.out.println(taxiParkService);
    }
}
