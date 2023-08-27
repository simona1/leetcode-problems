/**
 * LeetCode problem # 1281, 'Subtract the Product and Sum of Digits of an Integer'
 * https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
 */

/**
 * @param {number} n
 * @return {number}
 */
function subtractProductAndSum(n) {
  let sum = 0;
  let prod = 1;
  for (const digit of digits(n)) {
    sum += digit;
    prod *= digit;
  }
  return prod - sum;
}

function* digits(num) {
  while (num > 0) {
    const digit = num % 10;
    yield digit;
    num = Math.floor(num / 10);
  }
}

function* getDigits(num) {
  while (num > 0) {
    const mod = num % 10;
    yield mod;
    num = (num - mod) / 10;
  }
}
