/**
 * LeetCode problem # 1394, 'Find Lucky Integer in an Array'
 * https://leetcode.com/problems/find-lucky-integer-in-an-array/
 */

/**
 * @param {number[]} arr
 * @return {number}
 */
function findLucky(arr) {
  const freq = new Map();

  for (const num of arr) {
    freq.set(num, (freq.get(num) ?? 0) + 1);
  }

  const lucky = [];
  for (const [key, value] of freq) {
    if (key === value) {
      lucky.push(key);
    }
  }

  return lucky.length == 0
    ? -1
    : lucky.reduce((max, current) => Math.max(max, current));
}
