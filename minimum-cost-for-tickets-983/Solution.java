
/**
 * LeetCode problem # 983, 'Minimum Cost For Tickets'
 * https://leetcode.com/problems/minimum-cost-for-tickets
 */

import java.util.*;

class Solution {

    Integer[] cache;
    Set<Integer> set;

    public int mincostTickets(int[] days, int[] costs) {
        cache = new Integer[366];
        set = new HashSet<>();
        for (int day : days) {
            set.add(day);
        }
        return computeTravelCosts(1, costs);
    }

    private int computeTravelCosts(int index, int[] costs) {
        if (index > 365) {
            return 0;
        }

        if (cache[index] != null) {
            return cache[index];
        }

        int res = Integer.MAX_VALUE;
        if (set.contains(index)) {
            res = Math.min(computeTravelCosts(index + 1, costs) + costs[0],
                    computeTravelCosts(index + 7, costs) + costs[1]);
            res = Math.min(res, computeTravelCosts(index + 30, costs) + costs[2]);
        } else {
            res = computeTravelCosts(index + 1, costs);
        }
        cache[index] = res;
        return res;
    }
}
