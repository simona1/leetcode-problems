/**
 * LeetCode problem # 2652, 'Sum Multiples'
 * https://leetcode.com/problems/sum-multiples
 */

/**
 * @param {number} n
 * @return {number}
 */
function sumOfMultiples(n) {
  let sum = 0;

  for (let i = 1; i <= n; ++i) {
    if (i % 3 === 0 || i % 5 === 0 || i % 7 === 0) {
      sum += i;
    }
  }
  return sum;
}
