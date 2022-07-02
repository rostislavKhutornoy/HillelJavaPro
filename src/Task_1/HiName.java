package Task_1;

// 1. Поприветствовать любого пользователя при вводе его имени через аргумент командной строки.

public class HiName {
    public static void main(String[] args) {
        if(args.length != 0) {
            System.out.println("Hello, " + args[0] + ".");
        } else System.out.println("Hello.");
    }
}
