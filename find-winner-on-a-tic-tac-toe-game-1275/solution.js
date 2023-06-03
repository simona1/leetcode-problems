/**
 * LeetCode problem # 1275, 'Find Winner on a Tic Tac Toe Game'
 * https://leetcode.com/problems/find-winner-on-a-tic-tac-toe-game/
 */

/**
 * @param {number[][]} moves
 * @return {string}
 */
var tictactoe = function (moves) {
  if (moves.length < 5) {
    return "Pending";
  }
  const arr = [...new Array(3)].map((elem) => new Array(3).fill(NaN));

  for (let i = 0; i < moves.length; ++i) {
    const [a, b] = moves[i];
    arr[a][b] = i % 2 == 0 ? "A" : "B";
  }
  return checkRowAndCol();

  function checkRowAndCol() {
    for (let i = 0; i < 3; ++i) {
      if (arr[i][0] === arr[i][1] && arr[i][1] === arr[i][2]) {
        return arr[i][0];
      }

      if (arr[0][i] === arr[1][i] && arr[1][i] === arr[2][i]) {
        return arr[0][i];
      }
    }

    if (arr[0][0] === arr[1][1] && arr[1][1] === arr[2][2]) {
      return arr[0][0];
    }

    if (arr[2][0] === arr[1][1] && arr[1][1] === arr[0][2]) {
      return arr[0][2];
    }

    if (moves.length === 9) {
      return "Draw";
    }
    return "Pending";
  }
};
