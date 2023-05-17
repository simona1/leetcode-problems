/**
 * LeetCode problem # 2130, 'Maximum Twin Sum of a Linked List'
 * https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/
 */

import java.util.*;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int pairSum(ListNode head) {
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
}