/**
 * LeetCode problem # 2645, 'Minimum Additions to Make Valid String'
 * https://leetcode.com/problems/minimum-additions-to-make-valid-string/
 */

/**
 * @param {string} word
 * @return {number}
 */

function addMinimum(word) {
  let i = 0;
  let res = 0;
  while (true) {
    const stack = [];
    while (i < word.length && (stack.length === 0 || stack.at(-1) < word[i])) {
      stack.push(word[i++]);
    }
    if (stack.length === 0) {
      break;
    }
    res += 3 - stack.length;
  }
  return res;
}
