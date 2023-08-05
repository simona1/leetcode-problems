/**
 * LeetCode problem # 965, 'Univalued Binary Tree'
 * https://leetcode.com/problems/univalued-binary-tree
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
 * @return {boolean}
 */
function isUnivalTree(root) {
  const checkLeft =
    root.left === null ||
    (root.left.val === root.val && isUnivalTree(root.left));
  const checkRight =
    root.right === null ||
    (root.right.val === root.val && isUnivalTree(root.right));
  return checkLeft && checkRight;
}
