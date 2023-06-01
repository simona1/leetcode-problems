
/**
 * LeetCode problem # 1091, 'Shortest Path in Binary Matrix'
 * https://leetcode.com/problems/shortest-path-in-binary-matrix/
 */

import java.util.*;

class Solution {
    static int[][] dirs = new int[][] { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 },
            { 1, 1 } };

    public int shortestPathBinaryMatrix(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        if (grid[0][0] != 0 || grid[r - 1][c - 1] != 0) {
            return -1;
        }
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] { 0, 0 });
        grid[0][0] = 1;
        while (!q.isEmpty()) {
            int[] curr = q.remove();
            int row = curr[0];
            int col = curr[1];
            int d = grid[row][col];
            if (row == r - 1 && col == c - 1) {
                return d;
            }
            for (int[] neigh : getNeighbors(row, col, grid)) {
                q.add(neigh);
                grid[neigh[0]][neigh[1]] = d + 1;
            }
        }
        return -1;
    }

    private List<int[]> getNeighbors(int row, int col, int[][] grid) {
        List<int[]> neighbors = new ArrayList<>();
        for (int[] dir : dirs) {
            int nr = row + dir[0];
            int nc = col + dir[1];
            if (nr < 0 || nr >= grid.length || nc < 0 || nc >= grid[0].length || grid[nr][nc] != 0) {
                continue;
            }
            neighbors.add(new int[] { nr, nc });
        }
        return neighbors;
    }
}
