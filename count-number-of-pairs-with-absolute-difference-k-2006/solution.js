/**
 * LeetCode problem # 2006, 'Count Number of Pairs With Absolute Difference K'
 * https://leetcode.com/problems/count-number-of-pairs-with-absolute-difference-k/
 */

/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */

/* O(n^2) solution  */
function countKDifference1(nums, k) {
  let res = 0;
  const n = nums.length;
  for (let j = 1; j < n; ++j) {
    for (let i = 0; i < j; ++i) {
      if (Math.abs(nums[i] - nums[j]) === k) {
        ++res;
      }
    }
  }
  return res;
}

/* O(n) solution with map */
function countKDifference(nums, k) {
  const freq = new Map();
  for (const num of nums) {
    freq.set(num, (freq.get(num) ?? 0) + 1);
  }
  return nums.reduce((acc, num) => acc + (freq.get(num - k) ?? 0), 0);
}
