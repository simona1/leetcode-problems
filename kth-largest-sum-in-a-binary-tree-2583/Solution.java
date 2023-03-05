/*
 * LeetCode problem # 2583, 'Kth Largest Sum in a Binary Tree'
 * https://leetcode.com/problems/kth-largest-sum-in-a-binary-tree/
 */

import java.util.*;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */

class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        Map<Integer, Long> levelSums = new HashMap<>();

        traverse(root, 0, levelSums);
        ArrayList<Long> valuesList = new ArrayList<>(levelSums.values());
        Collections.sort(valuesList, Collections.reverseOrder());

        return k - 1 < valuesList.size() ? valuesList.get(k - 1) : -1;

    }

    private void traverse(TreeNode node, int level, Map<Integer, Long> levelSums) {
        if (node == null) {
            return;
        }
        levelSums.put(level + 1, levelSums.getOrDefault(level + 1, (long) 0) + node.val);
        traverse(node.left, level + 1, levelSums);
        traverse(node.right, level + 1, levelSums);
    }
}
