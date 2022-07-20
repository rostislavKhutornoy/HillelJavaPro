package Task_4;

/* Создать класс по спецификации. Определить конструктор для всех полей.
Создать отдельно класс процессор, который будет выполнять определенные действия с объектами
и содержать метод для печати объекта. В методе main создать массив объектов и используя класс
процессор выполнить необходимые операции.

Car: Марка, Модель, Год выпуска, Цвет, Цена, Регистрационный номер.

Создать массив объектов. Вывести:
a) список автомобилей заданной марки;
b) список автомобилей заданной модели, которые эксплуатируются больше n лет;
c) список автомобилей заданного года выпуска, цена которых больше указанной.*/

/* UPD Task 6.1: Создать в классе процессора из предыдущего задания поле для хранения массива объектов.
Сделать два перегруженных конструктора - один принимает массив объектов и устанавливает
его в поле, второй - не принимает параметров но создает пустой массив
объектов и устанавливает его в поле. Перегрузить все три метода, чтобы в одном случае
они принимали массив и параметры для поиска и работали с этим массивом,
а в другом случае принимали только параметры для поиска и работали с внутренним массивом в случае если он не пустой.*/

public class Runner {
   public static void main(String[] args) {
       Car[] cars = { new Car("BMW", "X3", 2003, "black", 34950, "A482AC"),
               new Car("Audi", "Q7", 2006, "red", 28000, "KY142DO"),
               new Car("BMW", "X5", 2006, "white", 41500, "PC5623") };
       CarProcessor carProcessor1 = new CarProcessor();
       carProcessor1.getByBrand(cars, "BMW");
       carProcessor1.getByOperating(cars, "X5", 10, 2022);
       carProcessor1.getByPrice(cars, 2006, 30000);

       CarProcessor carProcessor2 = new CarProcessor(cars);
       carProcessor2.getByBrand("BMW");
       carProcessor2.getByOperating("X5", 10, 2022);
       carProcessor2.getByPrice(2006, 30000);
    }
}
