/**
 * LeetCode problem # 1287, 'Element Appearing More Than 25% In Sorted Array'
 * https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/
 */

/**
 * @param {number[]} arr
 * @return {number}
 */
var findSpecialInteger = function (arr) {
  const n = arr.length;
  if (n === 1) {
    return arr[0];
  }

  const indexes = [Math.ceil(n / 4), Math.ceil(n / 2), Math.ceil((n * 3) / 4)];

  for (const index of indexes) {
    const first = insertionIndex(arr, arr[index] - 0.5);
    const last = insertionIndex(arr, arr[index] + 0.5);
    if (last - first > n / 4) {
      return arr[index];
    }
  }
  return -1;
};

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
