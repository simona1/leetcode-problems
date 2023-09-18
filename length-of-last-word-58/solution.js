/**
 * LeetCode problem # 58, 'Length of Last Word'
 * https://leetcode.com/problems/length-of-last-word
 */
/**
 * @param {string} s
 * @return {number}
 */

function lengthOfLastWord(s) {
  let count = 0;
  let n = s.length;

  for (let i = n - 1; i >= 0; --i) {
    if (count > 0 && s[i] === " ") {
      break;
    }
    if (s[i] !== " ") {
      ++count;
      continue;
    }
  }
  return count;
}
