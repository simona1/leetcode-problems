
/**
 * LeetCode problem # 1466, 'Reorder Routes to Make All Paths Lead to the City Zero'
 * https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero
 */

import java.util.*;

class Solution {
    int edgesToFlip = 0;

    public int minReorder(int n, int[][] connections) {
        Map<Integer, List<int[]>> neigh = new HashMap<>();

        for (int[] con : connections) {
            neigh.computeIfAbsent(con[0], key -> new ArrayList<>()).add(new int[] { con[1], 1 });
            neigh.computeIfAbsent(con[1], key -> new ArrayList<>()).add(new int[] { con[0], 0 });
        }

        breadthFirstSearch(0, n, neigh);
        return edgesToFlip;
    }

    private void breadthFirstSearch(int node, int n, Map<Integer, List<int[]>> neigh) {
        boolean[] vis = new boolean[n];
        Queue<Integer> q = new LinkedList<>();

        q.add(node);
        vis[node] = true;

        while (!q.isEmpty()) {
            int curr = q.remove();
            List<int[]> edges = neigh.get(curr);
            if (edges == null) {
                continue;
            }
            for (int[] edge : edges) {
                int c = edge[0];
                int dir = edge[1];
                if (!vis[c]) {
                    edgesToFlip += dir;
                    vis[c] = true;
                    q.add(c);
                }
            }
        }
    }
}
