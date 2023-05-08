/**
 * LeetCode problem # 1572, 'Matrix Diagonal Sum'
 * https://leetcode.com/problems/matrix-diagonal-sum/
 */
class Solution {
    public int diagonalSum(int[][] mat) {
        int res = 0;
        int n = mat.length;
        for (int i = 0; i < n; ++i) {
            // row + col = n - 1;
            res += mat[n - 1 - i][i] + mat[i][i];
        }
        return n %  2 == 1 ? res - mat[n/ 2][n / 2] : res; 
    }
}
