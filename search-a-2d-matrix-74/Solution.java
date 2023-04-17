/**
 * LeetCode problem # 74, 'Search a 2D Matrix'
 * https://leetcode.com/problems/search-a-2d-matrix
 */

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] row : matrix) {
            int res = searchRow(row, target);
            if (res >= 0 && res < row.length && row[res] == target) {
                return true;
            }
        }
        return false;
    }

    private int searchRow(int[] row, int target) {
        int low = -1;
        int high = row.length;

        while (low + 1 != high) {
            int mid = low + (high - low) / 2;

            if (row[mid] < target) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return high;
    }
}