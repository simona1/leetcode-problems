
/**
 * LeetCode problem # 1644, 'Lowest Common Ancestor of a Binary Tree II'
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-ii/
 */

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode res = LCA(root, p, q);
        if (res == p) {
            return traverse(p, q) ? p : null;
        }
        if (res == q) {
            return traverse(q, p) ? q : null;
        }
        return res;
    }

    private TreeNode LCA(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null || node == p || node == q) {
            return node;
        }

        TreeNode left = LCA(node.left, p, q);
        TreeNode right = LCA(node.right, p, q);
        if (left != null && right != null) {
            return node;
        }
        if (left != null) {
            return left;
        }
        return right;
    }

    private boolean traverse(TreeNode node, TreeNode target) {
        if (node == target) {
            return true;
        }

        if (node == null) {
            return false;
        }
        return traverse(node.left, target) || traverse(node.right, target);
    }

}