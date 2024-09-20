package net.bdk.util.leetcode;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class LcStairsTest {
    private LcStairs testee;

    @Nested
    class GetsOneAndTwoStepClimbingWays {
        @Test
        void forZeroTotalSteps() {
            testee = new LcStairs(0);
            int actual = testee.getOneAndTwoStepClimbingWays();
            assertThat(actual).isEqualTo(0);
        }

        @ParameterizedTest
        @MethodSource("paramsForOddTotalSteps")
        void forOddTotalSteps(int n, int expected) {
            testee = new LcStairs(n);
            int actual = testee.getOneAndTwoStepClimbingWays();
            assertThat(actual).isEqualTo(expected);
        }

        static Stream<Arguments> paramsForOddTotalSteps() {
            return Stream.of(
                    arguments(1, 1),
                    arguments(3, 3),
                    arguments(5, 8)
            );
        }

        @ParameterizedTest
        @MethodSource("paramsForEvenTotalSteps")
        void forEvenTotalSteps(int n, int expected) {
            testee = new LcStairs(n);
            int actual = testee.getOneAndTwoStepClimbingWays();
            assertThat(actual).isEqualTo(expected);
        }

        static Stream<Arguments> paramsForEvenTotalSteps() {
            return Stream.of(
                    arguments(2, 2),
                    arguments(4, 5),
                    arguments(6, 13)
            );
        }

        @ParameterizedTest
        @MethodSource("paramsForNegativeTotalSteps")
        void forNegativeTotalSteps(int n, int expected) {
            testee = new LcStairs(n);
            int actual = testee.getOneAndTwoStepClimbingWays();
            assertThat(actual).isEqualTo(expected);
        }

        static Stream<Arguments> paramsForNegativeTotalSteps() {
            return Stream.of(
                    arguments(-1, -1),
                    arguments(-54, -1),
                    arguments(-368, -1)
            );
        }
    }
}
