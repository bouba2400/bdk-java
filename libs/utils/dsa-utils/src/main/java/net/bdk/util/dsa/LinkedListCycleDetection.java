package net.bdk.util.dsa;

import java.util.LinkedList;
import org.checkerframework.checker.nullness.qual.Nullable;

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
        } while (j != null && i != null);

        return res;
    }

    public static class IntListNode {
        int val;

        @Nullable IntListNode next;

        public IntListNode(int val) {
            this.val = val;
        }

        public IntListNode(int val, IntListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
