
/**
 * LeetCode problem # 501, 'Find Mode in Binary Search Tree'
 * https://leetcode.com/problems/find-mode-in-binary-search-tree
 */

import java.util.*;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> freq = new HashMap<>();
        traverse(root, freq);

        int maxFreq = Collections.max(freq.entrySet(), Map.Entry.comparingByValue()).getValue();
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            if (e.getValue().intValue() == maxFreq) {
                list.add(e.getKey());
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void traverse(TreeNode root, Map<Integer, Integer> freq) {
        if (root == null) {
            return;
        }

        freq.put(root.val, freq.getOrDefault(root.val, 0) + 1);
        if (root.left != null) {
            traverse(root.left, freq);
        }
        if (root.right != null) {
            traverse(root.right, freq);
        }
    }

}