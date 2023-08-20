
/**
 * LeetCode problem # 1615, 'Maximal Network Rank'
 * https://leetcode.com/problems/maximal-network-rank/
 */

import java.util.*;

class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int res = 0;

        Map<Integer, Set<Integer>> neighbors = new HashMap<>();
        for (int[] road : roads) {
            neighbors.computeIfAbsent(road[0], val -> new HashSet<>()).add(road[1]);
            neighbors.computeIfAbsent(road[1], val -> new HashSet<>()).add(road[0]);
        }

        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                Set<Integer> set1 = neighbors.getOrDefault(i, new HashSet<>());
                Set<Integer> set2 = neighbors.getOrDefault(j, new HashSet<>());

                int curr = set1.size() + set2.size();
                if (set1.contains(j)) {
                    --curr;
                }

                res = Math.max(res, curr);
            }
        }
        return res;
    }
}