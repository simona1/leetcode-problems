/*
 * LeetCode problem # 23, 'Merge k Sorted Lists'
 * https://leetcode.com/problems/merge-k-sorted-lists
 */

import java.util.*;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        int k = lists.length;
        ListNode dummy = new ListNode(0);
        ListNode last = dummy;

        PriorityQueue<ListNode> pq = new PriorityQueue<>(k, (a, b) -> a.val - b.val);

        for (ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }

        while (!pq.isEmpty()) {
            last.next = pq.remove();
            last = last.next;

            if (last.next != null) {
                pq.add(last.next);
            }
        }
        return dummy.next;
    }
}
