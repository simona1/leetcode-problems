/**
 * LeetCode problem # 2784, 'Check if Array is Good'
 * https://leetcode.com/problems/check-if-array-is-good/
 */

/**
 * @param {number[]} nums
 * @return {boolean}
 */
function isGood(nums) {
  const max = Math.max(...nums);
  if (max !== nums.length - 1) {
    return false;
  }

  const map = new Map();
  for (const num of nums) {
    map.set(num, (map.get(num) ?? 0) + 1);
    if (map.get(num) > 1 && num !== max) {
      return false;
    }
  }

  if (map.get(max) !== 2) {
    return false;
  }
  return true;
}
