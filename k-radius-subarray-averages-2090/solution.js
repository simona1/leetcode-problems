/**
 * LeetCode problem # 2090, 'K Radius Subarray Averages'
 * https://leetcode.com/problems/k-radius-subarray-averages
 */

/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number[]}
 */
function getAverages(nums, k) {
  if (k === 0) {
    return nums;
  }
  const n = nums.length;
  const res = new Array(n).fill(-1);
  const diameter = 2 * k + 1;

  if (diameter > n) {
    return res;
  }

  const prefixSums = new Array(n + 1).fill(0);
  for (let i = 0; i < n; ++i) {
    prefixSums[i + 1] = prefixSums[i] + nums[i];
  }

  for (let i = k; i < n - k; ++i) {
    const left = i - k;
    const right = i + k;
    const currSum = prefixSums[right + 1] - prefixSums[left];
    const avg = Math.floor(currSum / diameter);
    res[i] = avg;
  }

  return res;
}
