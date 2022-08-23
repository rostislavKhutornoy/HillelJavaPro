package ua.ithillel.hw13.entity;

import java.util.Objects;

public class Car extends Vehicle {
    private String type;

    public static class Type {
        public static final String PASSENGER = "Passenger";
        public static final String SPORTS = "Sports";
        public static final String OFF_ROAD = "Off-road";
        public static final String SUV = "Crossover";
        public static final String COMMERCIAL = "Commercial";
    }

    public Car(String name, double cost, double fuelConsumption, double maxSpeed, String type) {
        super(name, cost, fuelConsumption, maxSpeed);
        if (Objects.equals(type, Type.PASSENGER) ||
                Objects.equals(type, Type.SPORTS) ||
                Objects.equals(type, Type.OFF_ROAD) ||
                Objects.equals(type, Type.SUV) ||
                Objects.equals(type, Type.COMMERCIAL)) {
            this.type = type;
        } else {
            this.type = "Unknown";
        }
    }

    @Override
    public String toString() {
        return "Car{" +
                "type='" + type + '\'' +
                ", name='" + super.getName() + '\'' +
                ", cost=" + super.getCost() +
                ", fuelConsumption=" + super.getFuelConsumption() +
                ", maxSpeed=" + super.getMaxSpeed() +
                '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
