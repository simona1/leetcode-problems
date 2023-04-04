/**
 * LeetCode problem # 2303, 'Calculate Amount Paid in Taxes'
 * https://leetcode.com/problems/calculate-amount-paid-in-taxes/
 */

/**
 * @param {number[][]} brackets
 * @param {number} income
 * @return {number}
 */
function calculateTax(brackets, income) {
  let res = 0;
  let start = 0;

  for (const [end, rate] of brackets) {
    const real = Math.min(end, income);
    const tax = (real - start) * 0.01 * rate;
    res += tax;

    start = end;
    if (start >= income) {
      break;
    }
  }
  return res;
}
