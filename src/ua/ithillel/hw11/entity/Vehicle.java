package ua.ithillel.hw11.entity;

public abstract class Vehicle {
    private String name;
    private double cost;
    private double fuelConsumption;
    private double maxSpeed;

    public Vehicle(String name, double cost, double fuelConsumption, double maxSpeed) {
        this.name = name;
        this.cost = cost;
        this.fuelConsumption = fuelConsumption;
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                " USD, fuelConsumption=" + fuelConsumption +
                ", maxSpeed=" + maxSpeed +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}
