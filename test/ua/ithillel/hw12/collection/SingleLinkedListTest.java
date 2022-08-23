package ua.ithillel.hw12.collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ua.ithillel.hw12.exception.EmptySingleLinkedListException;
import java.util.stream.Stream;

class SingleLinkedListTest {

    @ParameterizedTest
    @MethodSource("provideInsertFirstTest")
    <T> void shouldInsertFirstElementInList(T[] array, T value, Object[] expected) {
        SingleLinkedList<T> testerList = new SingleLinkedList<>(array);

        testerList.insertFirst(value);
        Object[] result = testerList.toArray();

        Assertions.assertArrayEquals(expected, result);
    }

    private static Stream<Arguments> provideInsertFirstTest() {
        return Stream.of(
                Arguments.of(new Integer[] { 1, 2, 3, 4, 5 }, 99, new Object[] { 99, 1, 2, 3, 4, 5 }),
                Arguments.of(new Integer[] {}, 1, new Object[] { 1 }),
                Arguments.of(new String[] { "world" }, "Hello", new Object[] { "Hello", "world" })
        );
    }

    @ParameterizedTest
    @MethodSource("provideInsertLastTest")
    <T> void shouldInsertLastElementInList(T[] array, T value, Object[] expected) {
        SingleLinkedList<T> testerList = new SingleLinkedList<>(array);

        testerList.insertLast(value);
        Object[] result = testerList.toArray();

        Assertions.assertArrayEquals(expected, result);
    }

    private static Stream<Arguments> provideInsertLastTest() {
        return Stream.of(
                Arguments.of(new Integer[] { 1, 2, 3, 4, 5 }, 99, new Object[] { 1, 2, 3, 4, 5, 99 }),
                Arguments.of(new Integer[] {}, 1, new Object[] { 1 }),
                Arguments.of(new String[] { "world" }, "Hello", new Object[] { "world", "Hello" })
        );
    }

    @Test
    void shouldDeleteFirstListElement() throws EmptySingleLinkedListException {
        Integer[] nums = new Integer[] { 1, 2, 3, 4, 5 };
        SingleLinkedList<Integer> testerList = new SingleLinkedList<>(nums);

        testerList.deleteFirst();
        Object[] result = testerList.toArray();

        Assertions.assertArrayEquals(new Object[] { 2, 3, 4, 5 }, result);
        Assertions.assertThrows(EmptySingleLinkedListException.class, () -> {
            SingleLinkedList<Integer> linkedList = new SingleLinkedList<>();
            linkedList.deleteFirst();
        });
    }

    @Test
    void shouldDeleteLastListElement() throws EmptySingleLinkedListException {
        Integer[] nums = new Integer[] { 1, 2, 3, 4, 5 };
        SingleLinkedList<Integer> testerList = new SingleLinkedList<>(nums);

        testerList.deleteLast();
        Object[] result = testerList.toArray();

        Assertions.assertArrayEquals(new Object[] { 1, 2, 3, 4 }, result);
        Assertions.assertThrows(EmptySingleLinkedListException.class, () -> {
            SingleLinkedList<Integer> linkedList = new SingleLinkedList<>();
            linkedList.deleteLast();
        });
    }

