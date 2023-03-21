/**
 * LeetCode problem # 101, 'Symmetric Tree'
 * https://leetcode.com/problems/symmetric-tree
 */

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetricImpl(root.right, root.left);
    }

    private boolean isSymmetricImpl(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }
        return a.val == b.val && isSymmetricImpl(a.right, b.left) && isSymmetricImpl(a.left, b.right);
    }
}
