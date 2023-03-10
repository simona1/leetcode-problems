/*
 * LeetCode problem # 594, 'Longest Harmonious Subsequence'
 * https://leetcode.com/problems/longest-harmonious-subsequence/
 */

/**
 * @param {number[]} nums
 * @return {number}
 */
const findLHS = function (nums) {
  const fr = {};

  for (const num of nums) {
    fr[num] = (fr[num] ?? 0) + 1;
  }

  let res = 0;
  for (const key of Object.keys(fr)) {
    const num = Number(key);
    if (fr[num + 1] == null) {
      continue;
    }
    const curr = fr[key] + (fr[num + 1] ?? 0);

    res = Math.max(res, curr);
  }
  return res;
};
