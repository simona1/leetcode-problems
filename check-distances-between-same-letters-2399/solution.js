/**
 * LeetCode problem # 2399, 'Check Distances Between Same Letters'
 * https://leetcode.com/problems/check-distances-between-same-letters
 */

/**
 * @param {string} s
 * @param {number[]} distance
 * @return {boolean}
 */
function checkDistances(s, distance) {
  const indexesMap = {};

  for (let i = 0; i < s.length; ++i) {
    const c = s[i];
    if (!indexesMap[s[i]]) {
      indexesMap[s[i]] = [i];
    } else {
      indexesMap[s[i]].push(i);
    }
  }
  const keys = Object.keys(indexesMap);
  for (const key of keys) {
    const val = indexesMap[key];
    if (val.length == 1) {
      continue;
    }
    const c = key.charCodeAt(0) - "a".charCodeAt(0);
    if (val[1] - val[0] - 1 !== distance[c]) {
      return false;
    }
  }
  return true;
}
