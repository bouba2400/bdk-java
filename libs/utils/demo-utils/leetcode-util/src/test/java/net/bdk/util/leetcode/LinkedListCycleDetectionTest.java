package net.bdk.util.leetcode;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class LinkedListCycleDetectionTest {
    private LinkedListCycleDetection cycleDetection;

    @BeforeEach
    void setup() {
        cycleDetection = new LinkedListCycleDetection();
    }

    @Nested
    class ResultIsFalse {
        @Test
        void forListOfSameValuesWithLastElementNotPointingBackToAnother() {
            LinkedListCycleDetection.IntListNode el1 = new LinkedListCycleDetection.IntListNode(0);
            LinkedListCycleDetection.IntListNode el2 = new LinkedListCycleDetection.IntListNode(0);
            LinkedListCycleDetection.IntListNode el3 = new LinkedListCycleDetection.IntListNode(0);
            el1.next = el2;
            el2.next = el3;
            boolean cycleDetected = cycleDetection.perform(el1);
            assertThat(cycleDetected).isFalse();
        }

        @Test
        void forListOfDifferentValuesWithLastElementNotPointingBackToAnother() {
            LinkedListCycleDetection.IntListNode el1 = new LinkedListCycleDetection.IntListNode(-47356);
            LinkedListCycleDetection.IntListNode el2 = new LinkedListCycleDetection.IntListNode(66);
            LinkedListCycleDetection.IntListNode el3 = new LinkedListCycleDetection.IntListNode(274533897);
            LinkedListCycleDetection.IntListNode el4 = new LinkedListCycleDetection.IntListNode(-9752147);
            el1.next = el2;
            el2.next = el3;
            el3.next = el4;
            boolean cycleDetected = cycleDetection.perform(el1);
            assertThat(cycleDetected).isFalse();
        }

        @Test
        void forListWithOneElementNotPointingBackToItself() {
            LinkedListCycleDetection.IntListNode el1 = new LinkedListCycleDetection.IntListNode(-1);
            boolean cycleDetected = cycleDetection.perform(el1);
            assertThat(cycleDetected).isFalse();
        }
    }

    @Nested
    class ResultIsTrue {
        @Test
        void forListWithLastElementPointingBackToFirstElement() {
            LinkedListCycleDetection.IntListNode el1 = new LinkedListCycleDetection.IntListNode(-44);
            LinkedListCycleDetection.IntListNode el2 = new LinkedListCycleDetection.IntListNode(-8759);
            LinkedListCycleDetection.IntListNode el3 = new LinkedListCycleDetection.IntListNode(-6584269);
            LinkedListCycleDetection.IntListNode el4 = new LinkedListCycleDetection.IntListNode(-50287);
            el1.next = el2;
            el2.next = el3;
            el3.next = el4;
            el4.next = el1;
            boolean cycleDetected = cycleDetection.perform(el1);
            assertThat(cycleDetected).isTrue();
        }

        @Test
        void forListWithLastElementPointingBackToThirdElement() {
            LinkedListCycleDetection.IntListNode el1 = new LinkedListCycleDetection.IntListNode(18);
            LinkedListCycleDetection.IntListNode el2 = new LinkedListCycleDetection.IntListNode(571987);
            LinkedListCycleDetection.IntListNode el3 = new LinkedListCycleDetection.IntListNode(100058);
            LinkedListCycleDetection.IntListNode el4 = new LinkedListCycleDetection.IntListNode(2540);
            LinkedListCycleDetection.IntListNode el5 = new LinkedListCycleDetection.IntListNode(-3657);
            LinkedListCycleDetection.IntListNode el6 = new LinkedListCycleDetection.IntListNode(-584);
            el1.next = el2;
            el2.next = el3;
            el3.next = el4;
            el4.next = el5;
            el5.next = el6;
            el6.next = el3;
            boolean cycleDetected = cycleDetection.perform(el1);
            assertThat(cycleDetected).isTrue();
        }

        @Test
        void forListWithOneElementPointingBackToItself() {
            LinkedListCycleDetection.IntListNode el1 = new LinkedListCycleDetection.IntListNode(-726854);
            el1.next = el1;
            boolean cycleDetected = cycleDetection.perform(el1);
            assertThat(cycleDetected).isTrue();
        }
    }
}
