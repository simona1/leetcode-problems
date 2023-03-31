/**
 * LeetCode problem # 2283, 'Check if Number Has Equal Digit Count and Digit Value'
 * https://leetcode.com/problems/check-if-number-has-equal-digit-count-and-digit-value
 */

/**
 * @param {string} num
 * @return {boolean}
 */
function digitCount(num) {
  const counts = {};

  for (const char of num) {
    counts[char] = (counts[char] ?? 0) + 1;
  }

  for (const [key, value] of Object.entries(counts)) {
    if (value !== Number(num[key])) {
      return false;
    }
  }

  return true;
}
