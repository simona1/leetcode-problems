/**
 * LeetCode problem # 1470, 'Shuffle the Array'
 * https://leetcode.com/problems/shuffle-the-array/
 */

/**
 * @param {number[]} nums
 * @param {number} n
 * @return {number[]}
 */

// Solution 1
function shuffle1(nums, n) {
  const res = [nums[0], nums[n]];

  for (let i = 1; i < n; ++i) {
    res.push(nums[i], nums[i + n]);
  }
  return res;
}

// Solution 2, with generator function
function shuffle(nums, n) {
  return [...shuffleGenerator(nums, n)];
}

function* shuffleGenerator(nums, n) {
  yield nums[0];
  yield nums[n];

  for (let i = 1; i < n; ++i) {
    yield nums[i];
    yield nums[i + n];
  }
}
