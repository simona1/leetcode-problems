
/**
 * LeetCode problem # 743, 'Network Delay Time'
 * https://leetcode.com/problems/network-delay-time/
 */

import java.util.*;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        Map<Integer, List<Edge>> neigh = new HashMap<>();

        for (int[] time : times) {
            neigh.computeIfAbsent(time[0], val -> new ArrayList<>()).add(new Edge(time[1], time[2]));

        }

        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        pq.add(new Edge(k, 0));

        while (!pq.isEmpty()) {
            Edge edge = pq.remove();
            if (dist[edge.to] <= edge.cost) {
                continue;
            }
            dist[edge.to] = edge.cost;

            for (Edge nextEdge : neigh.getOrDefault(edge.to, new ArrayList<>())) {
                pq.add(new Edge(nextEdge.to, nextEdge.cost + edge.cost));
            }
        }

        int res = Integer.MIN_VALUE;
        for (int i = 1; i <= n; ++i) {
            res = Math.max(res, dist[i]);
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
}

class Edge {
    int to;
    int cost;

    Edge(int a, int b) {
        this.to = a;
        this.cost = b;

    }
}
