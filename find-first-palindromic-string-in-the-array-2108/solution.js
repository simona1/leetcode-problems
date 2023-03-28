/**
 * LeetCode problem # 2108, 'Find First Palindromic String in the Array'
 * https://leetcode.com/problems/find-first-palindromic-string-in-the-array
 */

/**
 * @param {string[]} words
 * @return {string}
 */
function firstPalindrome(words) {
  for (const word of words) {
    if (isPalindrome(word)) {
      return word;
    }
  }
  return "";
}

function isPalindrome(str) {
  let i = 0;
  let j = str.length - 1;
  while (i < j) {
    if (str[i] !== str[j]) {
      return false;
    }
    ++i;
    --j;
  }
  return true;
}
