/**
 * LeetCode problem # 2803, 'Factorial Generator'
 * https://leetcode.com/problems/factorial-generator/
 */

/**
 * @param {number} n
 * @yields {number}
 */
function* factorial(n) {
  let res = 1;
  if (n === 0) {
    yield res;
  }
  let count = 1;
  while (count <= n) {
    res *= count;
    ++count;
    yield res;
  }
}

/**
 * const gen = factorial(2);
 * gen.next().value; // 1
 * gen.next().value; // 2
 */
