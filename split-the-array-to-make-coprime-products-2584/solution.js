/*
 * LeetCode problem # 2584, 'Split Array to Make Coprime Products'
 * https://leetcode.com/problems/split-the-array-to-make-coprime-products
 */

/**
 * @param {number[]} nums
 * @return {number}
 */

function sieveSmallestPrimeFactors(n) {
  const arr = new Array(n + 1).fill(0);

  for (let i = 2; i <= n; ++i) {
    if (arr[i] !== 0) {
      continue;
    }
    for (let j = i; j <= n; j += i) {
      if (arr[j] === 0) {
        arr[j] = i;
      }
    }
  }

  return arr;
}

const sieve = sieveSmallestPrimeFactors(1000001);

function getFactors(n) {
  const factors = [];

  while (n > 1) {
    const factor = sieve[n];
    factors.push(factor);
    n /= factor;
  }

  return factors;
}

const findValidSplit = function (nums) {
  const left = {};
  const right = {};
  let rightCount = 0;
  let leftCount = 0;

  for (const num of nums) {
    const curr = getFactors(num);

    for (const c of curr) {
      if (!right[c]) {
        ++rightCount;
      }
      right[c] = (right[c] ?? 0) + 1;
    }
  }
  const total = rightCount;

  for (let i = 0; i < nums.length - 1; ++i) {
    const num = nums[i];
    const fact = getFactors(num);

    for (const f of fact) {
      if (!left[f]) {
        ++leftCount;
      }

      left[f] = (left[f] ?? 0) + 1;
      right[f] -= 1;

      if (right[f] == 0) {
        delete right[f];
        --rightCount;
      }
    }

    if (rightCount + leftCount === total) {
      return i;
    }
  }
  return -1;
};
