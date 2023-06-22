
/**
 * LeetCode problem # 787, 'Cheapest Flights Within K Stops'
 * https://leetcode.com/problems/cheapest-flights-within-k-stops/
 */

import java.util.*;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> neigh = new HashMap<>();
        for (int[] flight : flights) {
            neigh.computeIfAbsent(flight[0], value -> new ArrayList<>()).add(new int[] { flight[1], flight[2] });
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { src, 0 });
        int stops = 0;

        while (stops <= k && !q.isEmpty()) {
            int sz = q.size();

            while (sz-- > 0) {
                int[] curr = q.remove();
                int node = curr[0];
                int distance = curr[1];

                if (!neigh.containsKey(node)) {
                    continue;
                }

                for (int[] edge : neigh.get(node)) {
                    int ng = edge[0];
                    int price = edge[1];
                    if (price + distance >= dist[ng]) {
                        continue;
                    }
                    dist[ng] = price + distance;
                    q.add(new int[] { ng, dist[ng] });
                }
            }
            stops++;
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}