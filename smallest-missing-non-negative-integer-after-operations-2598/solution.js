/*
 * LeetCode problem # 2598, 'Smallest Missing Non-negative Integer After Operations'
 * https://leetcode.com/problems/smallest-missing-non-negative-integer-after-operations
 */

/**
 * @param {number[]} nums
 * @param {number} value
 * @return {number}
 */
var findSmallestInteger = function (nums, value) {
  const fr = {};

  for (const n of nums) {
    let rem = n % value;
    if (rem < 0) {
      rem += value;
    }
    fr[rem] = (fr[rem] ?? 0) + 1;
  }

  let count = 0;

  while (true) {
    let index = count % value;
    if (fr[index] != null && fr[index] > 0) {
      ++count;
      fr[index] -= 1;
      continue;
    }
    break;
  }
  return count;
};
