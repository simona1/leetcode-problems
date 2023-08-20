/**
 * LeetCode problem # 896, 'Monotonic Array'
 * https://leetcode.com/problems/monotonic-array/
 */

/**
 * @param {number[]} nums
 * @return {boolean}
 */
function isMonotonic(nums) {
  let isIncreasing = true;
  let isDecreasing = true;

  const n = nums.length;
  for (let i = 1; i < nums.length; ++i) {
    if (nums[i - 1] > nums[i]) {
      isIncreasing = false;
      break;
    }
  }
  for (let i = 1; i < nums.length; ++i) {
    if (nums[i - 1] < nums[i]) {
      isDecreasing = false;
      break;
    }
  }
  return isDecreasing || isIncreasing;
}
