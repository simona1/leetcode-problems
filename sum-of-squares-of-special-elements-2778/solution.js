/**
 * LeetCode problem # 2778, 'Sum of Squares of Special Elements'
 * https://leetcode.com/problems/sum-of-squares-of-special-elements/
 */

/**
 * @param {number[]} nums
 * @return {number}
 */

function sumOfSquares(nums) {
  const n = nums.length;
  let res = 0;

  for (let i = 1; i * i <= n; ++i) {
    if (n % i === 0) {
      res += nums[i - 1] ** 2;

      const div = n / i;
      if (div !== i) {
        res += nums[div - 1] ** 2;
      }
    }
  }
  return res;
}
