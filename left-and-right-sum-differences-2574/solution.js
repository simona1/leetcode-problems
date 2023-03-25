/**
 * LeetCode problem # 2574, 'Left and Right Sum Differences'
 * https://leetcode.com/problems/left-and-right-sum-differences
 */

/**
 * @param {number[]} nums
 * @return {number[]}
 */
function leftRigthDifference(nums) {
  const left = getLeftSums(nums);
  const right = getRightSums(nums);

  return nums.map((num, i) => Math.abs(left[i] - right[i]));
}

function getLeftSums(nums) {
  const sums = [];
  sums[0] = 0;
  let sum = nums[0];

  for (let i = 1; i < nums.length; ++i) {
    sums[i] = sum;
    sum += nums[i];
  }
  return sums;
}

function getRightSums(nums) {
  const sums = [];
  let sum = nums[nums.length - 1];
  sums[nums.length - 1] = 0;
  for (let i = nums.length - 2; i >= 0; --i) {
    sums[i] = sum;
    sum += nums[i];
  }
  return sums;
}
