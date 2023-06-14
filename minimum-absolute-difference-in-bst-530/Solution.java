
/**
 * LeetCode problem # 530, 'Minimum Absolute Difference in BST'
 * https://leetcode.com/problems/minimum-absolute-difference-in-bst/
 */

import java.util.*;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */

class Solution {
    public int getMinimumDifference(TreeNode root) {
        int res = Integer.MAX_VALUE;
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;
        TreeNode prev = null;
        while (curr != null || !st.empty()) {
            if (curr != null) {
                st.push(curr);
                curr = curr.left;
            } else {
                curr = st.pop();
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
