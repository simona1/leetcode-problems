/**
 * LeetCode problem # 2666, 'Allow One Function Call'
 * https://leetcode.com/problems/allow-one-function-call
 */

/**
 * @param {Function} fn
 * @return {Function}
 */
var once = function (fn) {
  let wasCalled = false;
  let res = undefined;

  return function (...args) {
    res = !wasCalled ? fn(...args) : undefined;
    wasCalled = true;
    return res;
  };
};

/**
 * let fn = (a,b,c) => (a + b + c)
 * let onceFn = once(fn)
 *
 * onceFn(1,2,3); // 6
 * onceFn(2,3,6); // returns undefined without calling fn
 */
