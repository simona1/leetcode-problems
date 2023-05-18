
/**
 * LeetCode problem # 1557, 'Minimum Number of Vertices to Reach All Nodes'
 * https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes
 */

import java.util.*;

class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        boolean[] connections = new boolean[n];
        for (List<Integer> edge : edges) {
            connections[edge.get(1)] = true;
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (!connections[i]) {
                res.add(i);
            }
        }
        return res;
    }
}
