package net.bdk.util.dsa;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumOperator {
    public int[] perform(int[] nums, int target) {
        int[] res = new int[]{-1 , -1};
        Map<Integer, Integer> index = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            Integer complementIndex = index.get(complement);
            if (complementIndex != null) {
                res[0] = complementIndex;
                res[1] = i;
                break;
            }
            index.put(nums[i], i);
        }

        return res;
    }
}
