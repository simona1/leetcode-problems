/**
 * LeetCode problem # 657, 'Robot Return to Origin'
 * https://leetcode.com/problems/robot-return-to-origin
 */

/**
 * @param {string} moves
 * @return {boolean}
 */
var judgeCircle = function (moves) {
  const fr = { U: 0, D: 0, L: 0, R: 0 };

  for (const move of moves) {
    fr[move] = (fr[move] ?? 0) + 1;
  }

  return fr["D"] === fr["U"] && fr["L"] === fr["R"];
};
