
/**
 * LeetCode problem # 787, 'Cheapest Flights Within K Stops'
 * https://leetcode.com/problems/cheapest-flights-within-k-stops/
 */

import java.util.*;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<Flight>> neigh = new HashMap<>();
        for (int[] f : flights) {
            neigh.computeIfAbsent(f[0], val -> new ArrayList<>()).add(new Flight(f[1], f[2], 0));
        }

        PriorityQueue<Flight> pq = new PriorityQueue<>((a, b) -> a.d - b.d);
        int[][] dist = new int[n][k + 2];

        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        pq.add(new Flight(src, 0, 0));

        while (!pq.isEmpty()) {
            Flight fl = pq.remove();

            if (dist[fl.to][fl.m] <= fl.d) {
                continue;
            }
            dist[fl.to][fl.m] = fl.d;

            if (fl.m >= k + 1) {
                continue;
            }

            for (Flight next : neigh.getOrDefault(fl.to, new ArrayList<>())) {
                pq.add(new Flight(next.to, fl.d + next.d, fl.m + 1));
            }
        }

        int res = Integer.MAX_VALUE;
        for (int d : dist[dst]) {
            res = Math.min(res, d);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}

class Flight {
    int to;
    int d;
    int m;

    Flight(int to, int d, int m) {
        this.to = to;
        this.d = d;
        this.m = m;
    }
}
