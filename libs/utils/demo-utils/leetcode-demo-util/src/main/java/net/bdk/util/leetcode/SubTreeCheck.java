package net.bdk.util.leetcode;

import org.checkerframework.checker.nullness.qual.Nullable;

public class SubTreeCheck {
    public boolean perform(@Nullable IntBinaryTreeNode root, @Nullable IntBinaryTreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }

        if (subRoot == null) {
            return true;
        }

        if (root == null) {
            return false;
        }

        boolean areSimilar = areTreesSimilar(root, subRoot);
        if (areSimilar) {
            return true;
        }

        return perform(root.left, subRoot) || perform(root.right, subRoot);
    }

    private static boolean areTreesSimilar(@Nullable IntBinaryTreeNode firstRoot, @Nullable IntBinaryTreeNode secondRoot) {
        if (firstRoot == null && secondRoot == null) {
            return true;
        }

        if (firstRoot == null || secondRoot == null) {
            return false;
        }

        if (firstRoot.val != secondRoot.val) {
            return false;
        }

        return areTreesSimilar(firstRoot.left, secondRoot.left) && areTreesSimilar(firstRoot.right, secondRoot.right);
    }

    public static class IntBinaryTreeNode {
        int val;
        @Nullable IntBinaryTreeNode left;
        @Nullable IntBinaryTreeNode right;

//        IntBinaryTreeNode() {}

        IntBinaryTreeNode(int val) {
            this.val = val;
        }

        IntBinaryTreeNode(int val, @Nullable IntBinaryTreeNode left, @Nullable IntBinaryTreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
