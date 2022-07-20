package Task_3_Test;

import Task_3.UniqueNum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

class UniqueNumTest {

    @ParameterizedTest
    @MethodSource("provideUniqueNumbers")
    void testUniqueNum(int input, boolean expected) {
        UniqueNum tester = new UniqueNum();

        boolean result = tester.isUnique(input);

        Assertions.assertEquals(expected, result);
    }

    private static Stream<Arguments> provideUniqueNumbers() {
        return Stream.of(
                Arguments.of(12345, true),
                Arguments.of(85673, true),
                Arguments.of(98, true),
                Arguments.of(123345, false),
                Arguments.of(123435, false),
                Arguments.of(312453, false),
                Arguments.of(99, false)
        );
    }

}

