
/**
 * LeetCode problem # 934, 'Shortest Bridge'
 * https://leetcode.com/problems/shortest-bridge/
 */

import java.util.*;

class Solution {
    private int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
    int[][] grid;
    boolean[][] vis;
    int n;
    Queue<int[]> q = new LinkedList<>();

    public int shortestBridge(int[][] grid) {
        this.n = grid.length;
        this.vis = new boolean[n][n];
        this.grid = grid;

        int res = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    traverse(i, j);
                    res = breadthFirstSearch();
                    return res;
                }
            }
        }
        return res;
    }

    private int breadthFirstSearch() {
        int count = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                int[] curr = q.remove();
                for (int[] dir : dirs) {
                    int newRow = dir[0] + curr[0];
                    int newCol = dir[1] + curr[1];

                    if (isValid(newRow, newCol)) {
                        if (grid[newRow][newCol] == 1) {
                            return count;
                        }

                        vis[newRow][newCol] = true;
                        q.add(new int[] { newRow, newCol });
                    }
                }
            }
            ++count;
        }
        return 0;
    }

    private void traverse(int row, int col) {
        if (!isValid(row, col)) {
            return;
        }
        if (grid[row][col] == 0) {
            return;
        }
        vis[row][col] = true;
        q.add(new int[] { row, col });
        for (int[] dir : dirs) {
            traverse(dir[0] + row, dir[1] + col);
        }
    }

    private boolean isValid(int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < n && !vis[row][col];
    }
}