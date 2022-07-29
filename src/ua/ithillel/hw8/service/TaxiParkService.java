package ua.ithillel.hw8.service;

import ua.ithillel.hw8.domain.Vehicle;

public class TaxiParkService implements TaxiPark{
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

    public Vehicle[] sortByFuelConsumptionDescending() {
        Vehicle[] newArray = new Vehicle[vehicles.length];
        copyArray(newArray, vehicles);
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < newArray.length - 1; i++) {
                if (newArray[i].getFuelConsumption() < newArray[i + 1].getFuelConsumption()) {
                    isSorted = false;
                    Vehicle temp = newArray[i];
                    newArray[i] = newArray[i + 1];
                    newArray[i + 1] = temp;
                }
            }
        }
        return newArray;
    }

    public Vehicle[] sortByFuelConsumptionAscending() {
        Vehicle[] newArray = new Vehicle[vehicles.length];
        copyArray(newArray, vehicles);
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < newArray.length - 1; i++) {
                if (newArray[i].getFuelConsumption() > newArray[i + 1].getFuelConsumption()) {
                    isSorted = false;
                    Vehicle temp = newArray[i];
                    newArray[i] = newArray[i + 1];
                    newArray[i + 1] = temp;
                }
            }
        }
        return newArray;
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

    public Vehicle[] getVehicles() {
        return vehicles;
    }

    public void setVehicles(Vehicle[] vehicles) {
        this.vehicles = vehicles;
    }
}
