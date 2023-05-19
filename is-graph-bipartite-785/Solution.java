
/**
 * LeetCode problem # 785, 'Is Graph Bipartite?'
 * https://leetcode.com/problems/is-graph-bipartite/
 */

import java.util.*;

// use 1 for part1 and -1 for part2 to see if bipartite

class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] connect = new int[n];

        for (int i = 0; i < n; ++i) {
            if (connect[i] != 0) {
                continue;
            }
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            connect[i] = 1;

            while (!q.isEmpty()) {
                int curr = q.remove();
                for (int neigh : graph[curr]) {
                    if (connect[neigh] == 0) {
                        connect[neigh] = -connect[curr];
                        q.add(neigh);
                    } else if (connect[neigh] == connect[curr]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
