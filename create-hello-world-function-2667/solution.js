/**
 * LeetCode problem # 2667, 'Create Hello World Function'
 * https://leetcode.com/problems/create-hello-world-function
 */

/**
 * @return {Function}
 */
const createHelloWorld = function () {
  return function (...args) {
    return "Hello World";
  };
};

/**
 * const f = createHelloWorld();
 * f(); // "Hello World"
 */
