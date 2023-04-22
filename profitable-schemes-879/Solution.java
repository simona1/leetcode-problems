
/**
 * LeetCode problem # 879, 'Profitable Schemes'
 * https://leetcode.com/problems/profitable-schemes/
 */

class Solution {
    static int MOD = (int) Math.pow(10, 9) + 7;
    int[][][] dp = new int[101][101][101];

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int len = group.length;

        for (int i = 0; i <= n; ++i) {
            dp[len][i][minProfit] = 1;
        }

        for (int i = len - 1; i >= 0; --i) {
            for (int j = 0; j <= n; ++j) {
                for (int k = 0; k <= minProfit; ++k) {
                    dp[i][j][k] = dp[i + 1][j][k];
                    if (j + group[i] <= n) {
                        dp[i][j][k] = (dp[i][j][k] + dp[i + 1][j + group[i]][Math.min(minProfit, k + profit[i])]) % MOD;
                    }
                }
            }
        }
        return dp[0][0][0];
    }
}
