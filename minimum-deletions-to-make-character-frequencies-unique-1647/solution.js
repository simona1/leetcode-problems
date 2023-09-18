/**
 * LeetCode problem # 1647, 'Minimum Deletions to Make Character Frequencies Unique'
 * https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique
 */

/**
 * @param {string} s
 * @return {number}
 */
function minDeletions(s) {
  const freq = Array(26).fill(0);
  const n = s.length;
  for (let i = 0; i < n; ++i) {
    ++freq[s.charCodeAt(i) - "a".charCodeAt(0)];
  }
  freq.sort((a, b) => a - b);

  let res = 0;
  let maxPossible = n;
  for (let i = freq.length - 1; i >= 0 && freq[i] > 0; --i) {
    if (freq[i] > maxPossible) {
      res += freq[i] - maxPossible;
      freq[i] = maxPossible;
    }
    maxPossible = Math.max(0, freq[i] - 1);
  }
  return res;
}
