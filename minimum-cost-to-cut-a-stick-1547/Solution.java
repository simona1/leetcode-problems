
/**
 * LeetCode problem # 1547, 'Minimum Cost to Cut a Stick'
 * https://leetcode.com/problems/minimum-cost-to-cut-a-stick/
 */

import java.util.*;

class Solution {
    int[][] dp;

    public int solve(int i, int j, int[] cuts) {
        if (i > j) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int min = Integer.MAX_VALUE;
        for (int index = i; index <= j; ++index) {
            int cost = (cuts[j + 1] - cuts[i - 1]) + solve(i, index - 1, cuts) + solve(index + 1, j, cuts);
            min = Math.min(min, cost);
        }
        return dp[i][j] = min;
    }

    public int minCost(int n, int[] cuts) {
        int c = cuts.length;
        int[] newCuts = new int[c + 2];

        newCuts[0] = 0;
        for (int i = 0; i < cuts.length; ++i) {
            newCuts[i] = cuts[i];
        }
        newCuts[c + 1] = n;

        Arrays.sort(newCuts);

        dp = new int[c + 2][c + 2];

        for (int i = 0; i < c + 2; ++i) {
            for (int j = 0; j < c + 2; ++j) {
                dp[i][j] = -1;
            }
        }
        return solve(1, c, newCuts);
    }
}
