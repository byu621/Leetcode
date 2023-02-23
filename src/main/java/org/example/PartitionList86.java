package org.example;

import org.example.helper.ListNode;

public class PartitionList86 {
    public ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode(0);
        ListNode right = new ListNode(0);
        ListNode dummy = new ListNode(0, left);
        ListNode dummyR = new ListNode(0, right);
        ListNode current = head;
        while (current != null) {
            if (current.val < x) {
                left.next = current;
                left = current;
            } else {
                right.next = current;
                right = current;
            }
            current = current.next;
        }
        right.next = null;
        left.next = dummyR.next.next;
        return dummy.next.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head2 = new ListNode(4);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(2);
        ListNode head5 = new ListNode(5);
        ListNode head6 = new ListNode(2);
        head.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head5;
        head5.next = head6;
        new PartitionList86().partition(head, 3);
    }
}
