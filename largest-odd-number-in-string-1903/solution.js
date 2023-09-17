/**
 * LeetCode problem # 1903, 'Largest Odd Number in String'
 * https://leetcode.com/problems/largest-odd-number-in-string
 */

/**
 * @param {string} num
 * @return {string}
 */
const largestOddNumber = function (num) {
  // Capture group that ends with odd digit
  const regex = /(.*[13579])[02468]*/;
  const match = num.match(regex);
  return match ? match[1] : "";
};
