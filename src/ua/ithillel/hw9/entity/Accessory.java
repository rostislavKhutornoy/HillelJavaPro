package ua.ithillel.hw9.entity;

import ua.ithillel.hw9.util.InputUtil;

public class Accessory implements InputUtil {
    private String name;
    private double cost;

    public Accessory() {
        this.name = name();
        this.cost = cost();
    }

    private String name() {
        return getString("\nAccessory name: ");
    }

    private double cost() {
        return getPositiveDouble("Cost: ");
    }

    @Override
    public String toString() {
        return name + " [ cost = " + cost + " ]";
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
}
