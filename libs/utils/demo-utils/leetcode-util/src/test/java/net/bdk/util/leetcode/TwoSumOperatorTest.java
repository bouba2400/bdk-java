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

class TwoSumOperatorTest {
    private TwoSumOperator operator;

    @BeforeEach
    void setup() {
        operator = new TwoSumOperator();
    }

    @Nested
    class ResultIsTwoNegativeOnes {
        @Test
        void forNoNumbers() {
            int[] result = operator.apply(new int[] {}, -1);
            assertThat(result.length).isEqualTo(2);
            assertThat(result[0]).isEqualTo(-1);
            assertThat(result[1]).isEqualTo(-1);
        }

        @Test
        void forOneNumber() {
            int[] result = operator.apply(new int[] {100}, -1);
            assertThat(result.length).isEqualTo(2);
            assertThat(result[0]).isEqualTo(-1);
            assertThat(result[1]).isEqualTo(-1);
        }

        @ParameterizedTest
        @MethodSource("paramsForNumbersWithAnyPairThatSumToTarget")
        void forNumbersWithoutPairThatSumToTarget(int[] nums, int target) {
            int[] result = operator.apply(nums, target);
            assertThat(result.length).isEqualTo(2);
            assertThat(result[0]).isEqualTo(-1);
            assertThat(result[1]).isEqualTo(-1);
        }

        static Stream<Arguments> paramsForNumbersWithAnyPairThatSumToTarget() {
            return Stream.of(
                    arguments(new int[] {0, 0, 0}, 1),
                    arguments(new int[] {100, 200, 300, 600, 900}, 50),
                    arguments(new int[] {-100, 200, -5, 55}, 0),
                    arguments(new int[] {-100, -200}, 2000000),
                    arguments(new int[] {5000, 60000, 1000000, 852147, -652478}, -49),
                    arguments(new int[] {253681853, -956175265, 128109770, 250262893, -911479264}, 334635452));
        }
    }

    @Nested
    class ResultIsTwoRespectiveArrayIndices {
        @Test
        void forNumbersWithPairOfZerosThatSumToTarget() {
            int[] result = operator.apply(new int[] {-5485, 0, -124325478, 666, 0, 125846}, 0);
            assertThat(result.length).isEqualTo(2);
            assertThat(result[0]).isEqualTo(1);
            assertThat(result[1]).isEqualTo(4);
        }

        @ParameterizedTest
        @MethodSource("paramsForNumbersWithAnyPairThatSumToTarget")
        void forNumbersWithAnyPairThatSumToTarget(int[] nums, int target, int firstIndex, int secondIndex) {
            int[] result = operator.apply(nums, target);
            assertThat(result.length).isEqualTo(2);
            assertThat(result[0]).isEqualTo(firstIndex);
            assertThat(result[1]).isEqualTo(secondIndex);
        }

        static Stream<Arguments> paramsForNumbersWithAnyPairThatSumToTarget() {
            return Stream.of(
                    arguments(new int[] {2, 7, 11, 15}, 9, 0, 1),
                    arguments(new int[] {13, 2, 4}, 6, 1, 2),
                    arguments(new int[] {3, 3}, 6, 0, 1),
                    arguments(
                            new int[] {
                                5000,
                                60000,
                                1000000,
                                -100,
                                253681853,
                                -956175265,
                                -911479264,
                                128109770,
                                -200,
                                250262893
                            },
                            -300,
                            3,
                            8));
        }
    }
}
