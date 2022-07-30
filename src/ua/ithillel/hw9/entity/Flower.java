package ua.ithillel.hw9.entity;

import ua.ithillel.hw9.util.InputUtil;

public class Flower implements InputUtil {
    private String type;
    private double cost;
    private int daysOfLife;
    private double stemLength;

    public Flower() {
        this.type = type();
        this.cost = cost();
        this.daysOfLife = daysOfLife();
        this.stemLength = stemLength();
    }

    private String type() {
        String[] flowers = { "Rose", "Lily", "Iris",
                "Lilac", "Tulip", "Daisy" };
        System.out.println("\nAffordable flowers: ");
        for (int i = 0; i < flowers.length; i++) {
            System.out.println("\t[" + (i + 1) + "] " + flowers[i]);
        }
        while (true) {
            int choice = getPositiveInt("Enter -> ") - 1;
            if (choice < flowers.length) {
                return flowers[choice];
            } else {
                System.out.println("Incorrect input, try again.");
            }
        }
    }

    private double cost() {
        return getPositiveDouble("Cost: ");
    }

    private int daysOfLife() {
        return getPositiveInt("Freshness: ");
    }

    private double stemLength() {
        return getPositiveDouble("Stem length: ");
    }

    @Override
    public String toString() {
        return type + " [ " +
                "cost = " + cost +
                ", daysOfLife = " + daysOfLife +
                ", stemLength = " + stemLength +
                " ]";
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getDaysOfLife() {
        return daysOfLife;
    }

    public void setDaysOfLife(int daysOfLife) {
        this.daysOfLife = daysOfLife;
    }

    public double getStemLength() {
        return stemLength;
    }

    public void setStemLength(double stemLength) {
        this.stemLength = stemLength;
    }
}
