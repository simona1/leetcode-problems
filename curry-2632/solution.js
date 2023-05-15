/**
 * LeetCode problem # 2632, 'Curry'
 * https://leetcode.com/problems/curry/
 */

/**
 * @param {Function} fn
 * @return {Function}
 */
function curry(fn) {
  return function curried(...args) {
    if (fn.length <= args.length) {
      return fn(...args);
    }
    return (...newArgs) => curried(...args, ...newArgs);
  };
}

/**
 * function sum(a, b) { return a + b; }
 * const csum = curry(sum);
 * csum(1)(2) // 3
 */
