/**
 * LeetCode problem # 1486, 'XOR Operation in an Array'
 * https://leetcode.com/problems/xor-operation-in-an-array
 */

/**
 * @param {number} n
 * @param {number} start
 * @return {number}
 */
function xorOperation(n, start) {
  let res = 0;
  let prev = start;

  for (let i = 0; i < n; ++i) {
    res ^= prev;
    prev += 2;
  }
  return res;
}
