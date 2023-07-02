
/**
 * LeetCode problem # 2133, 'Check if Every Row and Column Contains All Numbers'
 * https://leetcode.com/problems/check-if-every-row-and-column-contains-all-numbers/
 */

import java.util.*;

class Solution {
    public boolean checkValid(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        for (int i = 0; i < row; ++i) {
            Set<Integer> rows = new HashSet<>();
            Set<Integer> cols = new HashSet<>();

            for (int j = 0; j < col; ++j) {
                rows.add(matrix[i][j]);
                cols.add(matrix[j][i]);
            }

            if (rows.size() < row || cols.size() < col) {
                return false;
            }
        }
        return true;
    }
}
