/**
 * LeetCode problem # 1920, 'Build Array from Permutation'
 * https://leetcode.com/problems/build-array-from-permutation/
 */

/**
 * @param {number[]} nums
 * @return {number[]}
 */
function buildArray(nums) {
  return nums.map((num) => nums[num]);
}
