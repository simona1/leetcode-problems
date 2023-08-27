
/**
 * LeetCode problem # 723, 'Candy Crush'
 * https://leetcode.com/problems/candy-crush/
 */

class Solution {
    int m;
    int n;

    boolean findAndCrush(int[][] board) {
        boolean isComplete = true;

        // Check vertically adjacent candies
        for (int r = 1; r < m - 1; ++r) {
            for (int c = 0; c < n; ++c) {
                if (board[r][c] == 0) {
                    continue;
                }
                if (Math.abs(board[r][c]) == Math.abs(board[r - 1][c])
                        && Math.abs(board[r][c]) == Math.abs(board[r + 1][c])) {
                    board[r][c] = -Math.abs(board[r][c]);
                    board[r - 1][c] = -Math.abs(board[r - 1][c]);
                    board[r + 1][c] = -Math.abs(board[r + 1][c]);
                    isComplete = false;
                }
            }
        }

        // Check horizontally adjacent candies
        for (int r = 0; r < m; ++r) {
            for (int c = 1; c < n - 1; ++c) {
                if (board[r][c] == 0) {
                    continue;
                }
                if (Math.abs(board[r][c]) == Math.abs(board[r][c - 1])
                        && Math.abs(board[r][c]) == Math.abs(board[r][c + 1])) {
                    board[r][c] = -Math.abs(board[r][c]);
                    board[r][c - 1] = -Math.abs(board[r][c - 1]);
                    board[r][c + 1] = -Math.abs(board[r][c + 1]);
                    isComplete = false;
                }
            }
        }

        // Set the value of each candy to be crushed as 0
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (board[r][c] < 0) {
                    board[r][c] = 0;
                }
            }
        }

        return isComplete;
    }

    public void drop(int[][] board) {
        for (int c = 0; c < n; ++c) {
            int lowestZero = -1;

            // Iterate over each column
            for (int r = m - 1; r >= 0; --r) {
                if (board[r][c] == 0) {
                    lowestZero = Math.max(lowestZero, r);
                } else if (lowestZero >= 0) {
                    int temp = board[r][c];
                    board[r][c] = board[lowestZero][c];
                    board[lowestZero][c] = temp;
                    lowestZero--;
                }
            }
        }
    }

    public int[][] candyCrush(int[][] board) {
        m = board.length;
        n = board[0].length;

        while (!findAndCrush(board)) {
            drop(board);
        }
        return board;
    }
}