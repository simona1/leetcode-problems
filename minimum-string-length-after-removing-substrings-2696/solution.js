/**
 * LeetCode problem # 2696, 'Minimum String Length After Removing Substrings'
 * https://leetcode.com/problems/minimum-string-length-after-removing-substrings
 */

/**
 * @param {string} s
 * @return {number}
 */
function minLength(s) {
  while (s.includes("AB") || s.includes("CD")) {
    s = s.split("AB").join("");
    s = s.split("CD").join("");
  }
  return s.length;
}
