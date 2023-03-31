/**
 * LeetCode problem # 2601, 'Prime Subtraction Operation'
 * https://leetcode.com/problems/prime-subtraction-operation
 */

/**
 * @param {number[]} nums
 * @return {boolean}
 */
function primeSubOperation(nums) {
  const primes = generatePrimes(1000);
  subtractPrimes(nums, primes);
  return isAscendingOrder(nums);
}

function generatePrimes(max) {
  const primes = [];

  for (let i = 2; i <= max; ++i) {
    let isPrime = true;
    for (const j of primes) {
      if (i % j === 0) {
        isPrime = false;
        break;
      }
    }
    if (isPrime) {
      primes.push(i);
    }
  }
  return primes;
}

function isAscendingOrder(nums) {
  for (let i = 1; i < nums.length; ++i) {
    if (nums[i] <= nums[i - 1]) {
      return false;
    }
  }
  return true;
}

function subtractPrimes(nums, primes) {
  for (let i = 0; i < nums.length; ++i) {
    let prime = 0;

    for (const j of primes) {
      if (nums[i] - j > (nums[i - 1] ?? 0)) {
        prime = j;
      }
    }
    nums[i] -= prime;
  }
}
