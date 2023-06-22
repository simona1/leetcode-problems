/**
 * LeetCode problem # 1474, 'Delete N Nodes After M Nodes of a Linked List'
 * https://leetcode.com/problems/delete-n-nodes-after-m-nodes-of-a-linked-list
 */

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {

    public ListNode deleteNodes(ListNode head, int m, int n) {
        ListNode curr = head;
        ListNode last = head;

        while (curr != null) {
            int mc = m;
            int nc = n;
            while (curr != null && mc != 0) {
                last = curr;
                curr = curr.next;
                --mc;
            }
            while (curr != null && nc != 0) {
                curr = curr.next;
                --nc;
            }
            last.next = curr;
        }
        return head;
    }
}
