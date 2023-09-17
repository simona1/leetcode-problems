/**
 * LeetCode problem # 125, 'Valid Palindrome'
 * https://leetcode.com/problems/valid-palindrome
 */

/**
 * @param {string} s
 * @return {boolean}
 */
function isPalindrome(s) {
  let i = 0;
  let j = s.length - 1;

  while (i < j) {
    const a = s[i];
    const b = s[j];

    if (!isAlphanumeric(a)) {
      ++i;
      continue;
    }

    if (!isAlphanumeric(b)) {
      --j;
      continue;
    }

    if (isLetter(a) && isLetter(b)) {
      if (a.toLowerCase() !== b.toLowerCase()) {
        return false;
      }
    } else {
      if (a !== b) {
        return false;
      }
    }

    ++i;
    --j;
  }
  return true;
}

function isLetter(c) {
  return /^[a-zA-Z]$/.test(c);
}

function isAlphanumeric(c) {
  return /^[a-zA-Z0-9]$/.test(c);
}
