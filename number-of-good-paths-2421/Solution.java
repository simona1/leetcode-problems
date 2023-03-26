
/**
 * LeetCode problem # 2421, 'Number of Good Paths'
 * https://leetcode.com/problems/number-of-good-paths
 */

import java.util.*;

class Solution {
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            adj.computeIfAbsent(a, value -> new ArrayList<Integer>()).add(b);
            adj.computeIfAbsent(b, value -> new ArrayList<Integer>()).add(a);
        }

        int n = vals.length;

        TreeMap<Integer, List<Integer>> valuesToNodes = new TreeMap<>();
        for (int i = 0; i < n; ++i) {
            valuesToNodes.computeIfAbsent(vals[i], value -> new ArrayList<Integer>()).add(i);
        }

        UnionFind uf = new UnionFind(n);
        int res = 0;

        for (int value : valuesToNodes.keySet()) {
            for (int node : valuesToNodes.get(value)) {
                if (!adj.containsKey(node))
                    continue;
                for (int neighbor : adj.get(node)) {
                    if (vals[node] >= vals[neighbor]) {
                        uf.merge(node, neighbor);
                    }
                }
            }

            Map<Integer, Integer> group = new HashMap<>();
            for (int u : valuesToNodes.get(value)) {
                group.put(uf.find(u), group.getOrDefault(uf.find(u), 0) + 1);
            }
            for (int key : group.keySet()) {
                int size = group.get(key);
                res += size * (size + 1) / 2;
            }
        }
        return res;
    }
}

class UnionFind {
    int[] dp;
    int[] rank;

    public UnionFind(int n) {
        dp = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; ++i) {
            dp[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int i) {
        if (dp[i] == i) {
            return i;
        }
        dp[i] = find(dp[i]);
        return dp[i];
    }

    public boolean isInSameSet(int a, int b) {
        return find(a) == find(b);
    }

    public void merge(int a, int b) {
        if (isInSameSet(a, b)) {
            return;
        }

        int na = find(a);
        int nb = find(b);

        if (rank[na] < rank[nb]) {
            dp[na] = nb;
        } else {
            dp[nb] = dp[na];
            if (rank[na] == rank[nb]) {
                ++rank[na];
            }
        }
    }
}
