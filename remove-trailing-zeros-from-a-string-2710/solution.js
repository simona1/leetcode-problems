/**
 * LeetCode problem # 2710, 'Remove Trailing Zeros From a String'
 * https://leetcode.com/problems/remove-trailing-zeros-from-a-string/
 */

/**
 * @param {string} num
 * @return {string}
 */
function removeTrailingZeros(num) {
  return num.replace(/0+$/, "");
}
