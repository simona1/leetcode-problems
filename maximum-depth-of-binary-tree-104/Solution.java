
/**
 * LeetCode problem # 104, 'Maximum Depth of Binary Tree'
 * https://leetcode.com/problems/maximum-depth-of-binary-tree
 */

import java.util.*;

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
    public int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public int maxDepthIterative(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int res = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            ++res;
            for (int i = 0; i < size; ++i) {
                TreeNode curr = q.remove();
                if (curr != null) {
                    q.add(curr.left);
                    q.add(curr.right);
                }
            }
        }
        return res - 1;
    }
}
