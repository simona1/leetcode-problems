/*
 * LeetCode problem # 103, 'Binary Tree Zigzag Level Order Traversal'
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 * 
 * Given the root of a binary tree, return the zigzag level order traversal 
 * of its nodes' values. (i.e., from left to right, then right to left for 
 * the next level and alternate between).
 * 
 */

 import java.util.*;

 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 0;
        
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> curr = new ArrayList<>();
            for (int i = 0; i < size; ++i) {
                TreeNode node = q.remove();

                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }

                if (level % 2 != 0) {
                    curr.add(0, node.val); 
                } else {
                    curr.add(node.val);
                }
            }
            res.add(curr);
            ++level;
        }
        return res;
    }
}