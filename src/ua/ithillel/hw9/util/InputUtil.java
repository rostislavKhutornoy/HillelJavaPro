package ua.ithillel.hw9.util;

import java.util.Scanner;

public interface InputUtil {
    default double getDouble(String inputComment) {
        double value;
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.print(inputComment);
                value = scanner.nextDouble();
                break;
            } catch (Exception exception) {
                System.out.println("Incorrect input, try again.");
            }
        }
        return value;
    }

    default int getInt(String inputComment) {
        return (int) getDouble(inputComment);
    }

    default double getPositiveDouble(String inputComment) {
        while (true) {
            double value = getDouble(inputComment);
            if (value >= 0) {
                return value;
            } else {
                System.out.println("Incorrect input, try again.");
            }
        }
    }

    default int getPositiveInt(String inputComment) {
        return (int) getPositiveDouble(inputComment);
    }

    default String getString(String inputComment) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(inputComment);
        return scanner.nextLine();
    }
}
