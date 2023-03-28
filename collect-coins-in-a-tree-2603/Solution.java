
/**
 * LeetCode problem # 2603, 'Collect Coins in a Tree'
 * https://leetcode.com/problems/collect-coins-in-a-tree/
 */

import java.util.*;

class Solution {
    public int collectTheCoins(int[] coins, int[][] edges) {
        int n = coins.length;
        Map<Integer, Set<Integer>> neigh = getNeighbors(edges);

        Queue<Integer> q = new LinkedList<>();
        for (Map.Entry<Integer, Set<Integer>> entry : neigh.entrySet()) {
            Integer key = entry.getKey();
            Set<Integer> value = entry.getValue();
            if (value.size() <= 1 && coins[key] == 0) {
                q.add(key);
            }
        }

        while (!q.isEmpty()) {
            int curr = q.remove();
            Set<Integer> currValues = neigh.get(curr);
            neigh.remove(curr);
            if (currValues == null) {
                continue;
            }
            for (int next : currValues) {
                Set<Integer> nextVal = neigh.get(next);
                nextVal.remove(curr);

                if (nextVal.size() <= 1 && coins[next] == 0) {
                    q.add(next);
                }
            }
        }

        trimLeaves(neigh);
        trimLeaves(neigh);

        return neigh.size() <= 1 ? 0 : (neigh.size() - 1) * 2;
    }

    private void trimLeaves(Map<Integer, Set<Integer>> neigh) {
        List<Integer> leaves = new ArrayList<>();
        for (Map.Entry<Integer, Set<Integer>> entry : neigh.entrySet()) {
            Integer key = entry.getKey();
            Set<Integer> value = entry.getValue();
            if (value.size() == 1) {
                leaves.add(key);
            }
        }

        for (int leaf : leaves) {
            Set<Integer> nextNodes = neigh.get(leaf);
            if (nextNodes == null) {
                continue;
            }
            neigh.remove(leaf);
            for (int next : nextNodes) {
                neigh.get(next).remove(leaf);
            }
        }
    }

    private Map<Integer, Set<Integer>> getNeighbors(int[][] edges) {
        Map<Integer, Set<Integer>> tree = new HashMap<>();
        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            tree.computeIfAbsent(start, k -> new HashSet<>()).add(end);
            tree.computeIfAbsent(end, k -> new HashSet<>()).add(start);
        }
        return tree;
    }
}
