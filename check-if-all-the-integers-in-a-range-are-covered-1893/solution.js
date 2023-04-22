/**
 * LeetCode problem # 1893, 'Check if All the Integers in a Range Are Covered'
 * https://leetcode.com/problems/check-if-all-the-integers-in-a-range-are-covered
 */

/**
 * @param {number[][]} ranges
 * @param {number} left
 * @param {number} right
 * @return {boolean}
 */
function isCovered(ranges, left, right) {
  const set = new Set();
  for (const range of ranges) {
    for (let i = range[0]; i <= range[1]; ++i) {
      set.add(i);
    }
  }

  for (let i = left; i <= right; ++i) {
    if (!set.has(i)) {
      return false;
    }
  }
  return true;
}
