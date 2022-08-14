package ua.ithillel.hw11;

import ua.ithillel.hw11.entity.Vehicle;
import ua.ithillel.hw11.service.VehiclesIOService;

/*Реализовать инициализацию массива Car'ов (из задания про таксопарк) на основе файла (машины должны храниться в файле).
Запятая (,) - разделитель свойств машины
Точка с запятой и конец строки (;\r\n) - разделитель машин
Выполнить чтение всех байтов с файла с помощью FileInputStream в массив байтов.
Создать строку на основе прочитанного массива байтов.
Разделить полученную строку таким образом, чтобы создать экземпляры классов (String.split).
Так же, реализовать запись в файл в соответствующем формате.*/

public class Main {
    public static void main(String[] args) {
        VehiclesIOService vehiclesIOService = new VehiclesIOService("vehicles.txt");
        Vehicle[] vehicles = vehiclesIOService.getVehiclesArray();
        printArray(vehicles);
        vehiclesIOService.writeVehiclesArray(vehicles);
        vehicles = vehiclesIOService.getVehiclesArray();
        printArray(vehicles);
    }

    public static void printArray(Object[] objects) {
        for (Object o : objects) {
            System.out.println(o);
        }
        System.out.println();
    }
}
