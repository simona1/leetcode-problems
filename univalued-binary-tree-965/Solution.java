/**
 * LeetCode problem # 965, 'Univalued Binary Tree'
 * https://leetcode.com/problems/univalued-binary-tree
 */

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */

class Solution {
  public boolean isUnivalTree(TreeNode root) {
    boolean isLeftUniVal = (root.left == null || (root.val == root.left.val && isUnivalTree(root.left)));
    boolean isRightUnival = (root.right == null || (root.val == root.right.val && isUnivalTree(root.right)));

    return isLeftUniVal && isRightUnival;

  }
}
