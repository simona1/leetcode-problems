/**
 * LeetCode problem # 1444, 'Number of Ways of Cutting a Pizza'
 * https://leetcode.com/problems/number-of-ways-of-cutting-a-pizza/
 */

class Solution {
    static int MOD = 1000000007;

    public int ways(String[] pizza, int k) {
        int rows = pizza.length;
        int cols = pizza[0].length();

        // Relation: apples[row][col] if there's an apple on pizza then 1, otherwise 0 +
        // apples[row + 1][col] + apples[row][col + 1] - apples[row + 1][col + 1]
        // if this is more than 0, then dp[0][row][col] = 1 else dp[0][row][col] = 0
        // (base case).

        int apples[][] = new int[rows + 1][cols + 1];
        int dp[][][] = new int[k][rows][cols];

        for (int i = rows - 1; i >= 0; --i) {
            for (int j = cols - 1; j >= 0; --j) {
                int curr = pizza[i].charAt(j) == 'A' ? 1 : 0;
                apples[i][j] = curr + apples[i + 1][j] + apples[i][j + 1] - apples[i + 1][j + 1];

                dp[0][i][j] = apples[i][j] > 0 ? 1 : 0;
            }
        }

        // iterate over remaining ones from 1 to k, also over rows and cols
        // this is for computing all cuts as dp[rem][row][col]
        // horizontal cuts -> row = i + 1 to rows
        // if there's an apple on top - add to dp
        // don't forget about MOD
        // vertical cuts -> cols = j + 1 to cols
        // if there's an apple on left - add to dp
        // don't forget about MOD

        for (int rem = 1; rem < k; ++rem) {
            for (int i = 0; i < rows; ++i) {
                for (int j = 0; j < cols; ++j) {

                    for (int r = i + 1; r < rows; ++r) {
                        if (apples[i][j] - apples[r][j] > 0) {
                            dp[rem][i][j] += dp[rem - 1][r][j];
                            dp[rem][i][j] %= MOD;
                        }
                    }

                    for (int c = j + 1; c < cols; ++c) {
                        if (apples[i][j] - apples[i][c] > 0) {
                            dp[rem][i][j] += dp[rem - 1][i][c];
                            dp[rem][i][j] %= MOD;
                        }
                    }
                }
            }
        }
        // return ways to cut with k - 1 cuts
        return dp[k - 1][0][0];
    }
}