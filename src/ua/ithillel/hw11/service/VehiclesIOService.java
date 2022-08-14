package ua.ithillel.hw11.service;

import ua.ithillel.hw11.entity.Bus;
import ua.ithillel.hw11.entity.Car;
import ua.ithillel.hw11.entity.Truck;
import ua.ithillel.hw11.entity.Vehicle;
import ua.ithillel.hw11.util.ArrayUtil;
import ua.ithillel.hw11.util.IOUtil;
import java.util.Arrays;

public class VehiclesIOService {
    private Vehicle[] vehicles;
    final private String filename;

    public VehiclesIOService(String filename) {
        this.vehicles = new Vehicle[] {};
        this.filename = filename;
    }

    public void writeVehiclesArray(Vehicle[] vehicles) {
        String str = "";
        if (!IOUtil.isFileEmpty(filename)) {
            str += ";" + System.lineSeparator();
        }
        for (int i = 0; i < vehicles.length; i++) {
            str += vehicles[i].getClass().getSimpleName() + "," +
                    vehicles[i].getName() + "," +
                    vehicles[i].getCost() + "," +
                    vehicles[i].getFuelConsumption() + "," +
                    vehicles[i].getMaxSpeed() + ",";
            if (vehicles[i] instanceof Car) {
                str += ((Car) vehicles[i]).getType();
            }
            if (vehicles[i] instanceof Bus) {
                str += ((Bus) vehicles[i]).getPassengerCapacity();
            }
            if (vehicles[i] instanceof Truck) {
                str += ((Truck) vehicles[i]).getLoadCapacity();
            }
            if (i != vehicles.length - 1) {
                str += ";" + System.lineSeparator();
            }
        }
        IOUtil.writeFile(filename, str, true);
    }

    public Vehicle[] getVehiclesArray() {
        createVehicles(getVehiclesParameters());
        Vehicle[] newArray = Arrays.copyOf(vehicles, vehicles.length);
        vehicles = new Vehicle[]{};
        return newArray;
    }

    private String[] getVehiclesParameters() {
        final String str = IOUtil.readFile(filename);
        if (str != null) {
            return str.split(";" + System.lineSeparator());
        }
        return new String[] {};
    }

    private void createVehicles(String[] str) {
        for (String s : str) {
            String[] vehiclesParameters = s.split(",");
            switch (vehiclesParameters[0]) {
                case "Car" -> {
                    vehicles = ArrayUtil.extendVehiclesArray(vehicles,
                            new Car(vehiclesParameters[1],
                                    Double.parseDouble(vehiclesParameters[2]),
                                    Double.parseDouble(vehiclesParameters[3]),
                                    Double.parseDouble(vehiclesParameters[4]),
                                    vehiclesParameters[5]));
                }
                case "Bus" -> {
                    vehicles = ArrayUtil.extendVehiclesArray(vehicles,
                            new Bus(vehiclesParameters[1],
                                    Double.parseDouble(vehiclesParameters[2]),
                                    Double.parseDouble(vehiclesParameters[3]),
                                    Double.parseDouble(vehiclesParameters[4]),
                                    Integer.parseInt(vehiclesParameters[5])));
                }
                case "Truck" -> {
                    vehicles = ArrayUtil.extendVehiclesArray(vehicles,
                            new Truck(vehiclesParameters[1],
                                    Double.parseDouble(vehiclesParameters[2]),
                                    Double.parseDouble(vehiclesParameters[3]),
                                    Double.parseDouble(vehiclesParameters[4]),
                                    Double.parseDouble(vehiclesParameters[5])));
                }
            }
        }
    }
}
