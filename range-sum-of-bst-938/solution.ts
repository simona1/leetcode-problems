/**
 * LeetCode problem # 938, 'Range Sum of BST'
 * https://leetcode.com/problems/range-sum-of-bst/
 */

/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     val: number
 *     left: TreeNode | null
 *     right: TreeNode | null
 *     constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.left = (left===undefined ? null : left)
 *         this.right = (right===undefined ? null : right)
 *     }
 * }
 */

function rangeSumBST(root: TreeNode | null, low: number, high: number): number {
  if (!root) {
    return 0;
  }

  let sum: number = 0;
  const st: TreeNode[] = [];
  st.push(root);

  while (st.length) {
    const curr = st.pop();
    if (curr != null) {
      if (curr.val >= low && curr.val <= high) {
        sum += curr.val;
      }
      if (low < curr.val) {
        st.push(curr.left);
      }
      if (curr.val < high) {
        st.push(curr.right);
      }
    }
  }
  return sum;
}
