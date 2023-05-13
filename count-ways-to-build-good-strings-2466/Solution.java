
/**
 * LeetCode problem # 2466, 'Count Ways To Build Good Strings'
 * https://leetcode.com/problems/count-ways-to-build-good-strings
 */

class Solution {
    static long MOD = (long) Math.pow(10, 9) + 7;

    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp = new int[high + 1];
        dp[0] = 1;

        for (int i = 1; i <= high; ++i) {
            if (i >= zero) {
                dp[i] += dp[i - zero];
            }
            if (i >= one) {
                dp[i] += dp[i - one];
            }
            dp[i] = (int) (dp[i] % MOD);
        }

        int res = 0;
        for (int i = low; i <= high; ++i) {
            res += dp[i];
            res = (int) (res % MOD);
        }
        return res;
    }
}
