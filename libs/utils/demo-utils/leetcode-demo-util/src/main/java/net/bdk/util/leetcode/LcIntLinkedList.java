package net.bdk.util.leetcode;

import org.checkerframework.checker.nullness.qual.Nullable;

public class LcIntLinkedList {
    private final @Nullable IntListNode head;

    public LcIntLinkedList(@Nullable IntListNode head) {
        this.head = head != null ? new IntListNode(head.val, head.next) : null;
    }

    public @Nullable IntListNode head() {
        return head != null ? new IntListNode(head.val, head.next) : null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public LcIntLinkedList reverse() {
        IntListNode newHead = reverse(head);
        return new LcIntLinkedList(newHead);
    }

    private @Nullable IntListNode reverse(@Nullable IntListNode head) {
        if (head == null) {
            return null;
        }
        IntListNode reversedTailHead = reverse(head.next);
        if (reversedTailHead != null) {
            IntListNode reversedTailTail = reversedTailHead;
            while (reversedTailTail.next != null) {
                reversedTailTail = reversedTailTail.next;
            }
            reversedTailTail.next = new IntListNode(head.val);
            return reversedTailHead;
        }
        return new IntListNode(head.val);
    }

    public static class IntListNode {
        private final int val;

        private @Nullable IntListNode next;

        public int val() {
            return val;
        }

        public @Nullable IntListNode next() {
            return next != null ? new IntListNode(next.val, next.next) : null;
        }

        public IntListNode(int val) {
            this(val, null);
        }

        public IntListNode(int val, @Nullable IntListNode next) {
            this.val = val;
            this.next = next != null ? new IntListNode(next.val, next.next) : null;
        }
    }
}
