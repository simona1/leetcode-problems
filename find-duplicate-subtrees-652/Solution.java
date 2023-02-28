/*
 * LeetCode problem # 652, 'Find Duplicate Subtrees'
 * https://leetcode.com/problems/find-duplicate-subtrees/
 */

import java.util.*;

// Definition for a binary tree node.
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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        traverse(root, res, map);
        return res;
    }

    private String traverse(TreeNode node, List<TreeNode> res, Map<String, Integer> map) {
        if (node == null) {
            return "null_node";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(node.val);
        sb.append(",");

        sb.append(traverse(node.left, res, map));
        sb.append(",");

        sb.append(traverse(node.right, res, map));

        String str = sb.toString();
        map.put(str, map.getOrDefault(str, 0) + 1);

        if (map.get(str) == 2) {
            res.add(node);
        }
        return str;
    }
}
