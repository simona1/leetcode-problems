
/**
 * LeetCode problem # 2360, 'Longest Cycle in a Graph'
 * https://leetcode.com/problems/longest-cycle-in-a-graph/
 */

import java.util.*;

class Solution {
    int res = -1;

    public int longestCycle(int[] edges) {
        int n = edges.length;
        boolean[] vis = new boolean[n];

        for (int i = 0; i < edges.length; ++i) {
            if (!vis[i]) {
                Map<Integer, Integer> dist = new HashMap<>();
                dist.put(i, 1);
                traverse(i, edges, dist, vis);
            }
        }
        return res;

    }

    private void traverse(int node, int[] edges, Map<Integer, Integer> dist, boolean[] vis) {
        vis[node] = true;
        int neigh = edges[node];

        Integer neighDist = dist.get(neigh);
        Integer nodeDist = dist.get(node);

        if (neigh != -1 && !vis[neigh]) {
            dist.put(neigh, nodeDist + 1);
            traverse(neigh, edges, dist, vis);

        } else if (neigh != -1 && neighDist != null) {
            res = Math.max(res, (nodeDist - neighDist + 1));
        }
    }
}
