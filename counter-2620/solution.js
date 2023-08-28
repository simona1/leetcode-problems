/**
 * LeetCode problem # 2620, 'Counter'
 * https://leetcode.com/problems/counter
 */

/**
 * @param {number} n
 * @return {Function} counter
 */
function createCounter(n) {
  const curr = counter(n);
  return () => curr.next().value;
}

function* counter(n) {
  while (true) {
    yield n++;
  }
}

/**
 * const counter = createCounter(10)
 * counter() // 10
 * counter() // 11
 * counter() // 12
 */
