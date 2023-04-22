/**
 * LeetCode problem # 832, 'Flipping an Image'
 * https://leetcode.com/problems/flipping-an-image/
 */

class Solution {
    public int[][] flipAndInvertImage(int[][] matrix) {
        for (int[] row : matrix) {
            reverse(row);
        }
        int r = matrix.length;
        int c = matrix[0].length;

        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                matrix[i][j] = matrix[i][j] == 0 ? 1 : 0;
            }
        }
        return matrix;
    }

    private void reverse(int[] arr) {
        int i = 0;
        int j = arr.length - 1;

        while (i < j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            ++i;
            --j;
        }
    }
}