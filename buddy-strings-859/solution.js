/**
 * LeetCode problem # 859, 'Buddy Strings'
 * https://leetcode.com/problems/buddy-strings/
 */

/**
 * @param {string} s
 * @param {string} goal
 * @return {boolean}
 */

function buddyStrings(s, goal) {
  let i = -1;
  let j = -1;

  if (s.length !== goal.length) {
    return false;
  }

  if (s === goal) {
    if (new Set(s).size < s.length) {
      return true;
    }
    return false;
  }

  for (const ct in s) {
    if (s[ct] === goal[ct]) {
      continue;
    }

    if (i === -1) {
      i = ct;
    } else if (j === -1) {
      j = ct;
    } else {
      return false;
    }
  }

  return s[i] === goal[j] && s[j] === goal[i];
}
