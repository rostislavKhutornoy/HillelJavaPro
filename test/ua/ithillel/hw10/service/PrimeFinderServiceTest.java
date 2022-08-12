package ua.ithillel.hw10.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrimeFinderServiceTest {

    @Test
    void shouldReturnArrayOfPrimalNumbersFromTheInterval() {
        PrimeFinderService tester = new PrimeFinderService(3, 0, 90);

        int[] result = tester.findResult();
        int resultArraySize = result.length;

        Assertions.assertTrue(subsequence(result, new int[] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29 }));
        Assertions.assertTrue(subsequence(result, new int[] { 31, 37, 41, 43, 47, 53, 59, 61}));
        Assertions.assertTrue(subsequence(result, new int[] { 67, 71, 73, 79, 83, 89 }));
        Assertions.assertEquals(24, resultArraySize);
    }

    public boolean subsequence(int[] sequence, int[] subsequence) {
        boolean isSubsequence = false;
        if (sequence.length > subsequence.length) {
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
            return false;
        }
        return isSubsequence;
    }

}