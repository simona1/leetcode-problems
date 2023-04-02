/**
 * LeetCode problem # 2169, 'Count Operations to Obtain Zero'
 * https://leetcode.com/problems/count-operations-to-obtain-zero
 */

/**
 * @param {number} num1
 * @param {number} num2
 * @return {number}
 */
function countOperations(num1, num2) {
  let count = 0;
  while (true) {
    if (num1 == 0 || num2 == 0) {
      break;
    }
    if (num1 > num2) {
      num1 -= num2;
    } else {
      num2 -= num1;
    }
    ++count;
  }
  return count;
}