    @ParameterizedTest
    @MethodSource("provideInsertNyIndexTest")
    <T> void shouldInsertElementInListByIndex(T[] array, T value, int index, Object[] expected) throws EmptySingleLinkedListException {
        SingleLinkedList<T> testerList = new SingleLinkedList<>(array);

        testerList.insertByIndex(index, value);
        Object[] result = testerList.toArray();

        Assertions.assertArrayEquals(expected, result);
        Assertions.assertThrows(EmptySingleLinkedListException.class, () -> {
            SingleLinkedList<Integer> linkedList = new SingleLinkedList<>();
            linkedList.insertByIndex(0, 1);
        });
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            SingleLinkedList<Integer> linkedList = new SingleLinkedList<>(new Integer[]{ 1, 2, 3 });
            linkedList.insertByIndex(10, 1);
        });
    }

    private static Stream<Arguments> provideInsertNyIndexTest() {
        return Stream.of(
                Arguments.of(new Integer[] { 1, 2, 3, 4, 5 }, 99, 0, new Object[] { 99, 1, 2, 3, 4, 5 }),
                Arguments.of(new Integer[] { 1, 2, 3, 4, 5 }, 99, 3, new Object[] { 1, 2, 3, 99, 4, 5 }),
                Arguments.of(new String[] { "world" }, "Hello", 0, new Object[] { "Hello", "world" })
        );
    }

    @ParameterizedTest
    @MethodSource("provideDeleteByIndexTest")
    <T> void shouldDeleteElementInListByIndex(T[] array, int index, Object[] expected) throws EmptySingleLinkedListException {
        SingleLinkedList<T> testerList = new SingleLinkedList<>(array);

        testerList.deleteByIndex(index);
        Object[] result = testerList.toArray();

        Assertions.assertArrayEquals(expected, result);
        Assertions.assertThrows(EmptySingleLinkedListException.class, () -> {
            SingleLinkedList<Integer> linkedList = new SingleLinkedList<>();
            linkedList.deleteByIndex(0);
        });
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            SingleLinkedList<Integer> linkedList = new SingleLinkedList<>(new Integer[]{ 1, 2, 3 });
            linkedList.deleteByIndex(10);
        });
    }

    private static Stream<Arguments> provideDeleteByIndexTest() {
        return Stream.of(
                Arguments.of(new Integer[] { 1, 2, 3, 4, 5 }, 0, new Object[] { 2, 3, 4, 5 }),
                Arguments.of(new Integer[] { 1, 2, 3, 4, 5 }, 3, new Object[] { 1, 2, 3, 5 }),
                Arguments.of(new String[] { "world" }, 0, new Object[] {})
        );
    }

    @ParameterizedTest
    @MethodSource("provideSwapTest")
    <T> void shouldSwapElementInListByTwoIndexes(T[] array, int firstIndex, int secondIndex, Object[] expected) throws EmptySingleLinkedListException {
        SingleLinkedList<T> testerList = new SingleLinkedList<>(array);

        testerList.swap(firstIndex, secondIndex);
        Object[] result = testerList.toArray();

        Assertions.assertArrayEquals(expected, result);
        Assertions.assertThrows(EmptySingleLinkedListException.class, () -> {
            SingleLinkedList<Integer> linkedList = new SingleLinkedList<>();
            linkedList.swap(0, 1);
        });
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            SingleLinkedList<Integer> linkedList = new SingleLinkedList<>(new Integer[]{ 1, 2, 3 });
            linkedList.swap(10, 1);
        });
    }

    private static Stream<Arguments> provideSwapTest() {
        return Stream.of(
                Arguments.of(new Integer[] { 1, 2, 3, 4, 5 }, 0, 4, new Object[] { 5, 2, 3, 4, 1 }),
                Arguments.of(new Integer[] { 1, 2, 3, 4, 5 }, 2, 3, new Object[] { 1, 2, 4, 3, 5 }),
                Arguments.of(new String[] { "Hello", "world" }, 0, 1, new Object[] { "world", "Hello"})
        );
    }

    @ParameterizedTest
    @MethodSource("provideSizeTest")
    <T> void shouldReturnSizeOfList(T[] array, int expected) {
        SingleLinkedList<T> testerList = new SingleLinkedList<>(array);

        int result = testerList.size();

        Assertions.assertEquals(expected, result);
    }

    private static Stream<Arguments> provideSizeTest() {
        return Stream.of(
                Arguments.of(new Integer[] { 1, 2, 3, 4, 5 }, 5),
                Arguments.of(new Integer[] { }, 0),
                Arguments.of(new String[] { "Hello", "world" }, 2)
        );
    }

    @Test
    void shouldReturnTrueWhenListIsEmptyAndFalseWhenListIsNotEmpty() {
        SingleLinkedList<Integer> testerList1 = new SingleLinkedList<>(new Integer[]{ 1 });
        SingleLinkedList<Integer> testerList2 = new SingleLinkedList<>(new Integer[]{});
        SingleLinkedList<Integer> testerList3 = new SingleLinkedList<>();

        Assertions.assertFalse(testerList1.isEmpty());
        Assertions.assertTrue(testerList2.isEmpty());
        Assertions.assertTrue(testerList3.isEmpty());
    }
}