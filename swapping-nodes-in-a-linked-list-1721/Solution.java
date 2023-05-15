
/**
 * LeetCode problem # 1721, 'Swapping Nodes in a Linked List'
 * https://leetcode.com/problems/swapping-nodes-in-a-linked-list/
 */

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode curr = head;
        int length = 0;
        while (curr != null) {
            ++length;
            curr = curr.next;
        }
        ListNode front = head;
        for (int i = 1; i < k; ++i) {
            front = front.next;
        }
        ListNode end = head;
        for (int i = 1; i <= length - k; ++i) {
            end = end.next;
        }
        int tmp = front.val;
        front.val = end.val;
        end.val = tmp;
        return head;
    }
}