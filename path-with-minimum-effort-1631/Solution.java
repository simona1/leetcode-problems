
/**
 * LeetCode problem # 1631, 'Path With Minimum Effort'
 * https://leetcode.com/problems/path-with-minimum-effort/
 */

import java.util.Arrays;
import java.util.PriorityQueue;

class Cell {
    int a;
    int b;
    int d;

    public Cell(int a, int b, int d) {
        this.a = a;
        this.b = b;
        this.d = d;
    }
}

class Solution {
    static int[][] DIRS = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        int[][] diff = new int[rows][cols];

        for (int[] d : diff) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        diff[0][0] = 0;

        boolean[][] vis = new boolean[rows][cols];
        PriorityQueue<Cell> pq = new PriorityQueue<>((a, b) -> a.d - b.d);
        pq.add(new Cell(0, 0, diff[0][0]));

        while (!pq.isEmpty()) {
            Cell curr = pq.remove();
            vis[curr.a][curr.b] = true;

            if (curr.a == rows - 1 && curr.b == cols - 1) {
                return curr.d;
            }

            for (int[] dir : DIRS) {
                int nr = curr.a + dir[0];
                int nc = curr.b + dir[1];

                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols || vis[nr][nc]) {
                    continue;
                }

                int currentDiff = Math.abs(heights[nr][nc] - heights[curr.a][curr.b]);
                int maxDiff = Math.max(currentDiff, diff[curr.a][curr.b]);

                if (diff[nr][nc] > maxDiff) {
                    diff[nr][nc] = maxDiff;
                    pq.add(new Cell(nr, nc, maxDiff));
                }
            }
        }
        return diff[rows - 1][cols - 1];
    }
}
