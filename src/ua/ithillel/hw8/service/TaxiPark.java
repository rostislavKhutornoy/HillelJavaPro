package ua.ithillel.hw8.service;

public interface TaxiPark {
    double fleetCost();

    Object[] sortByFuelConsumptionDescending();

    Object[] sortByFuelConsumptionAscending();

    Object[] findBySpeed(double minSpeed, double maxSpeed);
}
