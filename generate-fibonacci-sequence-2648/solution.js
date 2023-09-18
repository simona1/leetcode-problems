/**
 * LeetCode problem # 2648, 'Generate Fibonacci Sequence'
 * https://leetcode.com/problems/generate-fibonacci-sequence
 */

/**
 * @return {Generator<number>}
 */
const fibGenerator1 = function* () {
  let a = 1;
  let b = 0;

  while (true) {
    [a, b] = [b, a + b];
    yield a;
  }
};

/**
 * const gen = fibGenerator();
 * gen.next().value; // 0
 * gen.next().value; // 1
 */
