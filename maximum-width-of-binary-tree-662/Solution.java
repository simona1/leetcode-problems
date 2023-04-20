/**
 * LeetCode problem # 662, 'Maximum Width of Binary Tree'
 * https://leetcode.com/problems/maximum-width-of-binary-tree/
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
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        Map<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
        
        q.add(root);
        map.put(root, 1);
        
        int currWidth = 0;
        int maxWidth = 0;

        while (!q.isEmpty()){
            int sz = q.size();
            int start = 0;
            int end = 0;
            
            for (int i = 0; i < sz; ++i) {
                TreeNode node = q.remove();

                if (i == 0) {
                    start = map.get(node);
                }

                if (i == sz - 1){
                    end = map.get(node);
                }

                if (node.left != null) {
                    map.put(node.left, map.get(node) * 2);
                    q.add(node.left);
                }
                if(node.right != null){
                    map.put(node.right, map.get(node) * 2 + 1);
                    q.add(node.right);
                }
            }
            currWidth = end - start + 1;
            maxWidth = Math.max(currWidth, maxWidth);
        }
        return maxWidth;
    }
}

