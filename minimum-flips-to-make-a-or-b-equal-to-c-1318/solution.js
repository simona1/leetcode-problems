/**
 * LeetCode problem # 1318, 'Minimum Flips to Make a OR b Equal to c'
 * https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c/
 */

/**
 * @param {number} a
 * @param {number} b
 * @param {number} c
 * @return {number}
 */
function minFlips(a, b, c) {
  let res = 0;
  while ((a !== 0) | (b !== 0) | (c !== 0)) {
    if ((c & 1) === 1) {
      if ((a & 1) == 0 && (b & 1) === 0) {
        ++res;
      }
    } else {
      res += (a & 1) + (b & 1);
    }
    a >>= 1;
    b >>= 1;
    c >>= 1;
  }
  return res;
}
