/**
 * LeetCode problem # 1742, 'Maximum Number of Balls in a Box'
 * https://leetcode.com/problems/maximum-number-of-balls-in-a-box
 */

/**
 * @param {number} lowLimit
 * @param {number} highLimit
 * @return {number}
 */
function countBalls(lowLimit, highLimit) {
  const freq = {};

  for (let i = lowLimit; i <= highLimit; ++i) {
    const curr = digitSum(i);
    freq[curr] = (freq[curr] ?? 0) + 1;
  }

  let largest = -1;
  for (const value of Object.values(freq)) {
    largest = Math.max(largest, value);
  }
  return largest;
}

function digitSum(num) {
  const digits = (num + "").split("");
  return digits.map((elem) => Number(elem)).reduce((acc, num) => acc + num, 0);
}
