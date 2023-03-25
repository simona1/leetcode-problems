
/**
 * LeetCode problem # 2316, 'Count Unreachable Pairs of Nodes in an Undirected Graph'
 * https://leetcode.com/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/
 */

import java.util.*;

class Solution {
    public long countPairs(int n, int[][] edges) {
        Map<Integer, List<Integer>> neigh = new HashMap<>();
        for (int[] edge : edges) {
            neigh.computeIfAbsent(edge[0], key -> new ArrayList<>()).add(edge[1]);
            neigh.computeIfAbsent(edge[1], key -> new ArrayList<>()).add(edge[0]);
        }

        long count = 0;
        long size = 0;
        long rem = n;

        boolean[] vis = new boolean[n];

        for (int i = 0; i < n; ++i) {
            if (!vis[i]) {
                size = breadthFirstSearch(i, neigh, vis);
                count += size * (rem - size);
                rem -= size;
            }
        }
        return count;
    }

    private int breadthFirstSearch(int node, Map<Integer, List<Integer>> neigh, boolean[] vis) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        int currCount = 1;
        vis[node] = true;

        while (!q.isEmpty()) {
            int curr = q.remove();
            List<Integer> connections = neigh.get(curr);
            if (connections == null) {
                continue;
            }

            for (int con : connections) {
                if (!vis[con]) {
                    vis[con] = true;
                    ++currCount;
                    q.add(con);
                }
            }
        }
        return currCount;
    }
}
