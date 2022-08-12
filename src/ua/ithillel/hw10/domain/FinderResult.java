package ua.ithillel.hw10.domain;

import java.util.Arrays;

public class FinderResult {
    private int[] result;

    public FinderResult() {
        this.result = new int[]{};
    }

    synchronized public void pushArray(int[] numbers) {
        result = Arrays.copyOf(result, result.length + numbers.length);
        for (int i = numbers.length - 1;  i >= 0; i--) {
            result[result.length - 1 - i] = numbers[numbers.length - i - 1];
        }
    }

    public int[] getResult() {
        return result;
    }

    public void setResult(int[] result) {
        this.result = result;
    }
}
