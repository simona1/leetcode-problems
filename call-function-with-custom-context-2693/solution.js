/**
 * LeetCode problem # 2693, 'Call Function with Custom Context'
 * https://leetcode.com/problems/call-function-with-custom-context
 */

/**
 * @param {Object} context
 * @param {any[]} args
 * @return {any}
 */
Function.prototype.callPolyfill = function (context, ...args) {
  const fn = this.bind(context);
  return fn(...args);
};

/**
 * function increment() { this.count++; return this.count; }
 * increment.callPolyfill({count: 1}); // 2
 */
