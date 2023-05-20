
/**
 * LeetCode problem # 265, 'Paint House II'
 * https://leetcode.com/problems/paint-house-ii/
 */

import java.util.*;

class Solution {
    private int n;
    private int k;
    private int[][] costs;
    private Map<String, Integer> cache;

    public int minCostII(int[][] costs) {
        this.n = costs.length;
        if (costs.length == 0) {
            return 0;
        }

        this.k = costs[0].length;
        this.costs = costs;
        this.cache = new HashMap<>();

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < k; ++i) {
            res = Math.min(res, solve(0, i));
        }
        return res;
    }

    private String generateKey(int index, int color) {
        StringBuilder sb = new StringBuilder();
        sb.append(index);
        sb.append("-");
        sb.append(color);
        return sb.toString();
    }

    private int solve(int house, int color) {
        if (house == n - 1) {
            return this.costs[house][color];
        }

        String key = generateKey(house, color);
        Integer value = cache.get(key);
        if (value != null) {
            return value;
        }

        int additionalCost = Integer.MAX_VALUE;
        for (int i = 0; i < k; ++i) {
            if (color == i) {
                continue;
            }
            int curr = solve(house + 1, i);
            additionalCost = Math.min(curr, additionalCost);
        }

        int total = costs[house][color] + additionalCost;
        cache.put(key, total);

        return total;
    }
}
