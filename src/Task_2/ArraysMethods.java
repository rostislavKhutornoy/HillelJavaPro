package Task_2;

public class ArraysMethods {
    public static void printEven(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                System.out.print(array[i] + " ");
            }
        }
        System.out.println("");
    }

    public static void printOdd(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                System.out.print(array[i] + " ");
            }
        }
        System.out.println("");
    }

    private static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int j = 2; j <= Math.sqrt(num); j++) {
            if (num % j == 0) {
                return false;
            }
        }
        return true;
    }

    public static void printPrime(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (isPrime(array[i])) {
                System.out.print(array[i] + " ");
            }
        }
        System.out.println("");
    }

    public static void printMinMax(int[] array) {
        int min = array[0], max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
            if (max < array[i]) {
                max = array[i];
            }
        }
        System.out.println("Min: " + min + "\tMax: " + max);
    }

    public static int[] fibonacci(int size) {
        int[] array = new int[size];
        array[0] = 1;
        array[1] = 1;
        for (int i = 0; i < size - 2; i++) {
            array[i + 2] = array[i] + array[i + 1];
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

        /* 1. Объявить массив с n-м количеством случайных чисел (используя инициализатор массива)
        и вывести на консоль четные и нечетные числа из этого массива. */
        printEven(array);
        printOdd(array);

        /* 2. Объявить массив с n-м количеством случайных чисел (используя инициализатор массива)
        и вывести на консоль простые числа из этого массива. */
        printPrime(array);

        /* 3. Создайте массив из 20-ти первых чисел Фибоначчи и выведите его на экран
        (первый и второй члены последовательности равны единицам, а каждый следующий — сумме двух предыдущих) */
        int[] fibonacci = fibonacci(20);
        for (int i = 0; i < fibonacci.length; i++) {
            System.out.print(fibonacci[i] + " ");
        }
        System.out.println("");

        /* 4. Объявить массив с n-м количеством случайных чисел (используя инициализатор массива)
        и вывести на консоль наибольшее и наименьшее число из этого массива. */
        printMinMax(array);
    }
}
