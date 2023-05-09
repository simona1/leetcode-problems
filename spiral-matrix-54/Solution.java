
/**
 * LeetCode problem # 54, 'Spiral Matrix'
 * https://leetcode.com/problems/spiral-matrix
 */

import java.util.*;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;

        int up = 0;
        int left = 0;
        int right = c - 1;
        int down = r - 1;

        int total = r * c;

        List<Integer> res = new ArrayList<>();

        while (res.size() < total) {
            // to the right
            for (int i = left; i <= right; ++i) {
                res.add(matrix[up][i]);
            }
            // down the column
            for (int i = up + 1; i <= down; ++i) {
                res.add(matrix[i][right]);
            }

            // another row, compare up to down
            if (up != down) {
                // go to the left now
                for (int i = right - 1; i >= left; --i) {
                    res.add(matrix[down][i]);
                }
            }

            // another column, compare left to right
            if (left != right) {
                // Go up the column
                for (int i = down - 1; i > up; --i) {
                    res.add(matrix[i][left]);
                }
            }
            ++left;
            --right;
            ++up;
            --down;
        }

        return res;
    }
}
