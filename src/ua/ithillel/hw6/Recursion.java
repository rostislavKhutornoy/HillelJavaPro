package ua.ithillel.hw6;

public class Recursion {
    public static void printSequence(int n) {
        if (n >= 1) {
            printSequence(n - 1);
            System.out.print(n + " ");
        }
    }

    public static int numAmount(int num) {
        if (num != 0) {
            return num % 10 + numAmount(num / 10);
        }
        return 0;
    }

    public static void main(String[] args) {
        /* 2. Дано натуральное число n (обычная переменная int).
        Рекурсивно вывести все числа от 1 до n. (Ввод 5 -> вывод 1 2 3 4 5) */
        printSequence(5);

        /* 3. Рекурсивно вычислить сумму цифр числа */
        int num = numAmount(12345);
        System.out.println(num);
    }
}
