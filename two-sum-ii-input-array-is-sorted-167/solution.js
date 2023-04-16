/**
 * LeetCode problem # 167, 'Two Sum II - Input Array Is Sorted'
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 */

/**
 * @param {number[]} numbers
 * @param {number} target
 * @return {number[]}
 */
function twoSum(numbers, target) {
  let low = 0;
  let hi = numbers.length - 1;
  const res = [-1, -1];

  while (low < hi) {
    const sum = numbers[low] + numbers[hi];
    if (sum === target) {
      return [low + 1, hi + 1];
    }
    if (sum < target) {
      ++low;
    } else {
      --hi;
    }
  }
  return res;
}
