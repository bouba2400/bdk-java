package net.bdk.util.leetcode;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class LinkedListMergeTest {
    private LinkedListMerge listMerge;

    @BeforeEach
    void setup() {
        listMerge = new LinkedListMerge();
    }

    @Nested
    class ResultIsNull {
        @Test
        void forTwoEmptyLists() {
            LinkedListMerge.IntListNode result = listMerge.performIfNonNull(null, null);
            assertThat(result).isNull();
        }
    }

    @Nested
    class ResultIsUnMergedList {
        @Test
        void forEmptyFirstListAndNonEmptySecondList() {
            LinkedListMerge.IntListNode secondEl3 = new LinkedListMerge.IntListNode(58);
            LinkedListMerge.IntListNode secondEl2 = new LinkedListMerge.IntListNode(0, secondEl3);
            LinkedListMerge.IntListNode secondEl1 = new LinkedListMerge.IntListNode(-10, secondEl2);
            LinkedListMerge.IntListNode result = listMerge.performIfNonNull(null, secondEl1);
            assertThat(result).isNotNull();
            assertThat(result).isSameAs(secondEl1);
            assertThat(result.next).isNotNull();
            assertThat(result.next).isSameAs(secondEl2);
            assertThat(result.next.next).isNotNull();
            assertThat(result.next.next).isSameAs(secondEl3);
            assertThat(result.next.next.next).isNull();
        }

        @Test
        void forNonEmptyFirstListAndEmptySecondList() {
            LinkedListMerge.IntListNode firstEl3 = new LinkedListMerge.IntListNode(1);
            LinkedListMerge.IntListNode firstEl2 = new LinkedListMerge.IntListNode(-27, firstEl3);
            LinkedListMerge.IntListNode firstEl1 = new LinkedListMerge.IntListNode(-61, firstEl2);
            LinkedListMerge.IntListNode result = listMerge.performIfNonNull(firstEl1, null);
            assertThat(result).isNotNull();
            assertThat(result).isSameAs(firstEl1);
            assertThat(result.next).isNotNull();
            assertThat(result.next).isSameAs(firstEl2);
            assertThat(result.next.next).isNotNull();
            assertThat(result.next.next).isSameAs(firstEl3);
            assertThat(result.next.next.next).isNull();
        }
    }

    @Nested
    class ResultIsMergedList {
        @Test
        void forTwoNonEmptyListsOfSameLength() {
            LinkedListMerge.IntListNode firstEl3 = new LinkedListMerge.IntListNode(4);
            LinkedListMerge.IntListNode firstEl2 = new LinkedListMerge.IntListNode(2, firstEl3);
            LinkedListMerge.IntListNode firstEl1 = new LinkedListMerge.IntListNode(1, firstEl2);
            LinkedListMerge.IntListNode secondEl3 = new LinkedListMerge.IntListNode(4);
            LinkedListMerge.IntListNode secondEl2 = new LinkedListMerge.IntListNode(3, secondEl3);
            LinkedListMerge.IntListNode secondEl1 = new LinkedListMerge.IntListNode(1, secondEl2);
            LinkedListMerge.IntListNode result = listMerge.performIfNonNull(firstEl1, secondEl1);
            assertThat(result).isNotNull();
            assertThat(result).isSameAs(firstEl1);
            assertThat(result.next).isNotNull();
            assertThat(result.next).isSameAs(secondEl1);
            assertThat(result.next.next).isNotNull();
            assertThat(result.next.next).isSameAs(firstEl2);
            assertThat(result.next.next.next).isNotNull();
            assertThat(result.next.next.next).isSameAs(secondEl2);
            assertThat(result.next.next.next.next).isNotNull();
            assertThat(result.next.next.next.next).isSameAs(firstEl3);
            assertThat(result.next.next.next.next.next).isNotNull();
            assertThat(result.next.next.next.next.next).isSameAs(secondEl3);
        }

        @Test
        void forNonEmptyFirstListLongerThanNonEmptySecond() {
            LinkedListMerge.IntListNode firstEl4 = new LinkedListMerge.IntListNode(54);
            LinkedListMerge.IntListNode firstEl3 = new LinkedListMerge.IntListNode(41, firstEl4);
            LinkedListMerge.IntListNode firstEl2 = new LinkedListMerge.IntListNode(26, firstEl3);
            LinkedListMerge.IntListNode firstEl1 = new LinkedListMerge.IntListNode(19, firstEl2);
            LinkedListMerge.IntListNode secondEl3 = new LinkedListMerge.IntListNode(47);
            LinkedListMerge.IntListNode secondEl2 = new LinkedListMerge.IntListNode(33, secondEl3);
            LinkedListMerge.IntListNode secondEl1 = new LinkedListMerge.IntListNode(16, secondEl2);
            LinkedListMerge.IntListNode result = listMerge.performIfNonNull(firstEl1, secondEl1);
            assertThat(result).isNotNull();
            assertThat(result).isSameAs(secondEl1);
            assertThat(result.next).isNotNull();
            assertThat(result.next).isSameAs(firstEl1);
            assertThat(result.next.next).isNotNull();
            assertThat(result.next.next).isSameAs(firstEl2);
            assertThat(result.next.next.next).isNotNull();
            assertThat(result.next.next.next).isSameAs(secondEl2);
            assertThat(result.next.next.next.next).isNotNull();
            assertThat(result.next.next.next.next).isSameAs(firstEl3);
            assertThat(result.next.next.next.next.next).isNotNull();
            assertThat(result.next.next.next.next.next).isSameAs(secondEl3);
            assertThat(result.next.next.next.next.next.next).isNotNull();
            assertThat(result.next.next.next.next.next.next).isSameAs(firstEl4);
        }

        @Test
        void forNonEmptyFirstListShorterThanNonEmptySecond() {
            LinkedListMerge.IntListNode firstEl3 = new LinkedListMerge.IntListNode(88);
            LinkedListMerge.IntListNode firstEl2 = new LinkedListMerge.IntListNode(6, firstEl3);
            LinkedListMerge.IntListNode firstEl1 = new LinkedListMerge.IntListNode(0, firstEl2);
            LinkedListMerge.IntListNode secondEl4 = new LinkedListMerge.IntListNode(0);
            LinkedListMerge.IntListNode secondEl3 = new LinkedListMerge.IntListNode(-7, secondEl4);
            LinkedListMerge.IntListNode secondEl2 = new LinkedListMerge.IntListNode(-33, secondEl3);
            LinkedListMerge.IntListNode secondEl1 = new LinkedListMerge.IntListNode(-66, secondEl2);
            LinkedListMerge.IntListNode result = listMerge.performIfNonNull(firstEl1, secondEl1);
            assertThat(result).isNotNull();
            assertThat(result).isSameAs(secondEl1);
            assertThat(result.next).isNotNull();
            assertThat(result.next).isSameAs(secondEl2);
            assertThat(result.next.next).isNotNull();
            assertThat(result.next.next).isSameAs(secondEl3);
            assertThat(result.next.next.next).isNotNull();
            assertThat(result.next.next.next).isSameAs(firstEl1);
            assertThat(result.next.next.next.next).isNotNull();
            assertThat(result.next.next.next.next).isSameAs(secondEl4);
            assertThat(result.next.next.next.next.next).isNotNull();
            assertThat(result.next.next.next.next.next).isSameAs(firstEl2);
            assertThat(result.next.next.next.next.next.next).isNotNull();
            assertThat(result.next.next.next.next.next.next).isSameAs(firstEl3);
        }
    }
}
