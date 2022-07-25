package Task_8;

public class Bus extends Vehicle{
    public int passengerCapacity;

    public Bus(String name, double cost, double fuelConsumption, double maxSpeed, int passengerCapacity) {
        super(name, cost, fuelConsumption, maxSpeed);
        this.passengerCapacity = passengerCapacity;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "passengerCapacity=" + passengerCapacity +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", fuelConsumption=" + fuelConsumption +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}
