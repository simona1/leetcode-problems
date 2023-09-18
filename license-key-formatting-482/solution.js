/**
 * LeetCode problem # 482, 'License Key Formatting'
 * https://leetcode.com/problems/license-key-formatting
 */

/**
 * @param {string} s
 * @param {number} k
 * @return {string}
 */
function licenseKeyFormatting(s, k) {
  const pieces = s.split("-");
  if (pieces.length === 0) {
    return "";
  }

  let res = [];

  let len = 0;
  for (let i = pieces.length - 1; i >= 0; --i) {
    const curr = pieces[i];
    for (let j = curr.length - 1; j >= 0; --j) {
      if (len === k) {
        res.push("-");
        len = 0;
      }
      res.push(curr[j]);
      ++len;
    }
  }
  if (res.at(-1) === "-") {
    res.pop();
  }
  return res.reverse().join("").toUpperCase();
}
