/**
 * LeetCode problem # 2796, 'Repeat String'
 * https://leetcode.com/problems/repeat-string/
 */

String.prototype.replicate = function (times) {
  let res = "";
  while (times-- > 0) {
    res += this;
  }
  return res;
};
