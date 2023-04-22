/**
 * LeetCode problem # 1312, 'Minimum Insertion Steps to Make a String
 * Palindrome'
 * https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome
 */

/**
 * @param {string} s
 * @return {number}
 */
function minInsertions(s) {
  const n = s.length;

  const cache = Array(n + 1)
    .fill(null)
    .map((elem) => Array(n + 1).fill(-1));

  const solve = (i, j) => {
    if (j <= i + 1) {
      return 0;
    }
    if (cache[i][j] >= 0) {
      return cache[i][j];
    }

    if (s[i] === s[j - 1]) {
      cache[i][j] = solve(i + 1, j - 1);
      return cache[i][j];
    }
    const opt1 = 1 + solve(i, j - 1);
    const opt2 = 1 + solve(i + 1, j);
    cache[i][j] = Math.min(opt1, opt2);

    return cache[i][j];
  };

  return solve(0, n);
}
