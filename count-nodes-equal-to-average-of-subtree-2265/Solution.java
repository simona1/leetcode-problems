/**
 * LeetCode problem # 2265, 'Count Nodes Equal to Average of Subtree'
 * https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree
 */

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public int averageOfSubtree(TreeNode root) {
        int[] res = new int[1];
        postorderTraverse(root, res);
        return res[0];
    }

    private int[] postorderTraverse(TreeNode root, int[] count) {
        if (root == null) {
            return new int[] { 0, 0 };
        }
        int[] left = postorderTraverse(root.left, count);
        int[] right = postorderTraverse(root.right, count);

        int[] total = new int[] { left[0] + right[0] + 1, left[1] + right[1] + root.val };
        if (total[1] / total[0] == root.val) {
            ++count[0];
        }
        return total;
    }
}