/**
 * LeetCode problem # 1020, 'Number of Enclaves'
 * https://leetcode.com/problems/number-of-enclaves
 */

import java.util.*;

class Solution {

    static int[][] dirs = {
        {0, -1},
        {1, 0},
        {0, 1},
        {-1, 0}
    };

    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] vis = new boolean[m][n];

        for (int i = 0; i < m; ++i) {
            if (grid[i][0] == 1 && !vis[i][0]) {
                breadthFirstSearch(i, 0, grid, vis);
            }
            if (grid[i][n - 1] == 1 && !vis[i][n - 1]) {
                breadthFirstSearch(i, n - 1, grid, vis);
            }
        }


        for (int i = 0; i < n; ++i) {
            if (grid[0][i] == 1 && !vis[0][i]) {
                breadthFirstSearch(0, i, grid, vis);
            }
            if (grid[m - 1][i] == 1 && !vis[m - 1][i]) {
                breadthFirstSearch(m - 1, i, grid, vis);
            }
        }

        int res = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1 && !vis[i][j]) {
                    ++res;
                }
            }
        }
        return res;
    }

   
    public void breadthFirstSearch(int x, int y, int[][] grid, boolean[][] vis) {
        int m = grid.length;
        int n = grid[0].length;


        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        vis[x][y] = true;

        int[] dirx = {0, 1, 0, -1};
        int[] diry = {-1, 0, 1, 0};

        while (!q.isEmpty()) {
            int[] curr = q.remove();
            
            for (int[] dir : dirs) {
                int dr = curr[0] + dir[0];
                int dc = curr[1] + dir[1];


                if (dr < 0 || dr >= m || dc < 0 || dc >= n) {
                    continue;
                }
                if (grid[dr][dc] == 1 && !vis[dr][dc]) {
                    q.add(new int[]{dr, dc});
                    vis[dr][dc] = true;
                }
            }
        }
    }
}

