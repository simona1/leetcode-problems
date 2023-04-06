
/**
 * LeetCode problem # 1254, 'Number of Closed Islands'
 * https://leetcode.com/problems/number-of-closed-islands/
 */

import java.util.*;

class Solution {
    static int[][] dirs = { { 0, -1 }, { 1, 0 }, { 0, 1 }, { -1, 0 } };

    public int closedIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] vis = new boolean[rows][cols];
        int res = 0;

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (grid[i][j] == 0 && !vis[i][j] && isClosedIslandImpl(i, j, grid, vis)) {
                    ++res;
                }
            }
        }
        return res;
    }

    private boolean isClosedIslandImpl(int i, int j, int[][] grid, boolean[][] vis) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { i, j });
        vis[i][j] = true;
        boolean isClosedIsland = true;

        while (!q.isEmpty()) {
            int[] curr = q.remove();

            for (int[] dir : dirs) {
                int dr = curr[0] + dir[0];
                int dc = curr[1] + dir[1];

                if (dr < 0 || dr >= rows || dc < 0 || dc >= cols) {
                    isClosedIsland = false;
                    continue;
                } else if (grid[dr][dc] == 0 && !vis[dr][dc]) {
                    q.add(new int[] { dr, dc });
                    vis[dr][dc] = true;
                }
            }
        }
        return isClosedIsland;
    }
}