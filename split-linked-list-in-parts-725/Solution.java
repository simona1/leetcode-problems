
/**
 * LeetCode problem # 725, 'Split Linked List in Parts'
 * https://leetcode.com/problems/split-linked-list-in-parts/
 */

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] res = new ListNode[k];
        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            temp = temp.next;
            ++count;
        }

        int num = count / k;
        int c = count % k;
        ListNode fast = head;

        for (int i = 0; i < k; ++i) {
            int n = c > 0 ? num : num - 1;
            while (fast != null && n > 0) {
                fast = fast.next;
                --n;
            }
            --c;
            if (fast != null) {
                ListNode next = fast.next;
                fast.next = null;
                res[i] = head;
                head = next;
                fast = next;
            }

        }
        return res;
    }
}