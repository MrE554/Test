import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MainTests {
    private static Main main;

    @BeforeAll
    public static void init() {
        main = new Main();
    }

    @ParameterizedTest
    @MethodSource("intArraysForTestExceptionGetFromArrayEverythingAfterFour")
    void testExceptionGetFromArrayEverythingAfterFour(int[] source) {
        assertThrows(
                RuntimeException.class,
                () -> main.getFromArrayEverythingAfterFour(source)
        );
    }

    static Stream<Arguments> intArraysForTestExceptionGetFromArrayEverythingAfterFour() {
        return Stream.of(
                Arguments.of(new int[]{3, 6, 8, 5, 0, 2}),
                Arguments.of(new int[]{7, 5, 9, 3, 6}),
                Arguments.of(new int[]{1, 5, 8, 6, 1, 0}),
                Arguments.of(new int[]{})
        );
    }

    @ParameterizedTest
    @MethodSource("intArraysForTestDoesNotExceptionGetFromArrayEverythingAfterFour")
    void testDoesNotExceptionGetFromArrayEverythingAfterFour(int[] source) {
        assertDoesNotThrow(
                () -> main.getFromArrayEverythingAfterFour(source)
        );
    }

    static Stream<Arguments> intArraysForTestDoesNotExceptionGetFromArrayEverythingAfterFour() {
        return Stream.of(
                Arguments.of(new int[]{3, 6, 8, 5, 0, 2, 4}),
                Arguments.of(new int[]{7, 5, 9, 4, 3, 6}),
                Arguments.of(new int[]{1, 5, 4, 8, 6, 1, 0}),
                Arguments.of(new int[]{4})
        );
    }

    @ParameterizedTest
    @MethodSource("intArraysForTestResultGetFromArrayEverythingAfterFour")
    void testResultGetFromArrayEverythingAfterFour(int[] source, int[] result) {
        assertArrayEquals(main.getFromArrayEverythingAfterFour(source), result);
    }
    
    static Stream<Arguments> intArraysForTestResultGetFromArrayEverythingAfterFour() {
        return Stream.of(
                Arguments.of(new int[]{2, 5, 8, 0, 1, 4, 1, 7}, new int[]{1, 7}),
                Arguments.of(new int[]{5, 2, 7, 4, 8, 9, 2}, new int[]{8, 9, 2}),
                Arguments.of(new int[]{1, 6, 1, 8, 4}, new int[]{}),
                Arguments.of(new int[]{4}, new int[]{}),
                Arguments.of(new int[]{4, 1, 5, 1, 8, 3, 0}, new int[]{1, 5, 1, 8, 3, 0})
        );
    }

    @ParameterizedTest
    @MethodSource("intArraysForTestCheckArrayHaveOneAndFourFalse")
    void testCheckArrayHaveOneAndFourFalse(int[] source) {
        Assertions.assertFalse(main.checkArrayHaveOneAndFour(source));
    }

    static Stream<Arguments> intArraysForTestCheckArrayHaveOneAndFourFalse() {
        return Stream.of(
                Arguments.of(new int[]{3, 6, 8, 5, 0, 2}),
                Arguments.of(new int[]{4, 7, 5, 9, 3, 6, 4}),
                Arguments.of(new int[]{1, 5, 8, 6, 1, 0}),
                Arguments.of(new int[]{})
        );
    }

    @ParameterizedTest
    @MethodSource("intArraysForTestCheckArrayHaveOneAndFourTrue")
    void testCheckArrayHaveOneAndFourTrue(int[] source) {
        Assertions.assertTrue(main.checkArrayHaveOneAndFour(source));
    }

    static Stream<Arguments> intArraysForTestCheckArrayHaveOneAndFourTrue() {
        return Stream.of(
                Arguments.of(new int[]{1, 4, 5, 0, 3, 1, 6}),
                Arguments.of(new int[]{5, 2, 7, 4, 1, 7, 4}),
                Arguments.of(new int[]{0, 3, 1, 6, 4, 1, 8})
        );
    }
}
