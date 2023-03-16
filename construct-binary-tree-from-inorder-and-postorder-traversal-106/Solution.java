/*
* LeetCode problem # 106, 'Construct Binary Tree from Inorder and Postorder Traversal'
* https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
*/

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */

import java.util.*;

class Solution {
    private TreeNode buildTree(int[] postorder, int start, int end, int index, Map<Integer, Integer> map) {
        if (start > end) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[end]);
        int curr = map.get(root.val);

        int len = curr - index;

        root.left = buildTree(postorder, start, start + len - 1, index, map);
        root.right = buildTree(postorder, start + len, end - 1, curr + 1, map);
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; ++i) {
            map.put(inorder[i], i);
        }
        return buildTree(postorder, 0, postorder.length - 1, 0, map);
    }
}
