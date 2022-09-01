package ua.ithillel.hw16.entity;

public class Truck extends Vehicle {
    private double loadCapacity;

    public Truck(String name, double cost, double fuelConsumption, double maxSpeed, double loadCapacity) {
        super(name, cost, fuelConsumption, maxSpeed);
        this.loadCapacity = loadCapacity;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "loadCapacity=" + loadCapacity +
                " kg, name='" + super.getName() + '\'' +
                ", cost=" + super.getCost() +
                ", fuelConsumption=" + super.getFuelConsumption() +
                ", maxSpeed=" + super.getMaxSpeed() +
                '}';
    }

    public double getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }
}
