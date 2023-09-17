/**
 * LeetCode problem # 2757, 'Generate Circular Array Values'
 * https://leetcode.com/problems/generate-circular-array-values
 */

/**
 * @param {Array<number>} arr
 * @param {number} startIndex
 * @yields {number}
 */
const cycleGenerator = function* (arr, startIndex) {
  let index = startIndex;
  const n = arr.length;

  while (true) {
    const jump = yield arr[index];
    index = (index + n + (jump % n)) % n;
  }
};

/**
 *  const gen = cycleGenerator([1,2,3,4,5], 0);
 *  gen.next().value  // 1
 *  gen.next(1).value // 2
 *  gen.next(2).value // 4
 *  gen.next(6).value // 5
 */
