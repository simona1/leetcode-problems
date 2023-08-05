/**
 * LeetCode problem # 712, 'Minimum ASCII Delete Sum for Two Strings'
 * https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/
 */

class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[][] costs = new int[n + 1][m + 1];

        for (int i = 1; i <= n; ++i) {
            costs[i][0] = costs[i - 1][0] + s1.charAt(i - 1);
        }

        for (int j = 1; j <= m; ++j) {
            costs[0][j] = costs[0][j - 1] + s2.charAt(j - 1);
        }

        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                int a = s1.charAt(i - 1);
                int b = s2.charAt(j - 1);
                if (a == b) {
                    costs[i][j] = costs[i - 1][j - 1];
                } else {
                    costs[i][j] = Math.min(a + costs[i - 1][j], b + costs[i][j - 1]);
                }
            }
        }
        return costs[n][m];
    }
}