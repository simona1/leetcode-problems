/**
 * LeetCode problem # 2626, 'Array Reduce Transformation'
 * https://leetcode.com/problems/array-reduce-transformation/
 */

/**
 * @param {number[]} nums
 * @param {Function} fn
 * @param {number} init
 * @return {number}
 */
function reduce(nums, fn, init) {
  let res = init;
  for (const num of nums) {
    res = fn(res, num);
  }
  return res;
}
