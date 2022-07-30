package ua.ithillel.hw9.entity;

import ua.ithillel.hw9.util.ArraysUtil;
import ua.ithillel.hw9.util.InputUtil;

public class Bouquet implements InputUtil {
    private Flower[] flowers;
    private Accessory[] accessories;

    public Bouquet() {
        this.flowers = new Flower[0];
        this.accessories = new Accessory[0];
    }

    public void addFlower() {
        flowers = ArraysUtil.extendFlowersArray(flowers, new Flower());
    }

    public void addAccessory() {
        accessories = ArraysUtil.extendAccessoryArray(accessories, new Accessory());
    }

    public double price() {
        double price = 0;
        for (Flower flower : flowers) {
            price += flower.getCost();
        }
        for (Accessory accessory : accessories) {
            price += accessory.getCost();
        }
        return price;
    }

    public void sortFlowersByDaysOfLife() {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < flowers.length - 1; i++) {
                if (flowers[i].getDaysOfLife() > flowers[i + 1].getDaysOfLife()) {
                    isSorted = false;
                    Flower temp = flowers[i];
                    flowers[i] = flowers[i + 1];
                    flowers[i + 1] = temp;
                }
            }
        }
    }

    public void findFlowersByStemLength() {
        double minLength = getPositiveDouble("Min length: ");
        double maxLength = getPositiveDouble("Max length: ");
        System.out.println("\nFound flowers: ");
        for (Flower flower : flowers) {
            if (flower.getStemLength() >= minLength && flower.getStemLength() <= maxLength) {
                System.out.println(flower);
            }
        }
    }

    @Override
    public String toString() {
        String result = "\nFlowers: \n";
        for (Flower flower : flowers) {
            result += '\t' + flower.toString() + '\n';
        }
        result += "Accessories: \n";
        for (Accessory accessory : accessories) {
            result += '\t' + accessory.toString() + '\n';
        }
        return result;
    }

    public Flower[] getFlowers() {
        return flowers;
    }

    public void setFlowers(Flower[] flowers) {
        this.flowers = flowers;
    }

    public Accessory[] getAccessories() {
        return accessories;
    }

    public void setAccessories(Accessory[] accessories) {
        this.accessories = accessories;
    }
}
