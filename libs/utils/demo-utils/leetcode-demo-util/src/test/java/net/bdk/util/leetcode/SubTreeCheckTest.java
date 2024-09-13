package net.bdk.util.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SubTreeCheckTest {
    private SubTreeCheck testee;

    @BeforeEach
    void setup() {
        testee = new SubTreeCheck();
    }

    @Nested
    class ResultIsFalse {
        @Test
        void forNonNullNeedleAndNullHaystack() {
            SubTreeCheck.IntBinaryTreeNode root2 = new SubTreeCheck.IntBinaryTreeNode(-1);
            boolean actual = testee.perform(null, root2);
            assertThat(actual).isFalse();
        }

        @Test
        void forTwoLevelNeedleContainedInMiddleOfHaystack() {
            SubTreeCheck.IntBinaryTreeNode firstGen2Left = new SubTreeCheck.IntBinaryTreeNode(1);
            SubTreeCheck.IntBinaryTreeNode firstGen2Right = new SubTreeCheck.IntBinaryTreeNode(2);
            SubTreeCheck.IntBinaryTreeNode root2 = new SubTreeCheck.IntBinaryTreeNode(4, firstGen2Left, firstGen2Right);

            SubTreeCheck.IntBinaryTreeNode thirdGen1Left = new SubTreeCheck.IntBinaryTreeNode(0);
            SubTreeCheck.IntBinaryTreeNode secondGen1Left = new SubTreeCheck.IntBinaryTreeNode(1);
            SubTreeCheck.IntBinaryTreeNode secondGen1Right = new SubTreeCheck.IntBinaryTreeNode(2, thirdGen1Left, null);
            SubTreeCheck.IntBinaryTreeNode firstGen1Left = new SubTreeCheck.IntBinaryTreeNode(4, secondGen1Left, secondGen1Right);
            SubTreeCheck.IntBinaryTreeNode firstGen1Right = new SubTreeCheck.IntBinaryTreeNode(5);
            SubTreeCheck.IntBinaryTreeNode root1 = new SubTreeCheck.IntBinaryTreeNode(3, firstGen1Left, firstGen1Right);

            boolean actual = testee.perform(root1, root2);
            assertThat(actual).isFalse();
        }
    }

    @Nested
    class ResultIsTrue {
        @Test
        void forNullNeedleAndHaystack() {
            boolean actual = testee.perform(null, null);
            assertThat(actual).isTrue();
        }

        @Test
        void forNullNeedleAndNonNullHaystack() {
            SubTreeCheck.IntBinaryTreeNode root1 = new SubTreeCheck.IntBinaryTreeNode(1);
            boolean actual = testee.perform(root1, null);
            assertThat(actual).isTrue();
        }

        @Test
        void forSingleLevelNeedleContainedAtBottomOfTwoLevelHaystack() {
            SubTreeCheck.IntBinaryTreeNode root2 = new SubTreeCheck.IntBinaryTreeNode(1);

            SubTreeCheck.IntBinaryTreeNode firstGen1Left = new SubTreeCheck.IntBinaryTreeNode(1);
            SubTreeCheck.IntBinaryTreeNode root1 = new SubTreeCheck.IntBinaryTreeNode(1, firstGen1Left, null);

            boolean actual = testee.perform(root1, root2);
            assertThat(actual).isTrue();
        }

        @Test
        void forTwoLevelNeedleContainedAtBottomOfHaystack() {
            SubTreeCheck.IntBinaryTreeNode firstGen2Left = new SubTreeCheck.IntBinaryTreeNode(1);
            SubTreeCheck.IntBinaryTreeNode firstGen2Right = new SubTreeCheck.IntBinaryTreeNode(2);
            SubTreeCheck.IntBinaryTreeNode root2 = new SubTreeCheck.IntBinaryTreeNode(4, firstGen2Left, firstGen2Right);

            SubTreeCheck.IntBinaryTreeNode secondGen1Left = new SubTreeCheck.IntBinaryTreeNode(1);
            SubTreeCheck.IntBinaryTreeNode secondGen1Right = new SubTreeCheck.IntBinaryTreeNode(2);
            SubTreeCheck.IntBinaryTreeNode firstGen1Left = new SubTreeCheck.IntBinaryTreeNode(4, secondGen1Left, secondGen1Right);
            SubTreeCheck.IntBinaryTreeNode firstGen1Right = new SubTreeCheck.IntBinaryTreeNode(5);
            SubTreeCheck.IntBinaryTreeNode root1 = new SubTreeCheck.IntBinaryTreeNode(3, firstGen1Left, firstGen1Right);

            boolean actual = testee.perform(root1, root2);
            assertThat(actual).isTrue();
        }

        @Test
        void forThreeLevelNeedleContainedAtBottomOfHaystackAndPartiallySimilarSibling() {
            SubTreeCheck.IntBinaryTreeNode secondGen2Right = new SubTreeCheck.IntBinaryTreeNode(69);
            SubTreeCheck.IntBinaryTreeNode firstGen2Left = new SubTreeCheck.IntBinaryTreeNode(4);
            SubTreeCheck.IntBinaryTreeNode firstGen2Right = new SubTreeCheck.IntBinaryTreeNode(5, null, secondGen2Right);
            SubTreeCheck.IntBinaryTreeNode root2 = new SubTreeCheck.IntBinaryTreeNode(2, firstGen2Left, firstGen2Right);

            SubTreeCheck.IntBinaryTreeNode thirdGen1Right = new SubTreeCheck.IntBinaryTreeNode(69);
            SubTreeCheck.IntBinaryTreeNode secondGen1Left = new SubTreeCheck.IntBinaryTreeNode(4);
            SubTreeCheck.IntBinaryTreeNode secondGen1Right = new SubTreeCheck.IntBinaryTreeNode(5, null, thirdGen1Right);
            SubTreeCheck.IntBinaryTreeNode firstGen1Left = new SubTreeCheck.IntBinaryTreeNode(2, secondGen1Left, secondGen1Right);
            SubTreeCheck.IntBinaryTreeNode firstGen1Right = new SubTreeCheck.IntBinaryTreeNode(2);
            SubTreeCheck.IntBinaryTreeNode root1 = new SubTreeCheck.IntBinaryTreeNode(1, firstGen1Left, firstGen1Right);

            boolean actual = testee.perform(root1, root2);
            assertThat(actual).isTrue();
        }
    }
}
