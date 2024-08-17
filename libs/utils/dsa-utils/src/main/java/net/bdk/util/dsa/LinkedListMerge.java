package net.bdk.util.dsa;

import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.LinkedList;

public class LinkedListMerge {
    public boolean perform(LinkedList<Object> linkedList) {
        throw new UnsupportedOperationException();
    }

    public @Nullable IntListNode perform(IntListNode headOne, IntListNode headTwo) {
        IntListNode headMerged = headOne.val <= headTwo.val ? headOne : headTwo;
        IntListNode i = headOne;
        IntListNode j = headTwo;
        IntListNode k = null;

        while (i != null && j != null) {
            if (i.val <= j.val) {
                if (k != null) {
                    k.next = i;
                }
                k = i;
                i = i.next;
            } else {
                if (k != null) {
                    k.next = j;
                }
                k = j;
                j = j.next;
            }
        }

        if (i != null) {
            if (k != null) {
                k.next = i;
            }
        } else {
            if (k != null) {
                k.next = j;
            }
        }

        return headMerged;
    }

    public @Nullable IntListNode performIfNonNull(@Nullable IntListNode headOne, @Nullable IntListNode headTwo) {
        if (headOne == null && headTwo == null) {
            return null;
        } else if (headOne == null) {
            return headTwo;
        } else if (headTwo == null) {
            return headOne;
        } else {
            return perform(headOne, headTwo);
        }
    }

    public static class IntListNode {
        int val;
        @Nullable
        IntListNode next;
        public IntListNode(int val) {
            this.val = val;
        }
        public IntListNode(int val, IntListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
