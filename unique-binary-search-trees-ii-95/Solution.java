
/**
 * LeetCode problem # 95, 'Unique Binary Search Trees II'
 * https://leetcode.com/problems/unique-binary-search-trees-ii/
 */

import java.util.*;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public List<TreeNode> generateTrees(int n) {
        return solve(1, n);
    }

    private List<TreeNode> solve(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
            return res;
        }

        for (int i = start; i <= end; ++i) {
            List<TreeNode> left = solve(start, i - 1);
            List<TreeNode> right = solve(i + 1, end);

            for (TreeNode lnode : left) {
                for (TreeNode rnode : right) {
                    TreeNode curr = new TreeNode(i, lnode, rnode);
                    res.add(curr);
                }
            }
        }
        return res;
    }
}