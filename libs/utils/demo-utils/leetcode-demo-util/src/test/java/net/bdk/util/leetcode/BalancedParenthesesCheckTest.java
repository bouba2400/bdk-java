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

public class BalancedParenthesesCheckTest {
    private BalancedParenthesesCheck parenthesesCheck;

    @BeforeEach
    void setup() {
        parenthesesCheck = new BalancedParenthesesCheck();
    }

    @Nested
    class ResultIsFalse {
        @Test
        void forBlankString() {
            boolean isValid = parenthesesCheck.perform("");
            assertThat(isValid).isFalse();
        }

        @ParameterizedTest
        @MethodSource("paramsForStringWithNoParentheses")
        void forStringWithNoParentheses(String s) {
            boolean isValid = parenthesesCheck.perform(s);
            assertThat(isValid).isFalse();
        }

        static Stream<Arguments> paramsForStringWithNoParentheses() {
            return Stream.of(arguments("    "), arguments("adh dddd dddjju"), arguments("kkdkkkd\nddddidd\n"));
        }

        @ParameterizedTest
        @MethodSource("paramsForStringWithUnEvenOpenAndCloseParentheses")
        void forStringWithUnEvenOpenAndCloseParentheses(String s) {
            boolean isValid = parenthesesCheck.perform(s);
            assertThat(isValid).isFalse();
        }

        static Stream<Arguments> paramsForStringWithUnEvenOpenAndCloseParentheses() {
            return Stream.of(
                    arguments("("),
                    arguments("(("),
                    arguments("({["),
                    arguments("(a)[bnj"),
                    arguments("} lkl"),
                    arguments("jhduj]]"),
                    arguments("{jhduj (---) } ;;;[(]"));
        }

        @ParameterizedTest
        @MethodSource("paramsForStringWithEvenButDisorderlyOpenAndCloseParentheses")
        void forStringWithEvenButDisorderlyOpenAndCloseParentheses(String s) {
            boolean isValid = parenthesesCheck.perform(s);
            assertThat(isValid).isFalse();
        }

        static Stream<Arguments> paramsForStringWithEvenButDisorderlyOpenAndCloseParentheses() {
            return Stream.of(
                    arguments("(]"),
                    arguments("({[)]}"),
                    arguments("dffffg(a)[ {  kioh] }"),
                    arguments("(} [lkl] {www)"),
                    arguments("([]) }{"),
                    arguments("(hjt([[ffs]])ffsf) pokhg [{]}"));
        }
    }

    @Nested
    class ResultIsTrue {
        @ParameterizedTest
        @MethodSource("paramsForStringWithEvenAndOrderlyOpenAndCloseParentheses")
        void forStringWithEvenAndOrderlyOpenAndCloseParentheses(String s) {
            boolean isValid = parenthesesCheck.perform(s);
            assertThat(isValid).isTrue();
        }

        static Stream<Arguments> paramsForStringWithEvenAndOrderlyOpenAndCloseParentheses() {
            return Stream.of(
                    arguments("()"),
                    arguments("()[]{}"),
                    arguments("{ LKDOL(po[ hugfb ---])poiu}"),
                    arguments("[[(({{}}))]]"),
                    arguments("[[(({{}}))]] {kioh}"));
        }
    }
}
