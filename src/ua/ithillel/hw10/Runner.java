package ua.ithillel.hw10;

import ua.ithillel.hw10.console.PrimeFinderConsoleService;

/*С использованием нескольких потоков выполнения (Thread) реализовать поиск простых чисел внутри заданного диапазона.
Ввести с клавиатуры интервал поиска чисел (например, от 1 до 10000) и число потоков.
Проверку на простоту реализовать самым простым способом: циклом от 2 до числа/2.
Подумать, как разделять интервал поиска по потокам.
Найденные числа должны быть записаны в один общий массив в таком виде, что найденные
простые числа одного потока должны быть расположены подряд.
Написать Unit тесты.*/

public class Runner {
    public static void main(String[] args) {
        PrimeFinderConsoleService primeFinderConsoleService = new PrimeFinderConsoleService();
        primeFinderConsoleService.start();
    }
}
