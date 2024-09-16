package net.bdk.util.leetcode;

public class LcInteger {
    private int n;

    public LcInteger(int integer) {
        n = integer;
    }

    public int asInt() {
        return n;
    }

    public int getHammingWeight() {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int ithBitMovedToEndWithPriorBitsPreserved = n >> (31 - i);
            int ithBitMovedToEndWithPriorBitsCleared = ithBitMovedToEndWithPriorBitsPreserved & 1;
            if (ithBitMovedToEndWithPriorBitsCleared == 1) {
                res += 1;
            }
        }
        return res;
    }
}
