/**
 * LeetCode problem # 2707, 'Extra Characters in a String'
 * https://leetcode.com/problems/extra-characters-in-a-string/
 */

/**
 * @param {string} s
 * @param {string[]} dictionary
 * @return {number}
 */
function minExtraChar(s, dictionary) {
  const n = s.length;
  const set = new Set(dictionary);
  const cache = new Map();

  const dp = function (start) {
    if (start === n) {
      return 0;
    }
    if (cache.has(start)) {
      return cache.get(start);
    }

    let res = dp(start + 1) + 1;

    for (let end = start; end < n; ++end) {
      const curr = s.slice(start, end + 1);
      if (set.has(curr)) {
        res = Math.min(res, dp(end + 1));
      }
    }
    cache.set(start, res);
    return res;
  };

  return dp(0);
}
