/**
 * LeetCode problem # 917, 'Reverse Only Letters'
 * https://leetcode.com/problems/reverse-only-letters
 */

/**
 * @param {string} s
 * @return {string}
 */
const reverseOnlyLetters = function (s) {
  const stack = [];
  for (const char of s) {
    if (isLetter(char)) {
      stack.push(char);
    }
  }

  const res = [];
  for (const char of s) {
    res.push(isLetter(char) ? stack.pop() : char);
  }

  return res.join("");
};

const isLetter = (char) => {
  return /[a-zA-Z]/.test(char);
};
