package net.bdk.util.leetcode;

public class BitReversal {
    public int perform(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int ithBitMovedToEndWithPriorBitsPreserved = n >> (31 - i);
            int ithBitMovedToEndWithPriorBitsCleared = ithBitMovedToEndWithPriorBitsPreserved & 1;
            int ithBitMovedToEndMinusIWithPriorBitsCleared = ithBitMovedToEndWithPriorBitsCleared << i;
            res = res | ithBitMovedToEndMinusIWithPriorBitsCleared;
        }
        return res;
    }
}
