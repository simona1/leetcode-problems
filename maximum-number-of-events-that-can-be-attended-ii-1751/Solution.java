
/**
 * LeetCode problem # 1751, 'Maximum Number of Events That Can Be Attended II'
 * https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended-ii/
 */

import java.util.*;

class Solution {
    public int maxValue(int[][] events, int k) {
        int n = events.length;
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));

        int max = Integer.MIN_VALUE;
        if (k == 1) {
            for (int i = 0; i < n; ++i) {
                max = Math.max(max, events[i][2]);
            }
            return max;
        }

        int[][] dp = new int[n][k + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return maxValueImpl(events, dp, k, 0);
    }

    private int maxValueImpl(int[][] events, int[][] dp, int k, int start) {
        int n = events.length;
        if (start >= n) {
            return 0;
        }

        if (k == 1) {
            return events[start][2];
        }

        if (dp[start][k] != -1) {
            return dp[start][k];
        }

        int max = events[start][2];
        for (int i = start + 1; i < n; ++i) {
            int res = 0;
            max = Math.max(events[i][2], max);
            if (events[start][1] < events[i][0]) {
                res = events[start][2] + maxValueImpl(events, dp, k - 1, i);
            }

            max = Math.max(res, max);
        }

        max = Math.max(max, maxValueImpl(events, dp, k, start + 1));
        return dp[start][k] = max;
    }
}