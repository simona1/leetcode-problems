/**
 * LeetCode problem # 2331, 'Evaluate Boolean Binary Tree'
 * https://leetcode.com/problems/evaluate-boolean-binary-tree
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
function evaluateTree(root) {
  if (root.val === 0 || root.val === 1) {
    return root.val === 1;
  }

  const leftRes = root.left && evaluateTree(root.left);
  if ((leftRes && root.val === 2) || (!leftRes && root.val === 3)) {
    return leftRes;
  }

  const rightRes = root.right && evaluateTree(root.right);
  return rightRes;
}
