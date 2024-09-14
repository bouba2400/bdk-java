package net.bdk.util.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class BitReversalTest {
    private BitReversal testee;

    @BeforeEach
    void setup() {
        testee = new BitReversal();
    }

    @Nested
    class ResultIsBitReversedNumber {
        @ParameterizedTest
        @MethodSource("paramsForPositiveNumbers")
        void forPositiveNumbers(int n, int bitReversedNumber) {
            int actual = testee.perform(n);
            assertThat(actual).isEqualTo(bitReversedNumber);
        }

        static Stream<Arguments> paramsForPositiveNumbers() {
            return Stream.of(
                    arguments(43261596, 964176192),
                    arguments(-3, -1073741825),
                    arguments(1, -2147483648),
                    arguments(-1, -1),
                    arguments(0, 0)
            );
        }
    }
}
