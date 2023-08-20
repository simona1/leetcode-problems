/**
 * LeetCode problem # 2635, 'Apply Transform Over Each Element in Array'
 * https://leetcode.com/problems/apply-transform-over-each-element-in-array
 */

/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
const map = function (arr, fn) {
  const res = [];

  for (let i = 0; i < arr.length; ++i) {
    res[i] = fn(arr[i], i);
  }
  return res;
};
