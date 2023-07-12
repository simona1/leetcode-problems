
/**
 * LeetCode problem # 802, 'Find Eventual Safe States'
 * https://leetcode.com/problems/find-eventual-safe-states/
 */

import java.util.*;

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> neigh = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            neigh.add(new ArrayList<>());
            for (int node : graph[i]) {
                neigh.get(i).add(node);
            }
        }
        boolean[] vis = new boolean[n];
        boolean[] processed = new boolean[n];

        for (int i = 0; i < n; ++i) {
            traverseAndMark(i, neigh, vis, processed);
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (!processed[i]) {
                res.add(i);
            }
        }
        return res;
    }

    private boolean traverseAndMark(int node, List<List<Integer>> neigh, boolean[] vis, boolean[] processed) {
        if (processed[node]) {
            return true;
        }
        if (vis[node]) {
            return false;
        }
        vis[node] = true;
        processed[node] = true;

        for (int curr : neigh.get(node)) {
            if (traverseAndMark(curr, neigh, vis, processed)) {
                return true;
            }
        }
        processed[node] = false;
        return false;

    }
}