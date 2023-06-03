/**
 * LeetCode problem # 2649, 'Nested Array Generator'
 * https://leetcode.com/problems/nested-array-generator/
 */

/**
 * @param {Array} arr
 * @return {Generator}
 */
const inorderTraversal = function* (arr) {
  for (const elem of arr) {
    if (Array.isArray(elem)) {
      yield* inorderTraversal(elem);
    } else {
      yield elem;
    }
  }
};

/**
 * const gen = inorderTraversal([1, [2, 3]]);
 * gen.next().value; // 1
 * gen.next().value; // 2
 * gen.next().value; // 3
 */
