/**
 * LeetCode problem # 217, 'Contains Duplicate'
 * https://leetcode.com/problems/contains-duplicate/
 */

/**
 * @param {number[]} nums
 * @return {boolean}
 */
function containsDuplicate(nums) {
  return new Set(nums).size !== nums.length;
}
