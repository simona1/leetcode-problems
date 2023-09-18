/**
 * LeetCode problem # 1422, 'Maximum Score After Splitting a String'
 * https://leetcode.com/problems/maximum-score-after-splitting-a-string
 */

/**
 * @param {string} s
 * @return {number}
 */
const maxScore = function (s) {
  let count = 0;
  for (let i = 0; i < s.length; ++i) {
    if (s[i] === "1") {
      ++count;
    }
  }

  let left = 0;
  let right = count;
  let res = 0;
  for (let i = 0; i < s.length - 1; ++i) {
    if (s[i] === "0") {
      ++left;
    } else {
      --right;
    }
    res = Math.max(res, left + right);
  }
  return res;
};
