
/**
 * LeetCode problem # 847, 'Shortest Path Visiting All Nodes'
 * https://leetcode.com/problems/shortest-path-visiting-all-nodes
 */

class Solution {
    int[][] cache;
    int mask;

    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        // set mask to a number with all bits set to 1 up to n bits.
        // Track if all nodes have been visited.
        mask = (1 << n) - 1;

        cache = new int[n + 1][mask + 1];

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; ++i) {
            res = Math.min(res, traverse(i, mask, graph));
        }
        return res;
    }

    private int traverse(int node, int m, int[][] graph) {
        // if in cache return it
        if (cache[node][m] != 0) {
            return cache[node][m];
        }

        // If only one bit in m is set, i.e. only one node not visited
        if ((m & (m - 1)) == 0) {
            return 0;
        }

        cache[node][m] = Integer.MAX_VALUE - 1;

        for (int neigh : graph[node]) {
            if ((m & 1 << neigh) != 0) {

                // Vist neighbor w/out marking curr as vis (don't use)
                // Visit neighbor and mark curr as vis (take)
                int vis = traverse(neigh, m, graph);
                int notVis = traverse(neigh, m ^ (1 << node), graph); // mark as vis

                // pick best option
                int shorter = Math.min(vis, notVis);
                cache[node][m] = Math.min(cache[node][m], 1 + shorter);
            }
        }
        return cache[node][m];
    }
}