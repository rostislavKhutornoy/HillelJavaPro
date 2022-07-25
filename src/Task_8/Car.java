package Task_8;

import java.util.Objects;

public class Car extends Vehicle{
    String type;

    static class Type {
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
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", fuelConsumption=" + fuelConsumption +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}
