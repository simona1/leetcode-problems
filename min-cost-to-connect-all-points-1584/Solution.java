
/**
 * LeetCode problem # 1584, 'Min Cost to Connect All Points'
 * https://leetcode.com/problems/min-cost-to-connect-all-points
 */

import java.util.*;

class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<int[]> edges = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int wt = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);

                int[] curr = { wt, i, j };
                edges.add(curr);
            }
        }

        Collections.sort(edges, (a, b) -> a[0] - b[0]);

        UnionFind uf = new UnionFind(n);
        int res = 0;
        int used = 0;

        for (int i = 0; i < edges.size() && used < n - 1; ++i) {
            int a = edges.get(i)[1];
            int b = edges.get(i)[2];
            int wt = edges.get(i)[0];

            if (uf.union(a, b)) {
                res += wt;
                ++used;
            }
        }
        return res;
    }
}

class UnionFind {
    public int[] parent;
    public int[] count;

    public UnionFind(int size) {
        parent = new int[size];
        count = new int[size];
        for (int i = 0; i < size; ++i) {
            parent[i] = i;
        }
    }

    public int find(int node) {
        if (parent[node] != node) {
            parent[node] = find(parent[node]);
        }
        return parent[node];
    }

    public boolean union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);

        if (parentA == parentB) {
            return false;
        }

        if (count[parentA] > count[parentB]) {
            parent[parentB] = parentA;
        } else if (count[parentA] < count[parentB]) {
            parent[parentA] = parentB;
        } else {
            parent[parentA] = parentB;
            ++count[parentB];
        }
        return true;
    }
}
