/**
 * LeetCode problem # 2259, 'Remove Digit From Number to Maximize Result'
 * https://leetcode.com/problems/remove-digit-from-number-to-maximize-result
 */

/**
 * @param {string} number
 * @param {character} digit
 * @return {string}
 */
function removeDigit(number, digit) {
  let res = "0";
  for (let i = 0; i < number.length; ++i) {
    if (number[i] === digit) {
      const curr = number.substring(0, i) + number.substring(i + 1);
      if (curr > res) {
        res = curr;
      }
    }
  }
  return res;
}
