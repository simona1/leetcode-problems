/**
 * LeetCode problem # 908, 'Smallest Range I'
 * https://leetcode.com/problems/smallest-range-i
 */

/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
function smallestRangeI(nums, k) {
  let diff = 0;
  if (nums.length === 1) {
    return diff;
  }

  let max = Math.max(...nums);
  let min = Math.min(...nums);

  max -= k;
  min += k;
  diff = max - min;

  return diff < 0 ? 0 : diff;
}
