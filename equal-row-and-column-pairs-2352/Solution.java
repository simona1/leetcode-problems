
/**
 * LeetCode problem # 2352, 'Equal Row and Column Pairs'
 * https://leetcode.com/problems/equal-row-and-column-pairs/
 */

import java.util.*;

class Solution {
    public int equalPairs(int[][] grid) {
        Map<String, Integer> rowMap = new HashMap<>();
        Map<String, Integer> colMap = new HashMap<>();
        int r = grid.length;
        int c = grid[0].length;

        for (int i = 0; i < r; ++i) {
            String curr = convertArrayToStr(grid[i]);
            rowMap.put(curr, rowMap.getOrDefault(curr, 0) + 1);
        }

        for (int i = 0; i < c; ++i) {
            String curr = getColumnString(grid, i, c);
            colMap.put(curr, colMap.getOrDefault(curr, 0) + 1);
        }
        System.out.println(rowMap);
        System.out.println(colMap);

        int res = 0;
        for (String key : rowMap.keySet()) {
            Integer nc = colMap.get(key);
            if (nc != null) {
                int nr = rowMap.get(key);
                res += (nc * nr);
            }
        }
        return res;
    }

    private String getColumnString(int[][] arr, int index, int col) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < col; ++i) {
            sb.append(arr[i][index]);
            sb.append(" ");
        }
        return sb.toString();
    }

    private String convertArrayToStr(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int a : arr) {
            sb.append(a);
            sb.append(" ");
        }
        return sb.toString();
    }
}
