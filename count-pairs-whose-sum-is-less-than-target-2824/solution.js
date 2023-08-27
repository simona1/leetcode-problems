/**
 * LeetCode problem # 2824, 'Count Pairs Whose Sum is Less than Target'
 * https://leetcode.com/problems/count-pairs-whose-sum-is-less-than-target
 */

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
const countPairs = function (nums, target) {
  let res = 0;
  nums.sort((a, b) => a - b);

  for (let i = 0; i < nums.length; ++i) {
    const insertIndex = binarySearch(nums, target - nums[i]);
    res += Math.max(0, insertIndex - i);
  }
  return res;
};

function binarySearch(nums, target) {
  let lo = -1;
  let hi = nums.length;

  while (lo + 1 !== hi) {
    let mid = lo + ((hi - lo) >> 1);

    if (nums[mid] < target) {
      lo = mid;
    } else {
      hi = mid;
    }
  }
  return lo;
}
