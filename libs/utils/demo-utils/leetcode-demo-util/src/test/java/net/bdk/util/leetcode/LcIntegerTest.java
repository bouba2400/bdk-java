package net.bdk.util.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class LcIntegerTest {
    private LcInteger testee;

    @Nested
    class GetsHammingWeightAsCountOfSetBits {
        @Test
        void forZero() {
            testee = new LcInteger(0);
            int actual = testee.getHammingWeight();
            assertThat(actual).isEqualTo(0);
        }

        @ParameterizedTest
        @MethodSource("paramsForPositiveNumbers")
        void forPositiveNumbers(int n, int expected) {
            testee = new LcInteger(n);
            int actual = testee.getHammingWeight();
            assertThat(actual).isEqualTo(expected);
        }

        static Stream<Arguments> paramsForPositiveNumbers() {
            return Stream.of(
                    arguments(11, 3),
                    arguments(2147483645, 30),
                    arguments(1, 1)
            );
        }

        @ParameterizedTest
        @MethodSource("paramsForNegativeNumbers")
        void forNegativeNumbers(int n, int expected) {
            testee = new LcInteger(n);
            int actual = testee.getHammingWeight();
            assertThat(actual).isEqualTo(expected);
        }

        static Stream<Arguments> paramsForNegativeNumbers() {
            return Stream.of(
                    arguments(-3, 31),
                    arguments(-1, 32)
            );
        }
    }
}
