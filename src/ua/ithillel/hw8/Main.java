package ua.ithillel.hw8;

import ua.ithillel.hw8.domain.Bus;
import ua.ithillel.hw8.domain.Car;
import ua.ithillel.hw8.domain.Truck;
import ua.ithillel.hw8.domain.Vehicle;
import ua.ithillel.hw8.service.TaxiParkService;

/* Таксопарк. Определить иерархию автомобилей. Создать таксопарк.
Подсчитать стоимость автопарка. Провести сортировку автомобилей парка по расходу топлива.
Найти автомобили в компании, соответствующие заданному диапазону параметров скорости.
Для каждого класса автомобилей определить toString() и использовать его для печати объекта.

Сделать таксопарк интерфейсом, определить в нем действия, которые должен выполнять таксопарк. Создать конкретный таксопарк который будет реализовывать интерфейс таксопарка.
Грамотно распределить по пакетам классы.

- базовый класс транспортного средства абстрактный;
- каждый наследник должен определять новые свойства(свойство);
- в классе таксопарка ничего не печатать!!!(System.out.println());
- массив, который будет возвращен методом поиска автомобилей по скорости расширять
 динамически(не считать сразу кол-во подходящих под критерий автомобилей);
- в метод по поиску машин по диапазону задавать min и max скорость и проверять,
 входит ли максимальная скорость текущего автомобиля в диапазон;
- сортировка своя (Arrays.sort не использовать);
- System.arrayсopy не использовать;
- написать JUnit тесты;
- почитать про пакеты из книги Методы программирования и из Java Code Conventions. */

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
        TaxiParkService taxiPark = new TaxiParkService(vehicles);
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
