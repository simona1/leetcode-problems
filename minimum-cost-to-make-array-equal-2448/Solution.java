
/**
 * LeetCode problem # 2448, 'Minimum Cost to Make Array Equal'
 * https://leetcode.com/problems/minimum-cost-to-make-array-equal/
 */

import java.util.*;

class Solution {
    public long minCost(int[] nums, int[] cost) {
        int n = nums.length;

        int[][] pairedCost = new int[n][2];
        for (int i = 0; i < n; ++i) {
            pairedCost[i] = new int[] { nums[i], cost[i] };
        }
        Arrays.sort(pairedCost, (a, b) -> a[0] - b[0]);

        long[] prefixSums = new long[n];
        prefixSums[0] = pairedCost[0][1];
        for (int i = 1; i < n; ++i) {
            prefixSums[i] = pairedCost[i][1] + prefixSums[i - 1];
        }

        long total = 0l;
        for (int i = 1; i < n; ++i) {
            total += 1l * pairedCost[i][1] * (pairedCost[i][0] - pairedCost[0][0]);
        }

        long res = total;
        for (int i = 1; i < n; ++i) {
            int diff = pairedCost[i][0] - pairedCost[i - 1][0];
            total += 1l * prefixSums[i - 1] * diff;
            total -= 1l * (prefixSums[n - 1] - prefixSums[i - 1]) * diff;
            res = Math.min(res, total);

        }
        return res;
    }
}