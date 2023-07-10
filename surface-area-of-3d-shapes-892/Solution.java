
/**
 * LeetCode problem # 892, 'Surface Area of 3D Shapes'
 * https://leetcode.com/problems/surface-area-of-3d-shapes/
 */

class Solution {
    public int surfaceArea(int[][] grid) {
        int sides = 0;
        int topbottom = 0;
        int outer = 0;

        int n = grid.length;
        int m = grid[0].length;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                if (j + 1 < grid[i].length) {
                    int diff = grid[i][j] - grid[i][j + 1];
                    if (diff > 0) {
                        sides += diff;
                    }
                }
                if (i + 1 < n) {
                    int diff = grid[i][j] - grid[i + 1][j];
                    if (diff > 0) {
                        sides += diff;
                    }
                }
                if (j - 1 >= 0) {
                    int diff = grid[i][j] - grid[i][j - 1];
                    if (diff > 0) {
                        sides += diff;
                    }
                }
                if (i - 1 >= 0) {
                    int diff = grid[i][j] - grid[i - 1][j];
                    if (diff > 0) {
                        sides += diff;
                    }
                }
                if (grid[i][j] > 0) {
                    topbottom += 2;
                }
            }
        }
        for (int i = 0; i < m; ++i) {
            outer += grid[0][i];
        }
        for (int i = 0; i < grid[n - 1].length; ++i) {
            outer += grid[n - 1][i];
        }
        for (int i = 0; i < n; ++i) {
            outer += grid[i][0];
        }
        for (int i = 0; i < n; ++i) {
            outer += grid[i][grid[0].length - 1];
        }
        return sides + topbottom + outer;
    }
}