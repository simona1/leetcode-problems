
/**
 * LeetCode problem # 240, 'Search a 2D Matrix II'
 * https://leetcode.com/problems/search-a-2d-matrix-ii
 */

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        if (matrix == null || n < 1 || m < 1) {
            return false;
        }

        int row = 0;
        int col = m - 1;

        while (col >= 0 && row <= n - 1) {
            if (target == matrix[row][col]) {
                return true;
            } else if (target < matrix[row][col]) {
                --col;
            } else if (target > matrix[row][col]) {
                ++row;
            }
        }
        return false;
    }
}