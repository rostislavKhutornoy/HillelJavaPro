package ua.ithillel.hw3;

/*  4. Вывести числа от 1 до k в виде матрицы N x N слева направо
    и сверху вниз (матрица обязательно должна быть квадратной, массив не создавать) */

public class NumMatrix {
    public String drawMatrix(int num) {
        String result = "";
        int value = 1;
        for (int i = 0; i < Math.ceil(Math.sqrt(num)); i++) {
            for (int j = 0; j < Math.ceil(Math.sqrt(num)); j++) {
                if (value <= num) {
                    result += value + " ";
                    value++;
                }
                else {
                    result += "* ";
                }
            }
            result += "\n";
        }
        return result;
    }

    public static void main(String[] args) {
        NumMatrix numMatrix = new NumMatrix();
        String result = numMatrix.drawMatrix(21);
        System.out.println(result);
    }
}
