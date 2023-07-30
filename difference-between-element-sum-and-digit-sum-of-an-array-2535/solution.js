/**
 * LeetCode problem # 2535, 'Difference Between Element Sum and Digit Sum of an Array'
 * https://leetcode.com/problems/difference-between-element-sum-and-digit-sum-of-an-array/
 */

/**
 * @param {number[]} nums
 * @return {number}
 */
function differenceOfSum(nums) {
  function getDigitSum(num) {
    let sum = 0;

    while (num > 0) {
      const digit = num % 10;
      sum += digit;
      num = Math.floor(num / 10);
    }
    return sum;
  }

  const elemSum = nums.reduce((acc, num) => num + acc);
  const digitSum = nums.reduce((acc, n) => {
    return getDigitSum(n) + acc;
  }, 0);

  return Math.abs(elemSum - digitSum);
}
