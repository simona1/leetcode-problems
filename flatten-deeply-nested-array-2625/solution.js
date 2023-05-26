/**
 * LeetCode problem # 2625, 'Flatten Deeply Nested Array'
 * https://leetcode.com/problems/flatten-deeply-nested-array
 */

/**
 * @param {any[]} arr
 * @param {number} depth
 * @return {any[]}
 */
const flat = function (arr, n) {
  if (n === 0) {
    return arr;
  }

  const res = [];
  for (let elem of arr) {
    if (Array.isArray(elem)) {
      res.push(...flat(elem, n - 1));
    } else {
      res.push(elem);
    }
  }
  return res;
};
