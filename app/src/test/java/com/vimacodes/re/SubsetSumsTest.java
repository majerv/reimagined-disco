package com.vimacodes.re;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class SubsetSumsTest {

    // unit under test
    private SubsetSums subsetSums;

    @BeforeEach
    void setUp() {
        subsetSums = new SubsetSums();
    }

    @ParameterizedTest
    @MethodSource
    void verifyOneThreeSubsetSum(int[] A, int b, boolean expected) {
        // given - the parameters

        // when
        boolean result = subsetSums.isOneThreeSubsetOf(A, b);

        // then
        assertEquals(expected, result);
    }

    private static Stream<Arguments> verifyOneThreeSubsetSum() {
        return Stream.of(
                // positive cases
                arguments(new int[]{16, 4, 2, 7, 11, 1}, 61, true),
                arguments(new int[]{1, 2, 3, 4, 5}, 10, true),
                arguments(new int[]{1, 2, 3, 4, 5}, 45, true), // equals to max 45
                arguments(new int[]{100, 200, 3, 4, 5}, 27, true),
                // negative cases
                arguments(new int[]{1, 2, 3, 4, 5}, 46, false), // maximal sum here is 45
                arguments(new int[]{100, 200, 300}, 99, false), // b is smaller than the elements
                arguments(new int[]{1, 2, 100}, 10, false) // 9 < x < 100 not possible
        );
    }
}
