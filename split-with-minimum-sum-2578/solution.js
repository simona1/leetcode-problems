/*
 * LeetCode problem # 2578, 'Split With Minimum Sum'
 * https://leetcode.com/problems/split-with-minimum-sum
 */

/**
 * @param {number} num
 * @return {number}
 */
var splitNum = function (num) {
  const s = (num + "").split("");
  s.sort();

  const a = s.filter((c, i) => i % 2 === 0).join("");
  const b = s.filter((c, i) => i % 2 !== 0).join("");

  return parseInt(a) + parseInt(b);
};
