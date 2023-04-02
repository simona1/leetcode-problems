/**
 * LeetCode problem # 1880, 'Check if Word Equals Summation of Two Words'
 * https://leetcode.com/problems/check-if-word-equals-summation-of-two-words
 */
/**
 * @param {string} firstWord
 * @param {string} secondWord
 * @param {string} targetWord
 * @return {boolean}
 */
function isSumEqual(firstWord, secondWord, targetWord) {
  return (
    convertToNum(targetWord) ===
    convertToNum(firstWord) + convertToNum(secondWord)
  );
}

function convertToNum(word) {
  return parseInt(
    word
      .split("")
      .map((char) => char.charCodeAt(0) - 97)
      .join("")
  );
}
