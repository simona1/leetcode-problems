/**
 * LeetCode problem # 2264, 'Largest 3-Same-Digit Number in String'
 * https://leetcode.com/problems/largest-3-same-digit-number-in-string
 */

/**
 * @param {string} num
 * @return {string}
 */
function largestGoodInteger(num) {
  let res = -1;
  for (let i = 1; i < num.length; ++i) {
    const prev = num[i - 1];
    const curr = num[i];
    if (i < num.length - 1) {
      const next = num[i + 1];
      if (prev === curr && curr === next) {
        res = Math.max(res, Number(prev + curr + next));
      }
    }
  }
  if (res === -1) {
    return "";
  }
  return res == 0 ? "000" : String(res);
}
