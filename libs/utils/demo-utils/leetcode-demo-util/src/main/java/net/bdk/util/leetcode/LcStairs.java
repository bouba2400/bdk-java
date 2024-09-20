package net.bdk.util.leetcode;

public class LcStairs {
    private final int n;

    public LcStairs(int steps) {
        n = steps;
    }

    public int steps() {
        return n;
    }

    public int getOneAndTwoStepClimbingWays() {
        if (n < 0) {
            return -1;
        }

        if (n < 3) {
            return n;
        }

        int secondPrevious = 1;
        int previous = 2;
        int current = previous + secondPrevious;
        for (int i = 4; i <= n; i++) {
            secondPrevious = previous;
            previous = current;
            current = previous + secondPrevious;
        }

        return current;
    }
}
