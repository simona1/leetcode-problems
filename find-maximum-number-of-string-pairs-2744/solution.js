/**
 * LeetCode problem # 2744, 'Find Maximum Number of String Pairs'
 * https://leetcode.com/problems/find-maximum-number-of-string-pairs
 */

/**
 * @param {string[]} words
 * @return {number}
 */
function maximumNumberOfStringPairs(words) {
  const set = new Set();
  let res = 0;

  for (const word of words) {
    const curr = word[0] > word[1] ? word[1] + word[0] : word;
    if (set.has(curr)) {
      ++res;
      set.delete(curr);
    } else {
      set.add(curr);
    }
  }
  return res;
}
