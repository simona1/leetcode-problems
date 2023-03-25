/**
 * LeetCode problem # 762, 'Prime Number of Set Bits in Binary Representation'
 * https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation
 */

/**
 * @param {number} left
 * @param {number} right
 * @return {number}
 */
function countPrimeSetBits(left, right) {
  let count = 0;

  for (let i = left; i <= right; ++i) {
    if (isPrime(countOnes(i.toString(2)))) {
      ++count;
    }
  }
  return count;
}

function countOnes(str) {
  return [...str].filter((c) => c === "1").length;
}

function isPrime(n) {
  if (n === 1) {
    return false;
  }
  for (let i = 2; i < n; ++i) {
    if (n % i === 0) {
      return false;
    }
  }
  return true;
}
