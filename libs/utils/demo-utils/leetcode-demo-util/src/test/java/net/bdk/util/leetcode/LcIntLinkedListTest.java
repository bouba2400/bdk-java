package net.bdk.util.leetcode;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LcIntLinkedListTest {
    private LcIntLinkedList testee;

    @Nested
    class Reverse {
        @Nested
        class IsEmptyList {
            @Test
            void forEmptyList() {
                testee = new LcIntLinkedList(null);
                LcIntLinkedList actual = testee.reverse();
                assertThat(actual.isEmpty()).isTrue();
            }
        }

        @Nested
        class IsSameList {
            @Test
            void forOneElementList() {
                LcIntLinkedList.IntListNode el1 = new LcIntLinkedList.IntListNode(0);
                testee = new LcIntLinkedList(el1);
                LcIntLinkedList actual = testee.reverse();
                assertThat(actual.isEmpty()).isFalse();
                assertThat(actual.head().val()).isEqualTo(el1.val());
                assertThat(actual.head().next()).isNull();
            }
        }

        @Nested
        class IsListWithElementsReversed {
            @Test
            void forTwoElementList() {
                LcIntLinkedList.IntListNode el2 = new LcIntLinkedList.IntListNode(2);
                LcIntLinkedList.IntListNode el1 = new LcIntLinkedList.IntListNode(1, el2);
                testee = new LcIntLinkedList(el1);
                LcIntLinkedList actual = testee.reverse();
                assertThat(actual.isEmpty()).isFalse();
                assertThat(actual.head().val()).isEqualTo(el2.val());
                assertThat(actual.head().next()).isNotNull();
                assertThat(actual.head().next().val()).isEqualTo(el1.val());
                assertThat(actual.head().next().next()).isNull();
            }

            @Test
            void forThreeElementList() {
                LcIntLinkedList.IntListNode el3 = new LcIntLinkedList.IntListNode(-652);
                LcIntLinkedList.IntListNode el2 = new LcIntLinkedList.IntListNode(-21, el3);
                LcIntLinkedList.IntListNode el1 = new LcIntLinkedList.IntListNode(-45781, el2);
                testee = new LcIntLinkedList(el1);
                LcIntLinkedList actual = testee.reverse();
                assertThat(actual.isEmpty()).isFalse();
                assertThat(actual.head().val()).isEqualTo(el3.val());
                assertThat(actual.head().next()).isNotNull();
                assertThat(actual.head().next().val()).isEqualTo(el2.val());
                assertThat(actual.head().next().next()).isNotNull();
                assertThat(actual.head().next().next().val()).isEqualTo(el1.val());
                assertThat(actual.head().next().next().next()).isNull();
            }

            @Test
            void forFiveElementList() {
                LcIntLinkedList.IntListNode el5 = new LcIntLinkedList.IntListNode(5);
                LcIntLinkedList.IntListNode el4 = new LcIntLinkedList.IntListNode(4, el5);
                LcIntLinkedList.IntListNode el3 = new LcIntLinkedList.IntListNode(3, el4);
                LcIntLinkedList.IntListNode el2 = new LcIntLinkedList.IntListNode(2, el3);
                LcIntLinkedList.IntListNode el1 = new LcIntLinkedList.IntListNode(1, el2);
                testee = new LcIntLinkedList(el1);
                LcIntLinkedList actual = testee.reverse();
                assertThat(actual.isEmpty()).isFalse();
                assertThat(actual.head().val()).isEqualTo(el5.val());
                assertThat(actual.head().next()).isNotNull();
                assertThat(actual.head().next().val()).isEqualTo(el4.val());
                assertThat(actual.head().next().next()).isNotNull();
                assertThat(actual.head().next().next().val()).isEqualTo(el3.val());
                assertThat(actual.head().next().next().next()).isNotNull();
                assertThat(actual.head().next().next().next().val()).isEqualTo(el2.val());
                assertThat(actual.head().next().next().next().next()).isNotNull();
                assertThat(actual.head().next().next().next().next().val()).isEqualTo(el1.val());
                assertThat(actual.head().next().next().next().next().next()).isNull();
            }
        }
    }
}
