/**
 * LeetCode problem # 2085, 'Count Common Words With One Occurrence'
 * https://leetcode.com/problems/count-common-words-with-one-occurrence/
 */

/**
 * @param {string[]} words1
 * @param {string[]} words2
 * @return {number}
 */
function countWords(words1, words2) {
  const freq1 = {};
  const freq2 = {};

  for (const word of words1) {
    freq1[word] = (freq1[word] ?? 0) + 1;
  }

  for (const word of words2) {
    freq2[word] = (freq2[word] ?? 0) + 1;
  }

  const uniq1 = Object.keys(freq1).filter((elem) => freq1[elem] === 1);
  const uniq2 = Object.keys(freq2).filter((elem) => freq2[elem] === 1);

  const set = new Set();
  for (const u of uniq1) {
    set.add(u);
  }

  let res = 0;
  for (const u of uniq2) {
    if (set.has(u)) {
      ++res;
    }
  }
  return res;
}
