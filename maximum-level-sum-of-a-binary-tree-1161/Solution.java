/**
 * LeetCode problem # 1161, 'Maximum Level Sum of a Binary Tree'
 * https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/
 */

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxLevelSum(TreeNode root) {
        int maxSum = Integer.MIN_VALUE;
        int res = 0;
        int level = 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            ++level;
            int currSum = 0;
            int size = q.size();

            while (size-- > 0) {
                TreeNode node = q.remove();
                currSum += node.val;

                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            if (maxSum < currSum) {
                maxSum = currSum;
                res = level;
            }
        }
        return res;
    }
}
