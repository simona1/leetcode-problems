
/**
 * LeetCode problem # 1970, 'Last Day Where You Can Still Cross'
 * https://leetcode.com/problems/last-day-where-you-can-still-cross/
 */

import java.util.*;

class Solution {
    static int[][] DIRS = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public boolean canCross(int row, int col, int[][] cells, int day) {
        int[][] grid = new int[row][col];

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < day; ++i) {
            grid[cells[i][0] - 1][cells[i][1] - 1] = 1;
        }

        for (int i = 0; i < col; ++i) {
            if (grid[0][i] == 0) {
                queue.add(new int[] { 0, i });
                grid[0][i] = -1;
            }
        }

        while (!queue.isEmpty()) {
            int[] curr = queue.remove();
            int r = curr[0], c = curr[1];
            if (r == row - 1) {
                return true;
            }

            for (int[] dir : DIRS) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (nr >= 0 && nr < row && nc >= 0 && nc < col && grid[nr][nc] == 0) {
                    grid[nr][nc] = -1;
                    queue.add(new int[] { nr, nc });
                }
            }
        }

        return false;
    }

    public int latestDayToCross(int row, int col, int[][] cells) {
        int left = 0;
        int right = row * col;

        while (left + 1 != right) {
            int mid = right - (right - left) / 2;
            if (canCross(row, col, cells, mid)) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
