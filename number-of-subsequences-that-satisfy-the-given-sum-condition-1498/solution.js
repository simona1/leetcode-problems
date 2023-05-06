/**
 * LeetCode problem # 1498, 'Number of Subsequences That Satisfy the Given Sum Condition'
 * https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/
 */

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
function numSubseq(nums, target) {
  const MOD = 1000000007;
  nums = nums.sort((a, b) => a - b);
  const pows = [1];

  for (let i = 1; i < nums.length; ++i) {
    pows.push((pows[i - 1] * 2) % MOD);
  }

  let lo = 0;
  let hi = nums.length - 1;
  let res = 0;

  while (lo <= hi) {
    if (nums[lo] + nums[hi] > target) {
      --hi;
    } else {
      res = (res + pows[hi - lo]) % MOD;
      ++lo;
    }
  }

  return res % MOD;
}
