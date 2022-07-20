package Task_3;

/*  3. Задать массив с n чисел (используя инициализатор массива).
    Найти числа, состоящее только из различных цифр. (строки не использовать) */

public class UniqueNum {
    private int numLength(int num) {
        int length = 0;
        while (num != 0) {
            num = (int) num / 10;
            length++;
        }
        return length;
    }

    public boolean isUnique(int num) {
        int[] nums = new int[numLength(num)];
        for (int i = numLength(num) - 1; i >= 0; i--) {
            nums[i] = num % 10;
            num /= 10;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j] && i != j) {
                    return false;
                }
            }
        }
        return true;
    }

    public void findUnique(int[] array) {
        System.out.print("Numbers made up of unique digits in array: ");
        for (int value : array) {
            if (isUnique(value)) {
                System.out.print(value + " ");
            }
        }
    }

    public static void main(String[] args) {
        UniqueNum uniqueNum = new UniqueNum();
        int[] array = { 123, 1233, 3546, 252523, 65453, 4302 };
        uniqueNum.findUnique(array);
    }

}
