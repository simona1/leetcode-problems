
/**
 * LeetCode problem # 59, 'Spiral Matrix II'
 * https://leetcode.com/problems/spiral-matrix-ii
 */

class Solution {
    static int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    // renamed function, solution 1
    public int[][] generateMatrix1(int n) {
        int[][] res = new int[n][n];
        int value = 1;

        // i goes from 0 to (n + 1) / 2

        for (int i = 0; i < (n + 1) / 2; ++i) {

            // move right
            for (int j = i; j < n - i; ++j) {
                res[i][j] = value++;
            }

            // move down
            for (int j = i + 1; j < n - i; ++j) {
                res[j][n - i - 1] = value++;
            }

            // move left
            for (int j = i + 1; j < n - i; ++j) {
                res[n - i - 1][n - j - 1] = value++;
            }

            // move up
            for (int j = i + 1; j < n - i - 1; ++j) {
                res[n - j - 1][i] = value++;
            }
        }

        return res;
    }

    // original function. solution 2, using floorMod
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int value = 1;

        int move = 0;
        int row = 0;
        int col = 0;

        // next direction is (move + 1) % 4 (because there are 4 directions and it's the
        // next move)
        while (value <= n * n) {
            res[row][col] = value++;

            int dr = dirs[move][0];
            int dc = dirs[move][1];

            int nr = Math.floorMod(row + dr, n);
            int nc = Math.floorMod(col + dc, n);

            if (res[nr][nc] != 0) {
                move = (move + 1) % 4;
            }

            row += dr;
            col += dc;
        }
        return res;
    }
}
