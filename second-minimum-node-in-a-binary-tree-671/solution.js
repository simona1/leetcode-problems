/**
 * LeetCode problem # 671, 'Second Minimum Node In a Binary Tree'
 * https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/
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
function findSecondMinimumValue(root) {
  if (!root) {
    return -1;
  }

  let min = Infinity;
  let prevMin = -1;

  const traverse = (node) => {
    if (!node) {
      return;
    }
    if (node.val < min) {
      prevMin = min;
      min = node.val;
    } else if (node.val > min) {
      prevMin = prevMin < node.val ? prevMin : node.val;
    }
    traverse(node.left);
    traverse(node.right);
  };

  traverse(root);
  return prevMin == Infinity ? -1 : prevMin;
}
