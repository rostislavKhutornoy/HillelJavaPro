package Task_3;

/*  4. Вывести числа от 1 до k в виде матрицы N x N слева направо
    и сверху вниз (матрица обязательно должна быть квадратной, массив не создавать) */

public class NumMatrix {
    public static void drawMatrix(int num) {
        int value = 1;
        for (int i = 0; i < Math.ceil(Math.sqrt(num)); i++) {
            for (int j = 0; j < Math.ceil(Math.sqrt(num)); j++) {
                if (value <= num) {
                    System.out.printf("%-5d", value);
                    value++;
                }
                else {
                    System.out.printf("%-5s", "*");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        drawMatrix(21);
    }
}
