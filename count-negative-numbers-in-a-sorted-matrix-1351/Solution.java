
/**
 * LeetCode problem # 1351, 'Count Negative Numbers in a Sorted Matrix'
 * https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix
 */

class Solution {
    public int countNegatives(int[][] grid) {
        int res = 0;

        for (int[] row : grid) {
            int n = row.length - countInRow(row);
            res += n;
        }
        return res;
    }

    private int countInRow(int[] row) {
        int lo = row.length;
        int hi = -1;

        while (hi + 1 != lo) {
            int mid = lo + (hi - lo) / 2;
            if (row[mid] > -1) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        return lo;
    }
}
