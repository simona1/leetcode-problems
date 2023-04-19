/**
 * LeetCode problem # 1372, 'Longest ZigZag Path in a Binary Tree'
 * https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree
 */

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    int pathLength = 0;

    public int longestZigZag(TreeNode root) {
        traverseZigzag(root, false, 0);
        traverseZigzag(root, true, 0);
        return pathLength;
    }

    private void traverseZigzag(TreeNode node, boolean isLeft, int steps) {
        if (node == null) {
            return;
        }

        pathLength = Math.max(pathLength, steps);

        if (isLeft) {
            traverseZigzag(node.left, false, steps + 1);
            traverseZigzag(node.right, true, 1);
        } else {
            traverseZigzag(node.left, false, 1);
            traverseZigzag(node.right, true, steps + 1);
        }
    }
}