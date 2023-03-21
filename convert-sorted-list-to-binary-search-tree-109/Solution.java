/**
 * LeetCode problem # 109, 'Convert Sorted List to Binary Search Tree'
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree
 */

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

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */

class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode middle = getMiddleElement(head);
        TreeNode root = new TreeNode(middle.val);

        if (head == middle) {
            return root;
        }

        root.left = sortedListToBST(head);
        root.right = sortedListToBST(middle.next);

        return root;

    }

    private ListNode getMiddleElement(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        ListNode prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (prev != null) {
            prev.next = null;
        }

        return slow;
    }
}
