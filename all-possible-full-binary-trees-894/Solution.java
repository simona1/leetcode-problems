
/**
 * LeetCode problem # 894, 'All Possible Full Binary Trees'
 * https://leetcode.com/problems/all-possible-full-binary-trees/
 */

import java.util.*;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public List<TreeNode> allPossibleFBT(int n) {
        if (n % 2 == 0) {
            return new ArrayList<>();
        }
        List<List<TreeNode>> res = new ArrayList<>();
        for (int i = 0; i <= n; ++i) {
            res.add(new ArrayList<>());
        }
        res.get(1).add(new TreeNode(0));
        for (int count = 3; count <= n; count += 2) {
            for (int i = 1; i < count - 1; i += 2) {
                int j = count - 1 - i;
                for (TreeNode left : res.get(i)) {
                    for (TreeNode right : res.get(j)) {
                        TreeNode root = new TreeNode(0, left, right);
                        res.get(count).add(root);
                    }
                }
            }
        }
        return res.get(n);
    }
}
