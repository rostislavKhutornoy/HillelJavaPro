package Task_8_Test;

import Task_8.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

class TaxiParkTest {

    @ParameterizedTest
    @MethodSource("provideVehiclesArrayForCostTest")
    void shouldReturnTotalVehiclesCost(Vehicle[] vehicles, double expected) {
        TaxiPark tester = new TaxiPark(vehicles);

        double result = tester.fleetCost();

        Assertions.assertEquals(expected, result);
    }

    private static Stream<Arguments> provideVehiclesArrayForCostTest() {
        return Stream.of(
                Arguments.of(new Vehicle[] { new Car("Volkswagen Golf", 34500, 7.8, 204, Car.Type.PASSENGER),
                        new Bus("Scania (Higer) Touring", 400000, 30, 100, 49) }, 434500),
                Arguments.of(new Vehicle[] {}, 0)
        );
    }

    @Test
    void shouldReturnArraySortedByFuelConsumptionDescending() {
        Vehicle[] vehicles = new Vehicle[] {
                new Car("Volkswagen Golf", 34500, 7.8, 204, Car.Type.PASSENGER),
                new Car("Aston Martin Vanquish", 280000, 13.1, 324, Car.Type.SPORTS),
                new Car("Volvo XC60", 21900, 7.2, 220, Car.Type.OFF_ROAD)
        };
        TaxiPark tester = new TaxiPark(vehicles);

        Vehicle[] resultArray = tester.sortByFuelConsumptionDescending();
        boolean result = true;
        for (int i = 0; i < resultArray.length - 1; i++) {
            if (resultArray[i].fuelConsumption < resultArray[i + 1].fuelConsumption) {
                result = false;
                break;
            }
        }

        Assertions.assertTrue(result);
    }

    @Test
    void shouldReturnArraySortedByFuelConsumptionAscending() {
        Vehicle[] vehicles = new Vehicle[] {
                new Car("Volkswagen Golf", 34500, 7.8, 204, Car.Type.PASSENGER),
                new Car("Aston Martin Vanquish", 280000, 13.1, 324, Car.Type.SPORTS),
                new Car("Volvo XC60", 21900, 7.2, 220, Car.Type.OFF_ROAD)
        };
        TaxiPark tester = new TaxiPark(vehicles);

        Vehicle[] resultArray = tester.sortByFuelConsumptionAscending();
        boolean result = true;
        for (int i = 0; i < resultArray.length - 1; i++) {
            if (resultArray[i].fuelConsumption > resultArray[i + 1].fuelConsumption) {
                result = false;
                break;
            }
        }

        Assertions.assertTrue(result);
    }

    @ParameterizedTest
    @MethodSource("provideVehiclesArrayForSpeedTest")
    void findBySpeed(Vehicle[] vehicles, int minSpeed, int maxSpeed, int expectedSize) {
        TaxiPark tester = new TaxiPark(vehicles);

        Vehicle[] resultArray = tester.findBySpeed(minSpeed, maxSpeed);
        int resultSize = resultArray.length;
        boolean inRange = true;
        for (Vehicle vehicle : resultArray) {
            if (vehicle.maxSpeed < minSpeed || vehicle.maxSpeed > maxSpeed) {
                inRange = false;
                break;
            }
        }

        Assertions.assertEquals(expectedSize, resultSize);
        Assertions.assertTrue(inRange);
    }

    private static Stream<Arguments> provideVehiclesArrayForSpeedTest() {
        return Stream.of(
                Arguments.of(new Vehicle[] {
                        new Car("Volkswagen Golf", 34500, 7.8, 204, Car.Type.PASSENGER),
                        new Car("Aston Martin Vanquish", 280000, 13.1, 324, Car.Type.SPORTS),
                        new Car("Volvo XC60", 21900, 7.2, 220, Car.Type.OFF_ROAD),
                        new Bus("Liaz 529000 \"Cruise\"", 375000, 31, 100, 48),
                        new Bus("Scania (Higer) Touring", 400000, 30, 100, 49),
                        new Truck("Mercedes-Benz Actros", 190000, 50, 162, 135000),
                        new Truck("IVECO S-WAY", 100000, 30, 120, 90000)
                }, 150, 300, 3),
                Arguments.of(new Vehicle[] {
                        new Car("Volkswagen Golf", 34500, 7.8, 204, Car.Type.PASSENGER),
                        new Car("Aston Martin Vanquish", 280000, 13.1, 324, Car.Type.SPORTS),
                        new Car("Volvo XC60", 21900, 7.2, 220, Car.Type.OFF_ROAD),
                        new Bus("Liaz 529000 \"Cruise\"", 375000, 31, 100, 48),
                        new Bus("Scania (Higer) Touring", 400000, 30, 100, 49),
                        new Truck("Mercedes-Benz Actros", 190000, 50, 162, 135000),
                        new Truck("IVECO S-WAY", 100000, 30, 120, 90000)
                }, 0, 130, 3),
                Arguments.of(new Vehicle[] {}, 0, 0, 0)
        );
    }
}