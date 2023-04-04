/**
 * LeetCode problem # 2229, 'Check if an Array Is Consecutive'
 * https://leetcode.com/problems/check-if-an-array-is-consecutive
 */

/**
 * @param {number[]} nums
 * @return {boolean}
 */
function isConsecutive(nums) {
  const numSet = new Set(nums);

  if (numSet.size !== nums.length) {
    return false;
  }

  const min = Math.min(...nums);
  for (let i = min + 1; i <= min + nums.length - 1; ++i) {
    if (!numSet.has(i)) {
      return false;
    }
  }
  return true;
}
