/**
 * LeetCode problem # 1056, 'Confusing Number'
 * https://leetcode.com/problems/confusing-number
 */

/**
 * @param {number} n
 * @return {boolean}
 */
function confusingNumber(n) {
  // stay the same 0, 1, 8
  // invalid 2, 3, 4, 5, 7
  // become something else 6, 9

  const set = new Set();
  const invalid = ["2", "3", "4", "5", "7"];
  for (const iv of invalid) {
    set.add(iv);
  }

  const digits = (n + "").split("").reverse();
  for (let i = 0; i < digits.length; ++i) {
    const digit = digits[i];
    if (set.has(digit)) {
      return false;
    }
    if (digit === "0" || digit === "1" || digit == "8") {
      continue;
    }
    if (digit === "6") {
      digits[i] = "9";
    } else if (digit === "9") {
      digits[i] = "6";
    }
  }
  const num = Number(digits.join(""));

  if (num == n) {
    return false;
  }
  return true;
}
