/**
 * LeetCode problem # 1662, 'Check If Two String Arrays are Equivalent'
 * https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/
 */

/**
 * @param {string[]} word1
 * @param {string[]} word2
 * @return {boolean}
 */
function arrayStringsAreEqual(word1, word2) {
  // array indexes
  let i = 0;
  let j = 0;

  // char indexes
  let m = 0;
  let n = 0;

  while (i < word1.length && j < word2.length) {
    if (word1[i][m] !== word2[j][n]) {
      return false;
    }
    if (++m === word1[i].length) {
      m = 0;
      ++i;
    }

    if (++n === word2[j].length) {
      n = 0;
      ++j;
    }
  }
  return i === word1.length && j === word2.length;
}
