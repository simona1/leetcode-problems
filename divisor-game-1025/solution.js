/**
 * LeetCode problem # 1025, 'Divisor Game'
 * https://leetcode.com/problems/divisor-game
 */

/**
 * @param {number} n
 * @return {boolean}
 */
function divisorGame(n) {
  let turn = 0;
  while (n > 1) {
    for (let i = 1; i < n; ++i) {
      if (n % i === 0) {
        n -= i;
        ++turn;
        break;
      }
    }
  }
  return turn % 2 === 1;
}
