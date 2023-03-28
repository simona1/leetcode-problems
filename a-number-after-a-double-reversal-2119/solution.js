/**
 * LeetCode problem # 2119, 'A Number After a Double Reversal'
 * https://leetcode.com/problems/a-number-after-a-double-reversal
 */

/**
 * @param {number} num
 * @return {boolean}
 */
function isSameAfterReversals(num) {
  return num % 10 !== 0 || num === 0;
}
