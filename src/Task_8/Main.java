package Task_8;

public class Main {
    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[] {
                new Car("Volkswagen Golf", 34500, 7.8, 204, Car.Type.PASSENGER),
                new Car("Aston Martin Vanquish", 280000, 13.1, 324, Car.Type.SPORTS),
                new Car("Volvo XC60", 21900, 7.2, 220, Car.Type.OFF_ROAD),
                new Bus("Liaz 529000 \"Cruise\"", 375000, 31, 100, 48),
                new Bus("Scania (Higer) Touring", 400000, 30, 100, 49),
                new Truck("Mercedes-Benz Actros", 190000, 50, 162, 135000),
                new Truck("IVECO S-WAY", 100000, 30, 120, 90000)
        };
        TaxiPark taxiPark = new TaxiPark(vehicles);
        System.out.println(taxiPark.fleetCost());
        printArray(vehicles);
        printArray(taxiPark.sortByFuelConsumptionAscending());
        printArray(taxiPark.sortByFuelConsumptionDescending());
        printArray(taxiPark.findBySpeed(100, 250));
    }

    public static void printArray(Object[] objects) {
        for (Object o : objects) {
            System.out.println(o);
        }
        System.out.println();
    }
}
