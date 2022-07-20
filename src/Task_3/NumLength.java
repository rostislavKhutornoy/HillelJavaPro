package Task_3;

/*  2. Задать массив с n чисел (используя инициализатор массива).
    Найти самое короткое последнее и самое длинное последнее число.
    Вывести найденные числа и их длину. (строки не использовать) */

public class NumLength {
    private int numLength(int num) {
        int length = 0;
        while (num != 0) {
            num = (int) num / 10;
            length++;
        }
        return length;
    }

    public int findShortest(int[] array) {
        int min = numLength(array[0]);
        int minIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (min >= numLength(array[i])) {
                min = numLength(array[i]);
                minIndex = i;
            }
        }
        return array[minIndex];
    }

    public int findShortestLength(int[] array) {
        return numLength(findShortest(array));
    }

    public int findLongest(int[] array) {
        int max = numLength(array[0]);
        int maxIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (max <= numLength(array[i])) {
                max = numLength(array[i]);
                maxIndex = i;
            }
        }
        return array[maxIndex];
    }

    public int findLongestLength(int[] array) {
        return numLength(findLongest(array));
    }

    public static void main(String[] args) {
        NumLength numLength = new NumLength();
        int[] array = { 1, 2, 12, 123, 1234, 4567 };
        System.out.println("Last long number: " + numLength.findLongest(array) +
                ", Length: " + numLength.findLongestLength(array));
        System.out.println("Last short number: " + numLength.findShortest(array) +
                ", Length: " + numLength.findShortestLength(array));
    }
}
