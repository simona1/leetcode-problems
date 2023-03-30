/**
 * LeetCode problem # 961, 'N-Repeated Element in Size 2N Array'
 * https://leetcode.com/problems/n-repeated-element-in-size-2n-array
 */

/**
 * @param {number[]} nums
 * @return {number}
 */
function repeatedNTimes(nums) {
  const freq = {};

  for (const num of nums) {
    freq[num] = (freq[num] ?? 0) + 1;
  }
  return Object.keys(freq).filter((elem) => freq[elem] > 1)[0];
}
