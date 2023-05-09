/**
 * LeetCode problem # 2634, 'Filter Elements from Array'
 * https://leetcode.com/problems/filter-elements-from-array/
 */

/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
function filter(arr, fn) {
  const res = [];

  for (let i = 0; i < arr.length; ++i) {
    if (fn(arr[i], i)) {
      res.push(arr[i]);
    }
  }
  return res;
}
