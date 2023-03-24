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

  const primes = sieve(right);

  for (let i = left; i <= right; ++i) {
    const b = i.toString(2);
    const oneCount = countOnes(b);
    if (oneCount > 1 && !primes[oneCount]) {
      ++count;
    }
  }
  return count;
}

function countOnes(str) {
  let count = 0;
  for (let i = 0; i < str.length; ++i) {
    const c = str.charAt(i);
    if (c === "1") {
      ++count;
    }
  }
  return count;
}

function sieve(n) {
  const arr = new Array(n + 1).fill(false);

  for (let i = 2; i <= n; ++i) {
    if (arr[i]) {
      continue;
    }

    for (let j = i + i; j <= n; j += i) {
      arr[j] = true;
    }
  }
  return arr;
}
