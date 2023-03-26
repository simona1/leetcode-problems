/**
 * LeetCode problem # 2601, 'Prime Subtraction Operation'
 * https://leetcode.com/problems/prime-subtraction-operation
 */

/**
 * @param {number[]} nums
 * @return {boolean}
 */
function primeSubOperation(nums) {
  let prime = 0;
  for (let i = 2; i < nums[0]; ++i) {
    if (isPrime(i)) {
      prime = i;
    }
  }
  nums[0] -= prime;

  subtractPrimes(nums);
  return isAscending(nums);
}

function subtractPrimes(nums) {
  for (let i = 1; i < nums.length; ++i) {
    let prime = 0;

    for (let j = 2; j < nums[i]; ++j) {
      if (isPrime(j) && nums[i] - j > nums[i - 1]) {
        prime = j;
      }
    }

    if (nums[i] - prime > nums[i - 1]) {
      nums[i] -= prime;
    }
  }
}

function isAscending(nums) {
  for (let i = 1; i < nums.length; ++i) {
    if (nums[i] <= nums[i - 1]) {
      return false;
    }
  }
  return true;
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
