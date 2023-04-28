/**
 * LeetCode problem # 839, 'Similar String Groups'
 * https://leetcode.com/problems/similar-string-groups
 */

import java.util.*;

class Solution {
    private void breadthFirstSearch(int node, Map<Integer, List<Integer>> neighbors, boolean[] vis) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        vis[node] = true;
        
        while (!q.isEmpty()) {
            node = q.remove();
            List<Integer> neigh = neighbors.get(node);
            if (neigh == null) {
                continue;
            }
            for (int n : neigh) {
                if (!vis[n]) {
                    vis[n] = true;
                    q.add(n);
                }
            }
        }
    }

    private boolean areStringsSimilar(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); ++i) {
            if (a.charAt(i) != b.charAt(i)) {
                ++diff;
            }
        }
        return diff == 0 || diff == 2;
    }

    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        Map<Integer, List<Integer>> neighbors = new HashMap<>();

        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (areStringsSimilar(strs[i], strs[j])) {
                    neighbors.computeIfAbsent(i, k -> new ArrayList<Integer>()).add(j);
                    neighbors.computeIfAbsent(j, k -> new ArrayList<Integer>()).add(i);
                }
            }
        }

        boolean[] vis = new boolean[n];
        int res = 0;
        for (int i = 0; i < n; ++i) {
            if (!vis[i]) {
                breadthFirstSearch(i, neighbors, vis);
                ++res;
            }
        }
        return res;
    }
}
