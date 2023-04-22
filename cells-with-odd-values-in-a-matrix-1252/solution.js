/**
 * LeetCode problem # 1252, 'Cells with Odd Values in a Matrix'
 * https://leetcode.com/problems/cells-with-odd-values-in-a-matrix/
 */

/**
 * @param {number} n
 * @param {number} m
 * @param {number[][]} indices
 * @return {number}
 */
var oddCells = function (n, m, indices) {
  const row = Array(n).fill(0);
  const col = Array(m).fill(0);

  for (const [r, c] of indices) {
    row[r] ^= 1;
    col[c] ^= 1;
  }

  const oddRows = row.reduce(sum);
  const evenRows = n - oddRows;

  const oddCols = col.reduce(sum);
  const evenCols = m - oddCols;

  return oddRows * evenCols + evenRows * oddCols;
};

const sum = (a, b) => a + b;
