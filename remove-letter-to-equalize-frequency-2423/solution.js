/**
 * LeetCode problem # 2423, 'Remove Letter To Equalize Frequency'
 * https://leetcode.com/problems/remove-letter-to-equalize-frequency
 */

/**
 * @param {string} word
 * @return {boolean}
 */
function equalFrequency(word) {
  const freq = {};
  for (const c of word) {
    freq[c] = (freq[c] ?? 0) + 1;
  }
  const freq2 = {};
  for (const val of Object.values(freq)) {
    freq2[val] = (freq2[val] ?? 0) + 1;
  }
  return isGood(freq2);
}
function isGood(freq2) {
  const keys = Object.keys(freq2).map(Number);
  // more than 2
  if (keys.length > 2) {
    return false;
  }

  // one unique
  if (keys.length === 1) {
    const val = keys[0];
    return val === 1 ? freq2[val] >= 2 : freq2[val] === 1;
  }

  // Two unique
  if (keys.length === 2) {
    const [smallerFreq, largerFreq] = keys.sort((a, b) => a - b);

    if (smallerFreq === 1 && freq2[smallerFreq] === 1) {
      return true;
    }

    if (largerFreq - smallerFreq === 1 && freq2[largerFreq] === 1) {
      return true;
    }
  }
  return false;
}
