
/**
 * LeetCode problem # 2218, 'Maximum Value of K Coins From Piles'
 * https://leetcode.com/problems/maximum-value-of-k-coins-from-piles/
 */

import java.util.*;

class Solution {
    Integer[][] dp;

    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int n = piles.size();
        dp = new Integer[n + 1][k + 1];
        return maxValueOfCoinImpl(0, piles, k);
    }

    private int maxValueOfCoinImpl(int index, List<List<Integer>> piles, int k) {
        if (index >= piles.size()) {
            return 0;
        }

        int max = 0;
        int sum = 0;

        if (dp[index][k] != null) {
            return dp[index][k];
        }

        // don't take from pile
        max = Math.max(max, maxValueOfCoinImpl(index + 1, piles, k));
        List<Integer> curr = piles.get(index);
        for (int i = 0; i < curr.size(); ++i) {
            sum += curr.get(i);

            // take from pile
            if (k - (i + 1) >= 0) {
                max = Math.max(max, sum + maxValueOfCoinImpl(index + 1, piles, k - (i + 1)));
            }
        }
        dp[index][k] = max;
        return dp[index][k];

    }
}
