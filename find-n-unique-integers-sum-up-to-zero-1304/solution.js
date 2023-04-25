/**
 * LeetCode problem # 1304, 'Find N Unique Integers Sum up to Zero'
 * https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/
 */

/**
 * @param {number} n
 * @return {number[]}
 */
function sumZero(n) {
  const res = Array(n);

  for (let i = 0; i < n; ++i) {
    res[i] = i * 2 - n + 1;
  }

  return res;
}
