
/**
 * LeetCode problem # 129, 'Sum Root to Leaf Numbers'
 * https://leetcode.com/problems/sum-root-to-leaf-numbers
 */

import java.util.*;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */

class Pair {
    TreeNode node;
    int val;

    public Pair(TreeNode node, int val) {
        this.node = node;
        this.val = val;
    }
}

class Solution {
    public int sumNumbers(TreeNode root) {
        int res = 0;
        int curr = 0;

        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, 0));

        while (!stack.isEmpty()) {
            Pair p = stack.pop();
            root = p.node;
            curr = p.val;

            if (root != null) {
                curr = curr * 10 + root.val;
                if (root.left == null && root.right == null) {
                    res += curr;
                } else {
                    stack.push(new Pair(root.right, curr));
                    stack.push(new Pair(root.left, curr));
                }
            }
        }
        return res;
    }
}
