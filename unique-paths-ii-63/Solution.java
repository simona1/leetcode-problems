
/**
 * LeetCode problem # 63, 'Unique Paths II'
 * https://leetcode.com/problems/unique-paths-ii/
 */

class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        if (grid[0][0] == 1) {
            return 0;
        }
        grid[0][0] = 1;

        // column 1 values
        for (int i = 1; i < row; ++i) {
            grid[i][0] = (grid[i][0] == 0 && grid[i - 1][0] == 1) ? 1 : 0;
        }

        // row 1 values
        for (int i = 1; i < col; ++i) {
            grid[0][i] = (grid[0][i] == 0 && grid[0][i - 1] == 1) ? 1 : 0;
        }

        for (int i = 1; i < row; ++i) {
            for (int j = 1; j < col; ++j) {
                if (grid[i][j] == 0) {
                    grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
                } else {
                    grid[i][j] = 0;
                }
            }
        }
        return grid[row - 1][col - 1];
    }
}