package ua.ithillel.hw11.util;

import ua.ithillel.hw11.entity.Vehicle;

import java.util.Arrays;

public class ArrayUtil {
    public static Vehicle[] extendVehiclesArray(Vehicle[] array, Vehicle toAdd) {
        if (array.length == 0) {
            return new Vehicle[] { toAdd };
        } else {
            Vehicle[] newArray = Arrays.copyOf(array, array.length + 1);
            newArray[array.length] = toAdd;
            return newArray;
        }
    }
}
