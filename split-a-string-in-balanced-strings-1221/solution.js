/**
 * LeetCode problem # 1221, 'Split a String in Balanced Strings'
 * https://leetcode.com/problems/split-a-string-in-balanced-strings
 */

/**
 * @param {string} s
 * @return {number}
 */

function balancedStringSplit(s) {
  let balance = 0;
  return [...s].reduce((acc, curr) => {
    balance += curr === "L" ? 1 : -1;
    return balance === 0 ? acc + 1 : acc;
  }, 0);
}
