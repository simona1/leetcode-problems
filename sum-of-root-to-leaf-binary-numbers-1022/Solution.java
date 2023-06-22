
/**
 * LeetCode problem # 1022, 'Sum of Root To Leaf Binary Numbers'
 * https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/
 */

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */

class Solution {
    int res = 0;

    public int sumRootToLeaf(TreeNode root) {
        preorder(root, 0);
        return res;
    }

    public void preorder(TreeNode r, int curr) {
        if (r != null) {
            curr = (curr << 1) | r.val;

            if (r.left == null && r.right == null) {
                res += curr;
            }
            preorder(r.left, curr);
            preorder(r.right, curr);
        }
    }

}
