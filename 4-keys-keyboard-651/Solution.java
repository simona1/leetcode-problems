/**
 * LeetCode problem # 651, '4 Keys Keyboard'
 * https://leetcode.com/problems/4-keys-keyboard/
 */

// Initialize all with index first, then the following applies:
// dp[i + 3] = 2 * dp[i]
// dp[i + 4] = 3 * dp[i]
// dp[i + 5] = 4 * dp[i]
// dp[i + 6] = 5 * dp[i]

// dp[j] = (j - i - 1) * dp[i] where i + 3 <= j <= i + 6

class Solution {
    public int maxA(int n) {
        int[] dp = new int[n + 1];

        for (int i = 0; i <= n; ++i) {
            dp[i] = i;
        }

        for (int i = 0; i < n - 3; ++i) {
            int lo = i + 3;
            int hi = Math.min(n, i + 6);
            for (int j = lo; j <= hi; ++j) {
                dp[j] = Math.max(dp[j], (j - i - 1) * dp[i]);
            }
        }
        return dp[n];
    }
}
