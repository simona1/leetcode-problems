
/**
 * LeetCode problem # 2130, 'Maximum Twin Sum of a Linked List'
 * https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/
 */

import java.util.*;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    // with extra space
    public int pairSum1(ListNode head) {
        List<Integer> values = new ArrayList<>();

        ListNode node = head;

        while (node != null) {
            values.add(node.val);
            node = node.next;
        }

        int res = 0;
        int i = 0;
        int j = values.size() - 1;

        while (i < j) {
            res = Math.max(res, values.get(i) + values.get(j));
            ++i;
            --j;
        }
        return res;
    }

    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode prevNode = null;
        ListNode nextNode = null;

        while (slow != null) {
            nextNode = slow.next;
            slow.next = prevNode;
            prevNode = slow;
            slow = nextNode;
        }

        ListNode node = head;
        int res = 0;
        while (prevNode != null) {
            res = Math.max(res, prevNode.val + node.val);
            node = node.next;
            prevNode = prevNode.next;
        }

        return res;
    }
}