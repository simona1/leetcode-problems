/**
 * LeetCode problem # 2637, 'Promise Time Limit'
 * https://leetcode.com/problems/promise-time-limit
 */

/**
 * @param {Function} fn
 * @param {number} t
 * @return {Function}
 */

const rejectMessage = "Time Limit Exceeded";

var timeLimit = function (fn, t) {
  return async function (...args) {
    const promiseArr = [
      fn(...args),
      new Promise((_resolve, reject) =>
        setTimeout(() => reject(rejectMessage), t)
      ),
    ];
    const res = await Promise.race(promiseArr);

    return res;
  };
};

/**
 * const limited = timeLimit((t) => new Promise(res => setTimeout(res, t)), 100);
 * limited(150).catch(console.log) // "Time Limit Exceeded" at t=100ms
 */
