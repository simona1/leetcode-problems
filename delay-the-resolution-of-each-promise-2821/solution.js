/**
 * LeetCode problem # 2821, 'Delay the Resolution of Each Promise'
 * https://leetcode.com/problems/delay-the-resolution-of-each-promise
 */

/**
 * @param {Array<Function>} functions
 * @param {number} ms
 * @return {Array<Function>}
 */
function delayAll(functions, ms) {
  return functions.map(
    (fn) => () => new Promise((res) => setTimeout(() => res(fn()), ms))
  );
}
