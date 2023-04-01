/**
 * LeetCode problem # 1941, 'Check if All Characters Have Equal Number of Occurrences'
 * https://leetcode.com/problems/check-if-all-characters-have-equal-number-of-occurrences/
 */

/**
 * @param {string} s
 * @return {boolean}
 */
function areOccurrencesEqual(s) {
  const freq = {};

  for (const c of s) {
    freq[c] = (freq[c] ?? 0) + 1;
  }

  const values = Object.values(freq);
  const first = values[0];

  return values.every((elem) => elem === first);
}
