/**
 * LeetCode problem # 2553, 'Separate the Digits in an Array'
 * https://leetcode.com/problems/separate-the-digits-in-an-array
 */

/**
 * @param {number[]} nums
 * @return {number[]}
 */
function separateDigits(nums) {
  const res = [];
  for (const num of nums) {
    const digits = (num + "").split("");
    for (const digit of digits) {
      res.push(Number(digit));
    }
  }
  return res;
}

// Solution with flatMap

/**
 * @param {number[]} nums
 * @return {number[]}
 */
function separateDigits(nums) {
  return nums.flatMap((num) => (num + "").split("")).map(Number);
}
