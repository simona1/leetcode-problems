/**
 * LeetCode problem # 2441, 'Largest Positive Integer That Exists With Its Negative'
 * https://leetcode.com/problems/largest-positive-integer-that-exists-with-its-negative
 */

function findMaxK(nums: number[]): number {
  nums.sort((a, b) => a - b);

  let lo = 0;
  let hi = nums.length - 1;

  while (lo < hi) {
    const a = nums[lo];
    const b = nums[hi];
    if (-a === b) {
      return b;
    }
    if (-a < b) {
      --hi;
    } else {
      ++lo;
    }
  }

  return -1;
}
