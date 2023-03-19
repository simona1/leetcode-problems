/*
 * LeetCode problem # 2596, 'Check Knight Tour Configuration'
 * https://leetcode.com/problems/check-knight-tour-configuration
 */

/**
 * @param {number[][]} grid
 * @return {boolean}
 */
var checkValidGrid = function (grid) {
  const moves = {};
  const row = grid.length;
  const col = grid[0].length;

  for (let i = 0; i < row; ++i) {
    for (let j = 0; j < col; ++j) {
      moves[grid[i][j]] = [i, j];
    }
  }

  for (let i = 1; i < row * row; ++i) {
    const curr = moves[i - 1];
    const next = moves[i];
    const dr = Math.abs(next[0] - curr[0]);
    const dc = Math.abs(next[1] - curr[1]);
    if ((dr == 2 && dc == 1) || (dr == 1 && dc == 2)) {
      continue;
    }
    return false;
  }
  const zero = moves[0];
  return zero[0] === 0 && zero[1] === 0;
};
