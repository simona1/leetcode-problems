/**
 * LeetCode problem # 1035, 'Uncrossed Lines'
 * https://leetcode.com/problems/uncrossed-lines
 */

class Solution {
    public int maxUncrossedLines(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;
        if (n == 0 || m == 0) {
            return 0;
        }

        int[][] dp = new int[n + 1][m + 1];
        for (int i = n - 1; i >= 0; --i) {
            for (int j = m - 1; j >= 0; --j) {
                int curr = A[i] == B[j] ? 1 : 0;
                dp[i][j] = Math.max(dp[i + 1][j], Math.max(dp[i][j + 1], dp[i + 1][j + 1] + curr));
            }
        }
        return dp[0][0];
    }
}
