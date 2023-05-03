/**
 * LeetCode problem # 2, 'Add Two Numbers'
 * https://leetcode.com/problems/add-two-numbers/
 */

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode n, ListNode m) {
        ListNode dummy = new ListNode(0);

        ListNode curr = dummy;
        int carry = 0;

        while (n != null || m != null) {
            int a = (n != null) ? n.val : 0;
            int b = (m != null) ? m.val : 0;
            int sum = a + b + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (n != null) {
                n = n.next;
            }
            if (m != null) {
                m = m.next;
            }
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummy.next;
    }
}
