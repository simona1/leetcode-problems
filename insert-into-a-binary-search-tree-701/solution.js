/**
 * LeetCode problem # 701, 'Insert into a Binary Search Tree'
 * https://leetcode.com/problems/insert-into-a-binary-search-tree
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
function insertIntoBST(root, val) {
  const toInsert = new TreeNode(val);
  if (!root) {
    root = toInsert;
    return root;
  }

  function insertNode(node) {
    if (node) {
      if (node.val < val) {
        node.right ? insertNode(node.right) : (node.right = toInsert);
      } else {
        node.left ? insertNode(node.left) : (node.left = toInsert);
      }
    }
  }
  insertNode(root);
  return root;
}
