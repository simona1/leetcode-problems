/**
 * LeetCode problem # 74, 'Search a 2D Matrix'
 * https://leetcode.com/problems/search-a-2d-matrix
 */

/**
 * @param {number[][]} matrix
 * @param {number} target
 * @return {boolean}
 */
const searchMatrix = function (matrix, target) {
  for (const row of matrix) {
    const curr = searchRow(row, target);
    if (curr >= 0 && curr <= row.length && row[curr] === target) {
      return true;
    }
  }
  return false;
};

function searchRow(row, target) {
  let lo = -1;
  let hi = row.length;
  while (lo + 1 !== hi) {
    let mid = lo + ((hi - lo) >> 1);
    if (row[mid] < target) {
      lo = mid;
    } else {
      hi = mid;
    }
  }
  return hi;
}
