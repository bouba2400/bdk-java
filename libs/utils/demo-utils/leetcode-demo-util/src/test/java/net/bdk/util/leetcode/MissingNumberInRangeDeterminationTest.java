package net.bdk.util.leetcode;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class MissingNumberInRangeDeterminationTest {
    private MissingNumberInRangeDetermination missingNumberDetermination;

    @BeforeEach
    void setup() {
        missingNumberDetermination = new MissingNumberInRangeDetermination();
    }

    @Nested
    class ResultIsNegativeOne {
        @Test
        void forNoNumbers() {
            int num = missingNumberDetermination.perform(new int[] {});
            assertThat(num).isEqualTo(-1);
        }
    }

    @Nested
    class ResultIsMissingNumber {
        @ParameterizedTest
        @MethodSource("paramsForSmallRangeOfNumbers")
        void forSmallRangeOfNumbers(int[] nums, int missingNum) {
            int num = missingNumberDetermination.perform(nums);
            assertThat(num).isEqualTo(missingNum);
        }

        static Stream<Arguments> paramsForSmallRangeOfNumbers() {
            return Stream.of(
                    arguments(new int[] {3, 0, 1}, 2),
                    arguments(new int[] {0, 1}, 2),
                    arguments(new int[] {9, 6, 4, 2, 3, 5, 7, 0, 1}, 8));
        }
    }
}
