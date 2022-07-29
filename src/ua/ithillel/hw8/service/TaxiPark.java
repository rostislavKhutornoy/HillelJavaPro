package ua.ithillel.hw8.service;

import ua.ithillel.hw8.domain.Vehicle;

public interface TaxiPark {
    double fleetCost();

    Vehicle[] sortByFuelConsumptionDescending();

    Vehicle[] sortByFuelConsumptionAscending();

    Vehicle[] findBySpeed(double minSpeed, double maxSpeed);
}
