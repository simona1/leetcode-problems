/**
 * LeetCode problem # 2553, 'Separate the Digits in an Array'
 * https://leetcode.com/problems/separate-the-digits-in-an-array
 */

/**
 * @param {number[]} nums
 * @return {number[]}
 */

function separateDigits(nums) {
  return nums.flatMap((num) => getDigits(num));
}

function getDigits(num) {
  const res = [];
  let p = 10 ** Math.floor(Math.log10(num));

  while (p > 0) {
    res.push(Math.floor(num / p));
    num %= p;
    p = Math.floor(p / 10);
  }
  return res;
}
