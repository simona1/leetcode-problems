
/**
 * LeetCode problem # 920, 'Number of Music Playlists'
 * https://leetcode.com/problems/number-of-music-playlists/
 */

import java.util.*;

class Solution {
    static int MOD = (int) Math.pow(10, 9) + 7;

    public int numMusicPlaylists(int n, int goal, int k) {

        long[][] dp = new long[goal + 1][n + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= goal; ++i) {
            int limit = Math.min(i, n);
            for (int j = 1; j <= limit; ++j) {
                // new song
                dp[i][j] = dp[i - 1][j - 1] * (n - j + 1) % MOD;

                // played before
                if (j > k) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j] * (j - k)) % MOD;
                }
            }
        }
        return (int) dp[goal][n];
    }
}
