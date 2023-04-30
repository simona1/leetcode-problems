
/**
 * LeetCode problem # 1579, 'Remove Max Number of Edges to Keep Graph Fully
 * Traversable'
 * https://leetcode.com/problems/remove-max-number-of-edges-to-keep-graph-fully-traversable
 */

class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {

        UnionFind alice = new UnionFind(n);
        UnionFind bob = new UnionFind(n);

        int need = 0;
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                need += (alice.connect(edge[1], edge[2]) | bob.connect(edge[1], edge[2]));
            }
        }

        for (int[] edge : edges) {
            if (edge[0] == 1) {
                need += alice.connect(edge[1], edge[2]);
            } else if (edge[0] == 2) {
                need += bob.connect(edge[1], edge[2]);
            }
        }

        if (alice.isConnected() && bob.isConnected()) {
            return edges.length - need;
        }
        return -1;
    }

    private class UnionFind {
        int[] parent;
        int[] count;
        int nodes;

        public UnionFind(int n) {
            nodes = n;
            parent = new int[n + 1];
            count = new int[n + 1];

            for (int i = 0; i <= n; ++i) {
                parent[i] = i;
                count[i] = 1;
            }
        }

        int getRoot(int x) {
            if (parent[x] == x) {
                return x;
            }
            return parent[x] = getRoot(parent[x]);
        }

        int connect(int x, int y) {
            x = getRoot(x);
            y = getRoot(y);

            if (x == y) {
                return 0;
            }
            if (count[x] > count[y]) {
                count[x] += count[y];
                parent[y] = x;
            } else {
                count[y] += count[x];
                parent[x] = y;
            }
            --nodes;
            return 1;
        }

        boolean isConnected() {
            return nodes == 1;
        }
    }
}
