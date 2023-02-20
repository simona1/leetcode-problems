/*
 * LeetCode problem # 104, 'Maximum Depth of Binary Tree'
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * 
 * Given the root of a binary tree, return its maximum depth.
 * A binary tree's maximum depth is the number of nodes along the longest path 
 * from the root node down to the farthest leaf node.
 * 
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public int maxDepth(TreeNode root) {
        int res = 0;
        if (root != null) {
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
        return res;
    }
}