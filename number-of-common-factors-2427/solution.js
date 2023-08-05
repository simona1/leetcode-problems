/**
 * LeetCode problem # 2427, 'Number of Common Factors'
 * https://leetcode.com/problems/number-of-common-factors/
 */

/**
 * @param {number} a
 * @param {number} b
 * @return {number}
 */
function commonFactors(a, b) {
  let res = 0;
  const min = Math.min(a, b);
  for (let i = 1; i <= min; ++i) {
    if (a % i === 0 && b % i === 0) {
      ++res;
    }
  }
  return res;
}
