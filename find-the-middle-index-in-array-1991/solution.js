/**
 * LeetCode problem # 1991, 'Find the Middle Index in Array'
 * https://leetcode.com/problems/find-the-middle-index-in-array
 */

function findMiddleIndex(nums) {
  let right = nums.reduce((a, b) => a + b);
  let left = 0;

  for (let i = 0; i < nums.length; ++i) {
    right -= nums[i];
    if (left === right) {
      return i;
    }
    left += nums[i];
  }
  return -1;
}
