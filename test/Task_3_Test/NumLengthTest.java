package Task_3_Test;

import Task_3.NumLength;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

class NumLengthTest {

    @ParameterizedTest
    @MethodSource("provideLengths")
    void testNumLength(int[] input, int longest, int longestLength, int shortest, int shortestLength) {
        NumLength tester = new NumLength();

        int longestResult = tester.findLongest(input);
        int longestLengthResult = tester.findLongestLength(input);
        int shortestResult = tester.findShortest(input);
        int shortestLengthResult = tester.findShortestLength(input);

        Assertions.assertEquals(longest, longestResult);
        Assertions.assertEquals(longestLength, longestLengthResult);
        Assertions.assertEquals(shortest, shortestResult);
        Assertions.assertEquals(shortestLength, shortestLengthResult);
    }

    private static Stream<Arguments> provideLengths() {
        return Stream.of(
                Arguments.of(new int[] { 1, 2, 12, 123, 1234, 4567 }, 4567, 4, 2, 1),
                Arguments.of(new int[] { 999999, 1, 44458, 7834295, 888, 22, 991834798, 4837, 3 }, 991834798, 9, 3, 1),
                Arguments.of(new int[] { 1, 1, 1, 1 }, 1, 1, 1, 1)
        );
    }

}