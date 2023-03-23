
/**
 * LeetCode problem # 1319, 'Number of Operations to Make Network Connected'
 * https://leetcode.com/problems/number-of-operations-to-make-network-connected
 */

import java.util.*;

class Solution {
    public int makeConnected(int n, int[][] connections) {
        int count = -1;
        if (connections.length < n - 1) {
            return count;
        }

        Map<Integer, List<Integer>> neigh = new HashMap<>();
        for (int[] connection : connections) {
            neigh.computeIfAbsent(connection[0], key -> new ArrayList<>()).add(connection[1]);
            neigh.computeIfAbsent(connection[1], key -> new ArrayList<>()).add(connection[0]);
        }

        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; ++i) {
            if (!vis[i]) {
                ++count;
                breadthFirstSearch(i, neigh, vis);
            }
        }
        return count;
    }

    private void breadthFirstSearch(int cmp, Map<Integer, List<Integer>> neigh, boolean[] vis) {
        Queue<Integer> q = new LinkedList<>();
        q.add(cmp);
        vis[cmp] = true;

        while (!q.isEmpty()) {
            int curr = q.remove();
            List<Integer> connected = neigh.get(curr);
            if (connected == null) {
                continue;
            }
            for (int cn : connected) {
                if (!vis[cn]) {
                    vis[cn] = true;
                    q.add(cn);
                }
            }
        }
    }
}
