
/**
 * LeetCode problem # 2661, 'First Completely Painted Row or Column'
 * https://leetcode.com/problems/first-completely-painted-row-or-column
 */

import java.util.*;

class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int row[] = new int[m];
        int col[] = new int[n];

        Map<Integer, int[]> map = new HashMap<>();

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                map.put(mat[i][j], new int[] { i, j });
            }
        }

        for (int i = 0; i < arr.length; ++i) {
            int indexes[] = map.get(arr[i]);
            int x = indexes[0];
            int y = indexes[1];
            ++row[x];
            ++col[y];

            if (row[x] == n || col[y] == m) {
                return i;
            }

        }
        return 0;
    }
}