package Task_8;

public class Truck extends Vehicle{
    public double loadCapacity;

    public Truck(String name, double cost, double fuelConsumption, double maxSpeed, double loadCapacity) {
        super(name, cost, fuelConsumption, maxSpeed);
        this.loadCapacity = loadCapacity;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "loadCapacity=" + loadCapacity +
                " kg, name='" + name + '\'' +
                ", cost=" + cost +
                ", fuelConsumption=" + fuelConsumption +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}
