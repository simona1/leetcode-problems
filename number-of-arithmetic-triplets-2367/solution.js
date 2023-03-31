/**
 * LeetCode problem # 2367, 'Number of Arithmetic Triplets'
 * https://leetcode.com/problems/number-of-arithmetic-triplets
 */

/**
 * @param {number[]} nums
 * @param {number} diff
 * @return {number}
 */

function arithmeticTriplets(nums, diff) {
  const set = new Set(nums);
  let count = 0;

  for (const num of nums) {
    if (set.has(num + diff) && set.has(num + diff * 2)) {
      ++count;
    }
  }
  return count;
}
