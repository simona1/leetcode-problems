/**
 * LeetCode problem # 2278, 'Percentage of Letter in String'
 * https://leetcode.com/problems/percentage-of-letter-in-string
 */

/**
 * @param {string} s
 * @param {character} letter
 * @return {number}
 */
function percentageLetter(s, letter) {
  const total = s.length;
  let count = 0;
  for (const c of s) {
    if (c == letter) {
      ++count;
    }
  }
  return Math.floor((count * 100) / total);
}
