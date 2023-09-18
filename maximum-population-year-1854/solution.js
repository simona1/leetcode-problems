/**
 * LeetCode problem # 1854, 'Maximum Population Year'
 * https://leetcode.com/problems/maximum-population-year
 */

/**
 * @param {number[][]} logs
 * @return {number}
 */
const maximumPopulation = function (logs) {
  const counts = new Map();

  for (const log of logs) {
    const [by, dy] = log;
    for (let i = by; i < dy; ++i) {
      counts.set(i, (counts.get(i) ?? 0) + 1);
    }
  }

  let res = null;
  let maxVal = 0;
  for (const [key, val] of counts) {
    if (val > maxVal) {
      maxVal = val;
      res = key;
    }
    if (val === maxVal) {
      res = Math.min(res, key);
    }
  }
  return res;
};
