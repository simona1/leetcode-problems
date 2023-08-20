/**
 * LeetCode problem # 2733, 'Neither Minimum nor Maximum'
 * https://leetcode.com/problems/neither-minimum-nor-maximum
 */

/**
 * @param {number[]} nums
 * @return {number}
 */

function findNonMinOrMax(nums) {
  const min = Math.min(...nums);
  const max = Math.max(...nums);
  return nums.find((num) => num !== min && num !== max) ?? -1;
}
