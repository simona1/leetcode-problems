/**
 * LeetCode problem # 1221, 'Split a String in Balanced Strings'
 * https://leetcode.com/problems/split-a-string-in-balanced-strings
 */

/**
 * @param {string} s
 * @return {number}
 */
function balancedStringSplit(s) {
  let lc = 0;
  let rc = 0;
  let count = 0;

  for (const c of s) {
    if (c === "L") {
      ++lc;
    } else {
      ++rc;
    }
    if (lc === rc) {
      ++count;
      lc = 0;
      rc = 0;
    }
  }
  return count;
}
