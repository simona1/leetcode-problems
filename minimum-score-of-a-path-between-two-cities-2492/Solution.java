
/**
 * LeetCode problem # 2492, 'Minimum Score of a Path Between Two Cities'
 * https://leetcode.com/problems/minimum-score-of-a-path-between-two-cities
 */

import java.util.*;

class Solution {
    public int minScore(int n, int[][] roads) {
        Map<Integer, List<List<Integer>>> neigh = new HashMap<>();

        for (int[] road : roads) {
            neigh.computeIfAbsent(road[0], val -> new ArrayList<>()).add(Arrays.asList(road[1], road[2]));
            neigh.computeIfAbsent(road[1], val -> new ArrayList<>()).add(Arrays.asList(road[0], road[2]));

        }
        return breadthFirstSearch(n, neigh);
    }

    private int breadthFirstSearch(int n, Map<Integer, List<List<Integer>>> neigh) {
        boolean[] vis = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        int res = Integer.MAX_VALUE;

        q.add(1);
        vis[1] = true;

        while (!q.isEmpty()) {
            int curr = q.remove();
            List<List<Integer>> edges = neigh.get(curr);

            if (edges == null) {
                continue;
            }
            for (List<Integer> edge : edges) {
                res = Math.min(res, edge.get(1));
                int node = edge.get(0);
                if (!vis[node]) {
                    vis[node] = true;
                    q.add(node);
                }
            }
        }
        return res;
    }
}
