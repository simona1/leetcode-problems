/**
 * LeetCode problem # 338, 'Counting Bits'
 * https://leetcode.com/problems/counting-bits/
 */

/**
 * @param {number} num
 * @return {number[]}
 */
function countBits(num) {
  const res = [];
  res.push(0);
  for (let i = 1; i <= num; ++i) {
    res.push(fastBitCount(i));
  }
  return res;
}

function memoize(fn) {
  const cache = {};
  return function (...args) {
    if (cache[args]) {
      return cache[args];
    }
    let newCall = fn.apply(null, args);
    cache[args] = newCall;
    return newCall;
  };
}

const fastBitCount = memoize(bitCount);
function bitCount(n) {
  let count = 0;
  while (n != 0) {
    n = n & (n - 1);
    ++count;
  }
  return count;
}
