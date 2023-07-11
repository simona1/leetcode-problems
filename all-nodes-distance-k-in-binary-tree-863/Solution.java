
/**
 * LeetCode problem # 863, 'All Nodes Distance K in Binary Tree'
 * https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
 */

import java.util.*;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<Integer, TreeNode> map = new HashMap<>();
        map.put(root.val, null);
        mapParentToNodes(root, map);

        Queue<TreeNode> q = new LinkedList<>();
        Set<Integer> vis = new HashSet<>();
        q.add(target);
        vis.add(target.val);

        while (k-- > 0) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                TreeNode curr = q.remove();
                if (curr.left != null && !vis.contains(curr.left.val)) {
                    q.add(curr.left);
                    vis.add(curr.left.val);
                }
                if (curr.right != null && !vis.contains(curr.right.val)) {
                    q.add(curr.right);
                    vis.add(curr.right.val);
                }
                TreeNode parent = map.get(curr.val);
                if (parent != null && !vis.contains(parent.val)) {
                    q.add(parent);
                    vis.add(parent.val);
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!q.isEmpty()) {
            res.add(q.remove().val);
        }
        return res;
    }

    private void mapParentToNodes(TreeNode root, Map<Integer, TreeNode> map) {
        if (root != null) {
            if (root.left != null) {
                map.put(root.left.val, root);
                mapParentToNodes(root.left, map);
            }
            if (root.right != null) {
                map.put(root.right.val, root);
                mapParentToNodes(root.right, map);
            }
        }
    }
}