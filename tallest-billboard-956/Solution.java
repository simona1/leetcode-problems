
/**
 * LeetCode problem # 956, 'Tallest Billboard'
 * https://leetcode.com/problems/tallest-billboard/
 */

import java.util.*;

class Solution {
    public Map<Integer, Integer> solve(int[] rods, int left, int right) {
        Set<int[]> pairs = new HashSet<>();
        pairs.add(new int[] { 0, 0 });

        for (int i = left; i < right; ++i) {
            int curr = rods[i];

            Set<int[]> newpairs = new HashSet<>();
            for (int[] p : pairs) {
                newpairs.add(new int[] { p[0] + curr, p[1] });
                newpairs.add(new int[] { p[0], p[1] + curr });
            }
            pairs.addAll(newpairs);
        }

        Map<Integer, Integer> dp = new HashMap<>();
        for (int[] p : pairs) {
            int i = p[0];
            int j = p[1];

            dp.put(i - j, Math.max(dp.getOrDefault(i - j, 0), i));
        }
        return dp;
    }

    public int tallestBillboard(int[] rods) {
        int n = rods.length;
        Map<Integer, Integer> half1 = solve(rods, 0, n / 2);
        Map<Integer, Integer> half2 = solve(rods, n / 2, n);

        int res = 0;
        for (int diff : half1.keySet()) {
            if (half2.containsKey(-diff)) {
                res = Math.max(res, half1.get(diff) + half2.get(-diff));
            }
        }
        return res;
    }
}
