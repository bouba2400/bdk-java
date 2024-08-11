package net.bdk.util.dsa;

import java.util.LinkedList;

public class LinkedListCycleDetection {
    public boolean perform(LinkedList<Object> linkedList) {
        throw new UnsupportedOperationException();
    }

    public boolean perform(IntListNode head) {
        boolean res = false;
        IntListNode i = head;
        IntListNode j = head;

        do {
            i = i.next;
            j = j.next;
            if (j != null) {
                j = j.next;
                if (i == j) {
                    res = true;
                    break;
                }
            }
        } while (j != null);

        return res;
    }

    public static class IntListNode {
        int val;
        IntListNode next;
        public IntListNode(int val) {
            this.val = val;
        }
    }
}
