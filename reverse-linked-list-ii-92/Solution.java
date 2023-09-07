/**
 * LeetCode problem # 92, 'Reverse Linked List II'
 * https://leetcode.com/problems/reverse-linked-list-ii
 */

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode curr = head;
        ListNode prev = null;

        int index = 1;
        while (index < left) {
            prev = curr;
            curr = curr.next;
            ++index;
        }

        ListNode start = curr;
        ListNode end = null;

        while (index <= right) {
            ListNode next = curr.next;
            curr.next = end;
            end = curr;
            curr = next;
            ++index;
        }

        start.next = curr;

        if (prev != null) {
            prev.next = end;
        } else {
            head = end;
        }
        return head;
    }

}