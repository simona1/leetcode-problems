/**
 * LeetCode problem # 700, 'Search in a Binary Search Tree'
 * https://leetcode.com/problems/search-in-a-binary-search-tree/
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
 * @param {number} val
 * @return {TreeNode}
 */
// iterative solution
const searchBST1 = function (root, val) {
  let curr = root;
  while (curr) {
    if (curr.val == val) {
      return curr;
    }
    if (curr.val > val) {
      curr = curr.left;
    } else {
      curr = curr.right;
    }
  }
  return null;
};

// recursive solution
const searchBST = function (root, val) {
  return !root || root.val === val
    ? root
    : searchBST(val < root.val ? root.left : root.right, val);
};
