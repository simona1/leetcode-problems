/**
 * LeetCode problem # 168, 'Excel Sheet Column Title'
 * https://leetcode.com/problems/excel-sheet-column-title/
 */

/**
 * @param {number} columnNumber
 * @return {string}
 */
const convertToTitle = function (col) {
  const res = [];

  while (col !== 0) {
    res.push(String.fromCharCode("A".charCodeAt(0) + (--col % 26)));
    col = (col - (col % 26)) / 26;
  }
  return res.reverse().join("");
};
