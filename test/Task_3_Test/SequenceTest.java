package Task_3_Test;

import Task_3.Sequence;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

class SequenceTest {

    @ParameterizedTest
    @MethodSource("provideSequences")
    void testSubsequence(int[] sequence, int[] subsequence, boolean expected) {
        Sequence tester = new Sequence();

        boolean result = tester.subsequence(sequence, subsequence);

        Assertions.assertEquals(expected, result);
    }

    private static Stream<Arguments> provideSequences() {
        return Stream.of(
                Arguments.of(new int[] { 1, 2, 3, 4, 5 }, new int[] { 1, 2, 3 }, true),
                Arguments.of(new int[] { 1, 2, 3, 4, 5 }, new int[] { 2, 3, 4 }, true),
                Arguments.of(new int[] { 1, 2, 3, 4, 5 }, new int[] { 3, 4, 5 }, true),
                Arguments.of(new int[] { 1, 2, 3, 4, 5 }, new int[] { 1, 3, 4 }, false),
                Arguments.of(new int[] { 1, 2, 3, 4, 5 }, new int[] { 1, 2, 3, 4, 5 }, false)
        );
    }

}