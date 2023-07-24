
/**
 * LeetCode problem # 2787, 'Ways to Express an Integer as Sum of Powers'
 * https://leetcode.com/problems/ways-to-express-an-integer-as-sum-of-powers
 */

class Solution {
    static int MOD = (int) Math.pow(10, 9) + 7;

    public int numberOfWays(int n, int x) {
        Integer[][] cache = new Integer[n + 1][n + 1];
        return solve(n, x, 0, n, cache);

    }

    private int solve(int n, int x, int sum, int curr, Integer[][] cache) {
        if (sum == n) {
            return 1;
        }

        if (sum > n || curr == 0) {
            return 0;
        }

        if (cache[sum][curr] != null) {
            return cache[sum][curr];
        }

        int opt1 = solve(n, x, sum + (int) Math.pow(curr, x), curr - 1, cache);
        opt1 %= MOD;

        int opt2 = solve(n, x, sum, curr - 1, cache);
        opt2 %= MOD;

        cache[sum][curr] = (opt1 + opt2) % MOD;
        return cache[sum][curr];
    }
}
