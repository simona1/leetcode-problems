/**
 * LeetCode problem # 2413, 'Smallest Even Multiple'
 * https://leetcode.com/problems/smallest-even-multiple/
 */

/**
 * @param {number} n
 * @return {number}
 */
function smallestEvenMultiple(n) {
  return n % 2 == 0 ? n : n * 2;
}
