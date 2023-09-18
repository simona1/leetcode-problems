/**
 * LeetCode problem # 1796, 'Second Largest Digit in a String'
 * https://leetcode.com/problems/second-largest-digit-in-a-string
 */

/**
 * @param {string} s
 * @return {number}
 */
const secondHighest = function (s) {
  let highest = -1;
  let secondHighest = -1;

  for (const c of s) {
    if (c >= "0" && c <= "9") {
      const num = parseInt(c, 10);
      if (num > highest) {
        secondHighest = highest;
        highest = num;
      } else if (num > secondHighest && num < highest) {
        secondHighest = num;
      }
    }
  }
  return secondHighest;
};
