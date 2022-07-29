package ua.ithillel.hw8.domain;

public class Bus extends Vehicle{
    private int passengerCapacity;

    public Bus(String name, double cost, double fuelConsumption, double maxSpeed, int passengerCapacity) {
        super(name, cost, fuelConsumption, maxSpeed);
        this.passengerCapacity = passengerCapacity;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "passengerCapacity=" + passengerCapacity +
                ", name='" + super.getName() + '\'' +
                ", cost=" + super.getCost() +
                ", fuelConsumption=" + super.getFuelConsumption() +
                ", maxSpeed=" + super.getMaxSpeed() +
                '}';
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }
}
