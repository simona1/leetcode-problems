
/**
 * LeetCode problem # 445, 'Add Two Numbers II'
 * https://leetcode.com/problems/add-two-numbers-ii/
 */

import java.util.*;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        ListNode n1 = l1;
        ListNode n2 = l2;
        while (n1 != null) {
            s1.push(n1.val);
            n1 = n1.next;
        }
        while (n2 != null) {
            s2.push(n2.val);
            n2 = n2.next;
        }

        int carry = 0;
        ListNode dummy = null;
        while (!s1.isEmpty() || !s2.isEmpty() || carry != 0) {
            int a = s1.isEmpty() ? 0 : s1.pop();
            int b = s2.isEmpty() ? 0 : s2.pop();
            int currSum = a + b + carry;
            ListNode node = new ListNode(currSum % 10);
            node.next = dummy;
            dummy = node;
            carry = currSum / 10;
        }
        return dummy;
    }
}
