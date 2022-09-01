package ua.ithillel.hw16.service;

import ua.ithillel.hw16.entity.Vehicle;

import java.util.List;
import java.util.stream.Collectors;

public class TaxiParkService {
    private List<Vehicle> vehicles;

    public TaxiParkService(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public double fleetCost() {
        return vehicles.stream()
                .map((Vehicle::getCost))
                .reduce(Double::sum).orElse(0d);
    }

    public void sortByFuelConsumption() {
        vehicles = vehicles.stream()
                .sorted(this::compareByFuel)
                .toList();
    }

    public List<Vehicle> findBySpeed(double minSpeed, double maxSpeed) {
        return vehicles.stream()
                .filter(vehicle -> vehicle.getMaxSpeed() >= minSpeed && vehicle.getMaxSpeed() <= maxSpeed)
                .toList();
    }

    private int compareByFuel(Vehicle o1, Vehicle o2) {
        return Double.compare(o1.getFuelConsumption(), o2.getFuelConsumption());
    }

    @Override
    public String toString() {
        return vehicles.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}
