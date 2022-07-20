package Task_3_Test;

import Task_3.NumMatrix;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

class NumMatrixTest {

    @ParameterizedTest
    @MethodSource("provideNumMatrix")
    void testDrawMatrix(int input, String expected) {
        NumMatrix tester = new NumMatrix();

        String result = tester.drawMatrix(input);

        Assertions.assertEquals(expected, result);
    }

    private static Stream<Arguments> provideNumMatrix() {
        return Stream.of(
                Arguments.of(3, "1 2 \n3 * \n"),
                Arguments.of(8, "1 2 3 \n4 5 6 \n7 8 * \n"),
                Arguments.of(21, "1 2 3 4 5 \n6 7 8 9 10 \n11 12 13 14 15 \n16 17 18 19 20 \n21 * * * * \n")
        );
    }

}