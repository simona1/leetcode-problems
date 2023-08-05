/**
 * LeetCode problem # 86, 'Partition List'
 * https://leetcode.com/problems/partition-list/
 */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */

class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode beforeX = new ListNode(0);
        ListNode headB = beforeX;
        ListNode afterX = new ListNode(0);
        ListNode headA = afterX;

        while (head != null) {
            if (head.val < x) {
                headB.next = head;
                headB = headB.next;
            } else {
                headA.next = head;
                headA = headA.next;
            }
            head = head.next;
        }
        headA.next = null;
        headB.next = afterX.next;
        return beforeX.next;
    }
}