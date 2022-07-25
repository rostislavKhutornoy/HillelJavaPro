package Task_8;

public abstract class Vehicle {
    public String name;
    public double cost;
    public double fuelConsumption;
    public double maxSpeed;

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
}
