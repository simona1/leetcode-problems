/**
 * LeetCode problem # 2190, 'Most Frequent Number Following Key In an Array'
 * https://leetcode.com/problems/most-frequent-number-following-key-in-an-array
 */

/**
 * @param {number[]} nums
 * @param {number} key
 * @return {number}
 */
function mostFrequent(nums, key) {
  const indexesOfKey = [];
  const n = nums.length;
  for (let i = 0; i < n; ++i) {
    if (nums[i] === key) {
      indexesOfKey.push(i);
    }
  }

  const freq = new Map();
  for (const index of indexesOfKey) {
    const nextIndex = index + 1;
    const target = nums[nextIndex];
    if (nextIndex < n) {
      freq.set(target, (freq.get(target) ?? 0) + 1);
    }
  }

  let res = null;
  let max = -Infinity;
  for (const [key, val] of freq) {
    if (val > max) {
      max = val;
      res = key;
    }
  }
  return res;
}
