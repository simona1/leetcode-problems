
/**
 * LeetCode problem # 2617, 'Minimum Number of Visited Cells in a Grid'
 * https://leetcode.com/problems/minimum-number-of-visited-cells-in-a-grid
 */

import java.util.*;

class Solution {
    public int minimumVisitedCells(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        int[][] res = new int[r][c];
        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                res[i][j] = -1;
            }
        }

        List<TreeSet<Integer>> rowList = new ArrayList<>();
        for (int i = 0; i < r; ++i) {
            TreeSet<Integer> set = new TreeSet<>();
            for (int j = 0; j < c; ++j) {
                set.add(j);
            }
            rowList.add(set);
        }

        List<TreeSet<Integer>> colList = new ArrayList<>();
        for (int j = 0; j < c; ++j) {
            TreeSet<Integer> set = new TreeSet<>();
            for (int i = 0; i < r; ++i) {
                set.add(i);
            }
            colList.add(set);
        }

        res[0][0] = 1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { 0, 0 });

        rowList.get(0).remove(0);
        colList.get(0).remove(0);

        while (!q.isEmpty()) {
            int[] curr = q.remove();
            int i = curr[0];
            int j = curr[1];
            int k = grid[i][j];
            if (k == 0) {
                continue;
            }

            List<int[]> neigh = new ArrayList<>();

            for (int nj : rowList.get(i).subSet(j + 1, true, j + k, true)) {
                neigh.add(new int[] { i, nj });
            }

            for (int ni : colList.get(j).subSet(i + 1, true, i + k, true)) {
                neigh.add(new int[] { ni, j });
            }

            for (int[] next : neigh) {
                q.add(next);

                int ni = next[0];
                int nj = next[1];

                res[ni][nj] = res[i][j] + 1;

                rowList.get(ni).remove(nj);
                colList.get(nj).remove(ni);

            }
        }
        return res[r - 1][c - 1];
    }
}
