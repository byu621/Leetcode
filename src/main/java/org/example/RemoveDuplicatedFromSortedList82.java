package org.example;

import org.example.helper.ListNode;

public class RemoveDuplicatedFromSortedList82 {
    /**
     * Read the current value
     * It's a new value
     * Check the next value
     * If it's the same loop forward, else set prevNode
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode previousNode = dummy;
        ListNode current = head;
        while (current != null) { // Current is new.
            int currentValue = current.val;
            int nextValue = current.next != null ? current.next.val : -101;
            if (currentValue == nextValue) {
                while (current != null && current.val == currentValue) {
                    current = current.next;
                }
                previousNode.next = current;
            } else {
                previousNode = current;
                current = current.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(3);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        new RemoveDuplicatedFromSortedList82().deleteDuplicates(head);
    }
}
