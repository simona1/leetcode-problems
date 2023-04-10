/**
 * LeetCode problem # 1150, 'Check If a Number Is Majority Element in a Sorted Array'
 * https://leetcode.com/problems/check-if-a-number-is-majority-element-in-a-sorted-array
 */

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {boolean}
 */
function isMajorityElement(nums, target) {
  const n = nums.length >> 1;
  return (
    insertionIndex(nums, target + 0.5) - insertionIndex(nums, target - 0.5) > n
  );
}

function insertionIndex(nums, target) {
  let lo = -1;
  let hi = nums.length;

  while (lo + 1 != hi) {
    let mid = lo + ((hi - lo) >> 1);
    if (nums[mid] < target) {
      lo = mid;
    } else {
      hi = mid;
    }
  }
  return hi;
}
