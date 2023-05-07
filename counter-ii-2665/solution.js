/**
 * LeetCode problem # 2665, 'Counter II'
 * https://leetcode.com/problems/counter-ii
 */

/**
 * @param {integer} init
 * @return { increment: Function, decrement: Function, reset: Function }
 */
const createCounter = function (init) {
  let curr = init;

  const increment = () => {
    ++curr;
    return curr;
  };

  const decrement = () => {
    --curr;
    return curr;
  };

  const reset = () => {
    curr = init;
    return curr;
  };

  return {
    decrement,
    increment,
    reset,
  };
};

/**
 * const counter = createCounter(5)
 * counter.increment(); // 6
 * counter.reset(); // 5
 * counter.decrement(); // 4
 */
