/**
 * LeetCode problem # 2255, 'Count Prefixes of a Given String'
 * https://leetcode.com/problems/count-prefixes-of-a-given-string/
 */

/**
 * @param {string[]} words
 * @param {string} s
 * @return {number}
 */
const countPrefixes = function (words, s) {
  let res = 0;
  for (const word of words) {
    if (s.startsWith(word)) {
      ++res;
    }
  }
  return res;
};
