/**
 * LeetCode problem # 958 , 'Check Completeness of a Binary Tree'
 * https://leetcode.com/problems/check-completeness-of-a-binary-tree
 */

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */

class Solution {
    public boolean isCompleteTree(TreeNode root) {
        int n = getNodeCount(root);
        return hasExpectedNumber(root, 0, n);
    }

    private int getNodeCount(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + getNodeCount(root.left) + getNodeCount(root.right);
    }

    private boolean hasExpectedNumber(TreeNode node, int index, int exp) {
        if (node == null) {
            return true;
        }

        if (index >= exp) {
            return false;
        }
        // index * 2 + 1 - left; index * 2 + 2 - right
        // level 0: 0
        // level 1: left 0 * 2 + 1 = 1; right 0 * 2 + 2 = 2
        // level 2: left 1 * 2 + 1 = 3; right 1 * 2 + 2 = 4
        return hasExpectedNumber(node.left, index * 2 + 1, exp) && hasExpectedNumber(node.right, index * 2 + 2, exp);
    }
}
