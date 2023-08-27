/**
 * LeetCode problem # 2535, 'Difference Between Element Sum and Digit Sum of an Array'
 * https://leetcode.com/problems/difference-between-element-sum-and-digit-sum-of-an-array/
 */

/**
 * @param {number[]} nums
 * @return {number}
 */

function differenceOfSum(nums) {
  const elemSum = nums.reduce((acc, num) => num + acc);

  const digits = nums.flatMap((num) => getDigits(num));
  const digitSum = digits.reduce((acc, dig) => dig + acc);

  return Math.abs(elemSum - digitSum);
}

function getDigits(num) {
  const res = [];

  while (num > 0) {
    const d = num % 10;
    res.push(d);
    num = (num - d) / 10;
  }
  return res;
}
