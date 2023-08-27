/**
 * LeetCode problem # 104, 'Maximum Depth of Binary Tree'
 * https://leetcode.com/problems/maximum-depth-of-binary-tree
 */

/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number}
 */
const maxDepth = function (root) {
  if (root == null) {
    return 0;
  }
  if (root.left == null && root.right == null) {
    return 1;
  }

  let res = Number.MIN_SAFE_INTEGER;
  if (root.left != null) {
    res = Math.max(res, maxDepth(root.left));
  }
  if (root.right != null) {
    res = Math.max(res, maxDepth(root.right));
  }
  return res + 1;
};
