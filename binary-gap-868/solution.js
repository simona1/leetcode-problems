/**
 * LeetCode problem # 868, 'Binary Gap'
 * https://leetcode.com/problems/binary-gap
 */

/**
 * @param {number} n
 * @return {number}
 */
function binaryGap(num) {
  let last = -1;
  let res = 0;
  for (let i = 0; i < 32; ++i) {
    if (((num >> i) & 1) > 0) {
      if (last >= 0) {
        res = Math.max(res, i - last);
      }
      last = i;
    }
  }
  return res;
}
