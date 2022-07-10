package Task_3;

/*  2. Задать массив с n чисел (используя инициализатор массива).
    Найти самое короткое последнее и самое длинное последнее число.
    Вывести найденные числа и их длину. (строки не использовать) */

public class NumLength {
    private static int numLength(int num) {
        int length = 0;
        while (num != 0) {
            num = (int) num / 10;
            length++;
        }
        return length;
    }

    public static void findLengths(int[] array) {
        int min = numLength(array[0]);
        int max = numLength(array[0]);
        int minIndex = 0, maxIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (min >= numLength(array[i])) {
                min = numLength(array[i]);
                minIndex = i;
            }
            if (max <= numLength(array[i])) {
                max = numLength(array[i]);
                maxIndex = i;
            }
        }
        System.out.println("Last long number: " + array[maxIndex] + ", Length: " + max);
        System.out.println("Last short number: " + array[minIndex] + ", Length: " + min);
    }

    public static void main(String[] args) {
        int[] array = { 1, 2, 12, 123, 1234, 4567 };
        findLengths(array);
    }
}
