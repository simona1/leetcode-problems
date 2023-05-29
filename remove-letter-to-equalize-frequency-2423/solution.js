/**
 * LeetCode problem # 2423, 'Remove Letter To Equalize Frequency'
 * https://leetcode.com/problems/remove-letter-to-equalize-frequency
 */

/**
 * @param {string} word
 * @return {boolean}
 */
function equalFrequency(word) {
  const diff = (a, b) => Math.abs(a - b);

  const counts = [...word].reduce((a, c) => {
    a[c.charCodeAt(0) - 97]++;
    return a;
  }, Array(26).fill(0));

  for (let i = 0; i < 26; ++i) {
    if (!counts[i]) {
      continue;
    }
    const newCounts = [...counts];
    newCounts[i]--;
    const set = new Set(newCounts);

    if (set.size === 1) {
      return true;
    }
    if (set.size === 2 && set.has(0)) {
      return true;
    }
  }
  return false;
}
