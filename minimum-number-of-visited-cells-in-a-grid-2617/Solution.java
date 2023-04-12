
/**
 * LeetCode problem # 2617, 'Minimum Number of Visited Cells in a Grid'
 * https://leetcode.com/problems/minimum-number-of-visited-cells-in-a-grid
 */

import java.util.*;

class Solution {
    int[][] dirs = { { 0, 1 }, { 1, 0 } };

    public int minimumVisitedCells(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        List<TreeSet<Integer>> rowList = new ArrayList<>();
        for (int i = 0; i < r; ++i) {
            TreeSet<Integer> curr = new TreeSet<>();
            for (int j = 0; j < c; ++j) {
                curr.add(j);
            }
            rowList.add(curr);
        }

        List<TreeSet<Integer>> colList = new ArrayList<>();
        for (int i = 0; i < c; ++i) {
            TreeSet<Integer> curr = new TreeSet<>();
            for (int j = 0; j < r; ++j) {
                curr.add(j);
            }
            colList.add(curr);
        }

        int[][] dist = new int[r][c];
        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                dist[i][j] = -1;
            }
        }

        dist[0][0] = 1;
        rowList.get(0).remove(0);
        colList.get(0).remove(0);

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { 0, 0 });

        while (!q.isEmpty()) {
            int[] curr = q.remove();
            int x = curr[0];
            int y = curr[1];
            int k = grid[x][y];

            if (k == 0) {
                continue;
            }

            List<int[]> neigh = new ArrayList<>();

            Set<Integer> colset = colList.get(y).subSet(x + 1, true, x + k, true);
            for (int nx : colset) {
                neigh.add(new int[] { nx, y });
            }

            Set<Integer> rowset = rowList.get(x).subSet(y + 1, true, y + k, true);
            for (int ny : rowset) {
                neigh.add(new int[] { x, ny });
            }

            for (int[] next : neigh) {
                int nx = next[0];
                int ny = next[1];

                rowList.get(nx).remove(ny);
                colList.get(ny).remove(nx);

                dist[nx][ny] = 1 + dist[x][y];
                q.add(next);
            }
        }
        return dist[r - 1][c - 1];
    }
}
