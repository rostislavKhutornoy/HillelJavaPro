package Task_1;

// 2. Отобразить в окне консоли аргументы командной строки в обратном порядке.

public class ArgsReverse {
    public static void main(String[] args) {
        if (args.length != 0) {
            System.out.println("Arguments: ");
            for (int i = args.length - 1; i >= 0; i--) {
                System.out.println(args[i]);
            }
        } else System.out.println("No arguments.");
    }
}
