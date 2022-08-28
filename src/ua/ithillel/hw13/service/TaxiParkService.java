package ua.ithillel.hw13.service;

import ua.ithillel.hw13.entity.Vehicle;

import java.util.ArrayList;
import java.util.Comparator;

public class TaxiParkService {
    private ArrayList<Vehicle> vehicles;

    public TaxiParkService(ArrayList<Vehicle> vehicles) {
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
        vehicles.sort(new Comparator<Vehicle>() {
            @Override
            public int compare(Vehicle o1, Vehicle o2) {
                return Double.compare(o1.getFuelConsumption(), o2.getFuelConsumption());
            }
        });
    }

    public void sortByFuelAscLambda() {
        vehicles.sort((o1, o2) -> (Double.compare(o1.getFuelConsumption(), o2.getFuelConsumption())));
    }

    public void sortByFuelAscMethod() {
        vehicles.sort(this::compareByFuel);
    }

    public ArrayList<Vehicle> findBySpeed(double minSpeed, double maxSpeed) {
        ArrayList<Vehicle> vehiclesSpeedSearch = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getMaxSpeed() >= minSpeed && vehicle.getMaxSpeed() <= maxSpeed) {
                vehiclesSpeedSearch.add(vehicle);
            }
        }
        return vehiclesSpeedSearch;
    }

    private int compareByFuel(Vehicle o1, Vehicle o2) {
        return Double.compare(o1.getFuelConsumption(), o2.getFuelConsumption());
    }

    @Override
    public String toString() {
        return vehicles.toString();
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}
