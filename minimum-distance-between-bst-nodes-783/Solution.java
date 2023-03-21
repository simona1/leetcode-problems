
/**
 * LeetCode problem # 783, 'Minimum Distance Between BST Nodes'
 * https://leetcode.com/problems/minimum-distance-between-bst-nodes/
 */

import java.util.Stack;

//  Definition for a binary tree node.
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
    public int minDiffInBST(TreeNode root) {
        int res = Integer.MAX_VALUE;
        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root;
        TreeNode prev = null;

        while (curr != null || !stack.empty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                if (prev != null) {
                    res = Math.min(res, curr.val - prev.val);
                }
                prev = curr;
                curr = curr.right;
            }
        }
        return res;
    }
}