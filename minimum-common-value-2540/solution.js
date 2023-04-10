/**
 * LeetCode problem # 2540, 'Minimum Common Value'
 * https://leetcode.com/problems/minimum-common-value
 */

/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */
function getCommon(nums1, nums2) {
  for (const num of nums1) {
    if (isPresent(nums2, num)) {
      return num;
    }
  }
  return -1;
}

function isPresent(arr, val) {
  let lo = -1;
  let hi = arr.length;

  while (lo + 1 != hi) {
    let mid = lo + ((hi - lo) >> 1);

    if (arr[mid] == val) {
      return true;
    } else if (arr[mid] < val) {
      lo = mid;
    } else {
      hi = mid;
    }
  }
  return false;
}
