/**
 * LeetCode problem # 2729, 'Check if The Number is Fascinating'
 * https://leetcode.com/problems/check-if-the-number-is-fascinating
 */

/**
 * @param {number} n
 * @return {boolean}
 */
function isFascinating(n) {
  const num = (n + "" + 2 * n + "" + 3 * n).split("");
  const digitCounts = Array(9).fill(0);

  for (let i = 0; i < num.length; ++i) {
    if (num[i] === "0") {
      return false;
    }
    const index = Number(num[i]);
    digitCounts[index - 1]++;
  }
  return digitCounts.every((elem) => elem == 1);
}
