
/**
 * LeetCode problem # 688, 'Knight Probability in Chessboard'
 * https://leetcode.com/problems/knight-probability-in-chessboard/
 */

class Solution {
    public static final int[] DIR_ROW = { -1, -2, -2, -1, 1, 2, 2, 1 };
    public static final int[] DIR_COL = { -2, -1, 1, 2, 2, 1, -1, -2 };

    public double knightProbability(int n, int k, int r, int c) {
        double[][] grid = new double[n][n];
        grid[r][c] = 1;

        for (int i = 0; i < k; ++i) {
            double[][] ngrid = new double[n][n];
            for (int row = 0; row < n; ++row) {
                for (int col = 0; col < n; ++col) {
                    if (grid[row][col] == 0) {
                        continue;
                    }

                    for (int j = 0; j < 8; ++j) {
                        int nrow = row + DIR_ROW[j];
                        int ncol = col + DIR_COL[j];
                        if (nrow < 0 || nrow >= n || ncol < 0 || ncol >= n) {
                            continue;
                        }
                        ngrid[nrow][ncol] += grid[row][col] / 8.0;
                    }
                }
            }
            grid = ngrid;
        }

        double p = 0.0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                p += grid[i][j];
            }
        }
        return p;
    }
}
