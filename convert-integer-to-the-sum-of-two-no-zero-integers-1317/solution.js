/**
 * LeetCode problem # 1317, 'Convert Integer to the Sum of Two No-Zero Integers'
 * https://leetcode.com/problems/convert-integer-to-the-sum-of-two-no-zero-integers
 */

/**
 * @param {number} n
 * @return {number[]}
 */
function getNoZeroIntegers(n) {
  let a = 1;
  let b = n - a;

  while (hasZero(a) || hasZero(b)) {
    ++a;
    b = n - a;
  }
  return [a, b];
}

function hasZero(n) {
  while (n > 0) {
    if (n % 10 === 0) {
      return true;
    }
    n = Math.floor(n / 10);
  }
  return false;
}
