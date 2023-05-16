/**
 * LeetCode problem # 2639, 'Find the Width of Columns of a Grid'
 * https://leetcode.com/problems/find-the-width-of-columns-of-a-grid/
 */

/**
 * @param {number[][]} grid
 * @return {number[]}
 */
function findColumnWidth(grid) {
  const res = [];
  for (let i = 0; i < grid[0].length; ++i) {
    let max = 0;
    for (let j = 0; j < grid.length; ++j) {
      const curr = (grid[j][i] + "").length;
      max = Math.max(max, curr);
    }
    res.push(max);
  }
  return res;
}
