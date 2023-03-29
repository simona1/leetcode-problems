
/**
 * LeetCode problem # 1380, 'Lucky Numbers in a Matrix'
 * https://leetcode.com/problems/lucky-numbers-in-a-matrix
 */

import java.util.*;

class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (isMin(matrix, matrix[i][j], i, j) && isMax(matrix, matrix[i][j], i, j)) {
                    res.add(matrix[i][j]);
                }
            }
        }
        return res;
    }

    private boolean isMin(int matrix[][], int num, int r, int c) {
        int col = 0;
        while (col < matrix[0].length) {
            if (matrix[r][col] < num) {
                return false;
            }
            ++col;
        }
        return true;
    }

    private boolean isMax(int matrix[][], int num, int r, int c) {
        int row = 0;
        while (row < matrix.length) {
            if (matrix[row][c] > num) {
                return false;
            }
            ++row;
        }
        return true;
    }
}
