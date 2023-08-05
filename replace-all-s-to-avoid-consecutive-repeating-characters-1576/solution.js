/**
 * LeetCode problem # 1576, 'Replace All ?'s to Avoid Consecutive Repeating Characters'
 * https://leetcode.com/problems/replace-all-s-to-avoid-consecutive-repeating-characters/
 */

/**
 * @param {string} s
 * @return {string}
 */
function modifyString(s) {
  const chars = s.split("");
  for (let i = 0; i < chars.length; ++i) {
    chars[i] = getNewChar(chars, i);
  }
  return chars.join("");
}

function getNewChar(arr, i) {
  if (arr[i] !== "?") {
    return arr[i];
  }

  if (arr[i - 1] !== "a" && arr[i + 1] !== "a") {
    return "a";
  }
  if (arr[i - 1] !== "b" && arr[i + 1] !== "b") {
    return "b";
  }
  return "c";
}
