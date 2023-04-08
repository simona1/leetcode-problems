/**
 * LeetCode problem # 2089, 'Find Target Indices After Sorting Array'
 * https://leetcode.com/problems/find-target-indices-after-sorting-array
 */

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var targetIndices = function (nums, target) {
  let less = 0;
  let eq = 0;
  for (const num of nums) {
    if (num < target) {
      ++less;
    } else if (num === target) {
      ++eq;
    }
  }

  const res = [];
  for (let i = 0; i < eq; ++i) {
    res.push(less + i);
  }
  return res;
};
