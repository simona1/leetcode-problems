/**
 * LeetCode problem # 1417, 'Reformat The String'
 * https://leetcode.com/problems/reformat-the-string
 */

/**
 * @param {string} s
 * @return {string}
 */
function reformat(s) {
  const digits = s.split("").filter((c) => c.charCodeAt(0) < 97);
  const letters = s.split("").filter((c) => c.charCodeAt(0) >= 97);

  if (1 < Math.abs(letters.length - digits.length)) {
    return "";
  }
  let res = null;
  if (digits.length < letters.length) {
    res = letters.map((elem, i) => [elem, digits[i]]);
  } else {
    res = digits.map((elem, i) => [elem, letters[i]]);
  }

  return res.flat().join("");
}
