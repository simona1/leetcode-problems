/**
 * LeetCode problem # 1857, 'Largest Color Value in a Directed Graph'
 * https://leetcode.com/problems/largest-color-value-in-a-directed-graph/
 */

import java.util.*;

class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        int[] dist = new int[n];
        Map<Integer, List<Integer>> tree = new HashMap<>();

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            tree.computeIfAbsent(a, val -> new ArrayList<>()).add(b);
            dist[b]++;
        }

        int[][] counts = new int[n][26];
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; ++i) {
            if (dist[i] == 0) {
                q.add(i);
            }
        }

        int res = 1;
        int seen = 0;

        while(!q.isEmpty()) {
            int curr = q.remove();
            int color = colors.charAt(curr) - 'a';
            res = Math.max(res, ++counts[curr][color]);
            ++seen;

            List<Integer> currNeigh = tree.get(curr);

            if (currNeigh == null) {
                continue;
            }
            
            for (int neigh : currNeigh) {
                for (int i = 0; i < 26; ++i) {
                    counts[neigh][i] = Math.max(counts[neigh][i], counts[curr][i]);
                }

                dist[neigh]--;
                if (dist[neigh] == 0) {
                    q.add(neigh);
                }
            }
        }
        return seen  < n ? -1 : res;
    }
}