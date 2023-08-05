/**
 * LeetCode problem # 2361, 'Minimum Costs Using the Train Line'
 * https://leetcode.com/problems/minimum-costs-using-the-train-line/
 */

/**
 * @param {number[]} regular
 * @param {number[]} express
 * @param {number} expressCost
 * @return {number[]}
 */
function minimumCosts(regular, express, expressCost) {
  let reg = 0;
  let exp = expressCost;
  const res = [];
  for (let i = 0; i < regular.length; ++i) {
    reg = Math.min(reg + regular[i], exp + express[i]);
    exp = Math.min(exp + express[i], reg + expressCost);
    res.push(Math.min(reg, exp));
  }
  return res;
}
