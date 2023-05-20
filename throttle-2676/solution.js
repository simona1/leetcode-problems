/**
 * LeetCode problem # 2676, 'Throttle'
 * https://leetcode.com/problems/throttle/
 */

/**
 * @param {Function} fn
 * @param {number} t
 * @return {Function}
 */

const throttle = function (fn, t) {
  let isPending = false;
  let nextArgs = null;

  const res = function (...args) {
    nextArgs = null;
    if (isPending) {
      nextArgs = args;
    } else {
      fn(...args);
      isPending = true;
      setTimeout(() => {
        isPending = false;
        if (nextArgs !== null) {
          res(...nextArgs);
        }
      }, t);
    }
  };
  return res;
};

/**
 * const throttled = throttle(console.log, 100);
 * throttled("log"); // logged immediately.
 * throttled("log"); // logged at t=100ms.
 */
