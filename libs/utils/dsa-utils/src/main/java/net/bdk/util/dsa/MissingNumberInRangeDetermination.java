package net.bdk.util.dsa;

public class MissingNumberInRangeDetermination {
    public int perform(int[] nums) {
        int res = -1;

        if (nums.length > 0) {
            int rangeLimit = nums.length;
            int rangeSum = rangeLimit * (rangeLimit + 1) / 2;
            int currentSum = 0;

            for (int num : nums) {
                currentSum += num;
            }

            res = rangeSum - currentSum;
        }

        return res;
    }
}
