/**
 * LeetCode problem # 229, 'Majority Element II'
 * https://leetcode.com/problems/majority-element-ii
 */

/**
 * @param {number[]} nums
 * @return {number[]}
 */
function majorityElement(nums) {
  const freq = {};
  const n = nums.length;

  for (const num of nums) {
    freq[num] = (freq[num] ?? 0) + 1;
  }

  return Object.keys(freq).filter((key) => freq[key] * 3 > n);
}
