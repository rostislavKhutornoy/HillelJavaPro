package Task_1;

/* 3. Объявить массив с n-м количеством случайных чисел (используя инициализатор массива)
 и вывести числа массива один раз с переходом(столбец) и один раз без перехода на новую строку(строка).
 */

public class ArraysPrint {
    public static void ArrayPrintln(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void ArrayPrint(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        ArrayPrintln(array);
        ArrayPrint(array);
    }
}
