/**
 * LeetCode problem # 2627, 'Debounce'
 * https://leetcode.com/problems/debounce/
 */

/**
 * @param {Function} fn
 * @param {number} t milliseconds
 * @return {Function}
 */
const debounce = function (fn, t) {
  let curr;
  return function (...args) {
    clearTimeout(curr);
    curr = setTimeout(() => {
      fn(...args);
    }, t);
  };
};

/**
 * const log = debounce(console.log, 100);
 * log('Hello'); // cancelled
 * log('Hello'); // cancelled
 * log('Hello'); // Logged at t=100ms
 */
