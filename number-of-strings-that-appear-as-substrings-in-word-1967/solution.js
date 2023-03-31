/**
 * LeetCode problem # 1967, 'Number of Strings That Appear as Substrings in Word'
 * https://leetcode.com/problems/number-of-strings-that-appear-as-substrings-in-word/
 */

/**
 * @param {string[]} patterns
 * @param {string} word
 * @return {number}
 */
function numOfStrings(patterns, word) {
  let n = 0;
  for (const p of patterns) {
    if (word.indexOf(p) !== -1) {
      ++n;
    }
  }
  return n;
}
