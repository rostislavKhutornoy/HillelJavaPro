package ua.ithillel.hw13.service;

import ua.ithillel.hw13.entity.Vehicle;
import java.util.Arrays;
import java.util.Comparator;

public class TaxiParkService {
    private Vehicle[] vehicles;

    public TaxiParkService(Vehicle[] vehicles) {
        this.vehicles = vehicles;
    }

    public double fleetCost() {
        double totalCost = 0;
        for (Vehicle vehicle : vehicles) {
            totalCost += vehicle.getCost();
        }
        return totalCost;
    }

    public void sortByFuelAscInterface() {
        Arrays.sort(vehicles, new Comparator<Vehicle>() {
            @Override
            public int compare(Vehicle o1, Vehicle o2) {
                return Double.compare(o1.getFuelConsumption(), o2.getFuelConsumption());
            }
        });
    }

    public void sortByFuelAscLambda() {
        Arrays.sort(vehicles, (o1, o2) -> (Double.compare(o1.getFuelConsumption(), o2.getFuelConsumption())));
    }

    public void sortByFuelAscMethod() {
        Arrays.sort(vehicles, TaxiParkService::compareByFuel);
    }

    public Vehicle[] findBySpeed(double minSpeed, double maxSpeed) {
        Vehicle[] vehiclesSpeedSearch = new Vehicle[] {};
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getMaxSpeed() >= minSpeed && vehicle.getMaxSpeed() <= maxSpeed) {
                vehiclesSpeedSearch = push(vehicle, vehiclesSpeedSearch);
            }
        }
        return  vehiclesSpeedSearch;
    }

    private Vehicle[] push(Vehicle vehicle, Vehicle[] vehicles) {
        Vehicle[] newArray = new Vehicle[vehicles.length + 1];
        copyArray(newArray, vehicles);
        newArray[newArray.length - 1] = vehicle;
        return newArray;
    }

    private void copyArray(Vehicle[] newArray, Vehicle[] oldArray) {
        if (newArray.length >= oldArray.length) {
            for (int i = 0; i < oldArray.length; i++) {
                newArray[i] = oldArray[i];
            }
        }
    }

    private static int compareByFuel(Vehicle o1, Vehicle o2) {
        if (o1.getFuelConsumption() < o2.getFuelConsumption()) {
            return -1;
        } else if (o1.getFuelConsumption() == o2.getFuelConsumption()) {
            return 0;
        } else {
            return 1;
        }
    }

    public Vehicle[] getVehicles() {
        return vehicles;
    }

    public void setVehicles(Vehicle[] vehicles) {
        this.vehicles = vehicles;
    }
}
