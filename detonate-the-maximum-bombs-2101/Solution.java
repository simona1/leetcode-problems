
/**
 * LeetCode problem # 2101, 'Detonate the Maximum Bombs'
 * https://leetcode.com/problems/detonate-the-maximum-bombs/
 */

import java.util.*;

class Solution {
    public int maximumDetonation(int[][] bombs) {

        Map<Integer, List<Integer>> neigh = new HashMap<>();
        int n = bombs.length;
        int res = 0;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                int x1 = bombs[i][0];
                int y1 = bombs[i][1];
                int rad = bombs[i][2];

                int x2 = bombs[j][0];
                int y2 = bombs[j][1];

                long curr = (long) rad * rad;
                long dist = (long) (x1 - x2) * (x1 - x2) + (long) (y1 - y2) * (y1 - y2);
                if (curr >= dist) {
                    neigh.computeIfAbsent(i, val -> new ArrayList<>()).add(j);
                }
            }
        }
        for (int i = 0; i < n; ++i) {
            res = Math.max(res, breadthFirstSearch(i, neigh));
        }
        return res;

    }

    private int breadthFirstSearch(int index, Map<Integer, List<Integer>> neigh) {
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> vis = new HashSet<>();
        q.add(index);
        vis.add(index);

        while (!q.isEmpty()) {
            int curr = q.remove();
            for (int node : neigh.getOrDefault(curr, new ArrayList<>())) {
                if (!vis.contains(node)) {
                    vis.add(node);
                    q.add(node);
                }
            }
        }
        return vis.size();
    }
}
