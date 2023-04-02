/**
 * LeetCode problem # 2609, 'Find the Longest Balanced Substring of a Binary String'
 * https://leetcode.com/problems/find-the-longest-balanced-substring-of-a-binary-string/
 */

/**
 * @param {string} s
 * @return {number}
 */
var findTheLongestBalancedSubstring = function (s) {
  const subs = getSubstrings(s);
  let res = "";

  for (const sub of subs) {
    if (isBalanced(sub)) {
      res = sub.length > res.length ? sub : res;
    }
  }
  return res.length;
};

function getSubstrings(s) {
  let substrings = [];
  for (let i = 0; i < s.length; ++i) {
    for (let j = i + 1; j <= s.length; ++j) {
      substrings.push(s.slice(i, j));
    }
  }
  return substrings;
}

function isBalanced(s) {
  if (s.length === 0) {
    return true;
  }

  let countZeros = 0;
  let countOnes = 0;
  for (let i = 0; i < s.length; i++) {
    if (s[i] === "0") {
      countZeros++;
      if (countOnes > 0) {
        return false;
      }
    } else if (s[i] === "1") {
      countOnes++;
    }
  }
  return countZeros === countOnes;
}
