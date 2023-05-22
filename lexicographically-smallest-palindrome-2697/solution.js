/**
 * LeetCode problem # 2697, 'Lexicographically Smallest Palindrome'
 * https://leetcode.com/problems/lexicographically-smallest-palindrome/
 */

/**
 * @param {string} s
 * @return {string}
 */
function makeSmallestPalindrome(s) {
  let i = 0;
  let j = s.length - 1;
  const res = [];

  while (i <= j) {
    const a = s.charAt(i);
    const b = s.charAt(j);
    if (a <= b) {
      res[i] = a;
      res[j] = a;
    } else {
      res[i] = b;
      res[j] = b;
    }
    ++i;
    --j;
  }
  return res.join("");
}
