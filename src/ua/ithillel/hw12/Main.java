package ua.ithillel.hw12;

/*  Реализовать структуру данных односвязного списка.
    Список сделать обобщенным (Generic).
    Индекс в ноде не хранить! */

import ua.ithillel.hw12.collection.SingleLinkedList;
import ua.ithillel.hw12.exception.EmptySingleLinkedListException;

public class Main {
    public static void main(String[] args) throws EmptySingleLinkedListException {
        // Функции списка:
        // Инициализация списка(пустого и на основании массива)
        SingleLinkedList<Integer> emptyList = new SingleLinkedList<>();

        Integer[] nums = new Integer[] { 1, 2, 3, 4, 5 };
        SingleLinkedList<Integer> list = new SingleLinkedList<>(nums);

        // Добавление узла в список в начало, конец и внутрь по нидексу
        list.insertFirst(0);
        list.insertLast(7);
        list.insertByIndex(6, 6);


        // Удаление узла из начала, конца и n-го элемента
        list.deleteLast();
        list.deleteFirst();
        list.deleteByIndex(4);

        // Вывод элементов списка (toString())
        System.out.println(list);

        // Взаимообмен двух узлов списка (по двум идексам)
        list.swap(1, 4);

        // Количество элементов в списке
        System.out.println(emptyList.length());
        System.out.println(list.length());

        // Проверить список на пустоту
        System.out.println(emptyList.isEmpty());
        System.out.println(list.isEmpty());
    }
}
