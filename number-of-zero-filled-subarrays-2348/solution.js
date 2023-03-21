/**
 * LeetCode problem # 2348, 'Number of Zero-Filled Subarrays'
 * https://leetcode.com/problems/number-of-zero-filled-subarrays
 */

/**
 * @param {number[]} nums
 * @return {number}
 */
function zeroFilledSubarray(nums) {
  let res = 0;
  for (let i = 0; i < nums.length; ++i) {
    if (nums[i] === 0) {
      let j = i;
      while (nums[j] === 0 && j < nums.length) {
        ++j;
      }
      res += ((j - i + 1) * (j - i)) / 2;
      i = j;
    }
  }
  return res;
}
