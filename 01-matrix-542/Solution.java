
/**
 * LeetCode problem # 542, '01 Matrix'
 * https://leetcode.com/problems/01-matrix/
 */

import java.util.*;

class Solution {
    public static class Pair {
        int i;
        int j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;

        }
    }

    public int[][] updateMatrix(int[][] mat) {
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < mat.length; ++i) {
            for (int j = 0; j < mat[0].length; ++j) {
                if (mat[i][j] == 0) {
                    q.add(new Pair(i, j));
                } else {
                    mat[i][j] = -1;
                }
            }
        }

        int[][] d = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            for (int k = 0; k < d.length; ++k) {
                int i = curr.i + d[k][0];
                int j = curr.j + d[k][1];

                if (i >= 0 && j >= 0 && i <= mat.length - 1 && j <= mat[0].length - 1 && mat[i][j] == -1) {
                    mat[i][j] = mat[curr.i][curr.j] + 1;
                    q.add(new Pair(i, j));
                }

            }
        }
        return mat;
    }
}