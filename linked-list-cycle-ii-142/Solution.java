/*
 * LeetCode problem # 142, 'Linked List Cycle II'
 * https://leetcode.com/problems/linked-list-cycle-ii
 */

/**
 * Definition for singly-linked list.
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Solution {
    private ListNode findIntersectingNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return slow;
            }
        }
        return null;
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode intersection = findIntersectingNode(head);
        if (intersection == null) {
            return null;
        }

        ListNode ptr1 = head;
        ListNode ptr2 = intersection;

        while (ptr1 != ptr2) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return ptr1;
    }
}
