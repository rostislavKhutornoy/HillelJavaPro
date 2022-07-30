package ua.ithillel.hw9.util;

import ua.ithillel.hw9.entity.Accessory;
import ua.ithillel.hw9.entity.Bouquet;
import ua.ithillel.hw9.entity.Flower;

public class ArraysUtil {
    public static Flower[] extendFlowersArray(Flower[] flowers, Flower flowerToAdd) {
        if (flowers.length == 0) {
            return new Flower[] { flowerToAdd };
        } else {
            Flower[] newArray = new Flower[flowers.length + 1];
            for (int i = 0; i < flowers.length; i++) {
                newArray[i] = flowers[i];
            }
            newArray[flowers.length] = flowerToAdd;
            return newArray;
        }
    }

    public static Accessory[] extendAccessoryArray(Accessory[] accessories, Accessory accessoryToAdd) {
        if (accessories.length == 0) {
            return new Accessory[] { accessoryToAdd };
        } else {
            Accessory[] newArray = new Accessory[accessories.length + 1];
            for (int i = 0; i < accessories.length; i++) {
                newArray[i] = accessories[i];
            }
            newArray[accessories.length] = accessoryToAdd;
            return newArray;
        }
    }

    public static Bouquet[] extendBouquetArray(Bouquet[] bouquets, Bouquet bouquetToAdd) {
        if (bouquets.length == 0) {
            return new Bouquet[] { bouquetToAdd };
        } else {
            Bouquet[] newArray = new Bouquet[bouquets.length + 1];
            for (int i = 0; i < bouquets.length; i++) {
                newArray[i] = bouquets[i];
            }
            newArray[bouquets.length] = bouquetToAdd;
            return newArray;
        }
    }
}
