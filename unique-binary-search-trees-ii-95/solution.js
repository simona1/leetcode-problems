/**
 * LeetCode problem # 95, 'Unique Binary Search Trees II'
 * https://leetcode.com/problems/unique-binary-search-trees-ii/
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
 * @param {number} n
 * @return {TreeNode[]}
 */
function generateTrees(n) {
  function solve(start, end) {
    if (start > end) {
      return [null];
    }
    const res = [];
    for (let i = start; i <= end; ++i) {
      const leftTrees = solve(start, i - 1);
      const rightTrees = solve(i + 1, end);

      for (const left of leftTrees) {
        for (const right of rightTrees) {
          const curr = new TreeNode(i);
          curr.left = left;
          curr.right = right;
          res.push(curr);
        }
      }
    }
    return res;
  }
  return n === 0 ? [] : solve(1, n);
}
