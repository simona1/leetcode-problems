/**
 * LeetCode problem # 2733, 'Neither Minimum nor Maximum'
 * https://leetcode.com/problems/neither-minimum-nor-maximum
 */

/**
 * @param {number[]} nums
 * @return {number}
 */
function findNonMinOrMax(nums) {
  let min = Number.MAX_SAFE_INTEGER;
  let max = Number.MIN_SAFE_INTEGER;

  for (const num of nums) {
    min = Math.min(num, min);
    max = Math.max(num, max);
  }

  for (const num of nums) {
    if (num !== min && num !== max) {
      return num;
    }
  }
  return -1;
}
