/**
 * LeetCode problem # 2623, 'Memoize'
 * https://leetcode.com/problems/memoize/
 */

/**
 * @param {Function} fn
 */
function memoize(fn) {
  let cache = new Map();
  return function (...args) {
    const key = JSON.stringify(args);
    let value = cache.get(key);
    if (value != null) {
      return value;
    }

    value = fn(...args);
    cache.set(key, value);
    return value;
  };
}

/**
 * let callCount = 0;
 * const memoizedFn = memoize(function (a, b) {
 *	 callCount += 1;
 *   return a + b;
 * })
 * memoizedFn(2, 3) // 5
 * memoizedFn(2, 3) // 5
 * console.log(callCount) // 1
 */
