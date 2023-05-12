/**
 * LeetCode problem # 2648, 'Generate Fibonacci Sequence'
 * https://leetcode.com/problems/generate-fibonacci-sequence
 */

/**
 * @return {Generator<number>}
 */
const fibGenerator = function* () {
  let a = 0;
  let b = 1;
  while (true) {
    yield a;
    let c = a + b;
    a = b;
    b = c;
  }
};

/**
 * const gen = fibGenerator();
 * gen.next().value; // 0
 * gen.next().value; // 1
 */
