package Task_3;

/*  1. Даны две последовательности целых чисел (два массива, созданных через инициализатор, длинной n и k, n ≥ k).
    Выяснить, является ли вторая последовательность подпоследовательностью первой.
    Например, последовательность 4, 6, 3 является подпоследовательностью последовательности 0, 2, 4, 6, 3, -1, 1. */

public class Sequence {
    public static void subsequence(int[] sequence, int[] subsequence) {
        boolean isSubsequence = false;
        if (sequence.length >= subsequence.length) {
            for (int i = 0; i < sequence.length - subsequence.length + 1; i++) {
                if (isSubsequence) {
                    break;
                }
                int k = i;
                for (int value : subsequence) {
                    if (value == sequence[k]) {
                        isSubsequence = true;
                        ++k;
                    } else {
                        isSubsequence = false;
                        break;
                    }
                }
            }
        } else {
            System.out.println("Check conditions not met (n < k)");
            return;
        }
        if (isSubsequence) {
            System.out.println("The sequence is a subsequence");
        } else {
            System.out.println("The sequence is not a subsequence");
        }
    }

    public static void main(String[] args) {
        int[] n = { 0, 2, 4, 6, 3, -1, 1 };
        int[] k = { 2, 4, 6 };
        subsequence(n, k);
    }
}
