/**
 * LeetCode problem # 1214, 'Two Sum BSTs'
 * https://leetcode.com/problems/two-sum-bsts
 */

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        return traverse(root1, root2, target);
    }

    private boolean traverse(TreeNode root1, TreeNode root2, int target) {
        if (root1 == null) {
            return false;
        }
        if (binarySearch(root2, target - root1.val)) {
            return true;
        }
        return traverse(root1.left, root2, target) || traverse(root1.right, root2, target);
    }

    private boolean binarySearch(TreeNode node, int value) {
        if (node == null) {
            return false;
        }
        if (node.val == value) {
            return true;
        }
        if (node.val > value) {
            return binarySearch(node.left, value);
        }
        return binarySearch(node.right, value);
    }
}
