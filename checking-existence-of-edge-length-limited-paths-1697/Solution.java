/**
 * LeetCode problem # 1697, 'Checking Existence of Edge Length Limited Paths'
 * https://leetcode.com/problems/checking-existence-of-edge-length-limited-paths/
 */

import java.util.*;

class Query {
  int p;
  int q;
  int lim;
  int index;

  Query(int a, int b, int c, int d) {
    this.p = a;
    this.q = b;
    this.lim = c;
    this.index = d;
  }
}

class Solution {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        int qn = queries.length;
        
        UnionFind uf = new UnionFind(n);
        boolean[] res = new boolean[qn];

        Query[] queriesWithIndex = new Query[qn];
        for (int i = 0; i < qn; ++i) {
            queriesWithIndex[i] = new Query(queries[i][0], queries[i][1], queries[i][2], i);
        }
        Arrays.sort(edgeList, (a, b) -> a[2] - b[2]);
        Arrays.sort(queriesWithIndex, (a, b) -> a.lim - b.lim);

        int edgesIndex = 0;
        for (int i = 0; i < qn; ++i) {
            Query curr = queriesWithIndex[i];
            int p = curr.p;
            int q = curr.q;
            int limit = curr.lim;
            int initialIndex = curr.index;

            while (edgesIndex < edgeList.length && edgeList[edgesIndex][2] < limit) {
                int node1 = edgeList[edgesIndex][0];
                int node2 = edgeList[edgesIndex][1];
                uf.connect(node1, node2);
                edgesIndex += 1;
            }
            res[initialIndex] = uf.areConnected(p, q);
        }
        return res;
    }
}

class UnionFind {
  int[] parent;
  int[] count;

  public UnionFind(int x) {
    this.parent = new int[x];
    this.count = new int[x];
    for (int i = 0; i < x; i++) {
      this.parent[i] = i;
      this.count[i] = 1;
    }
  }

  public boolean areConnected(int a, int b) {
    return getRoot(a) == getRoot(b);
  }

  public int getRoot(int a) {
    while (a != this.parent[a]) {
      a = this.parent[a];
    }
    return a;
  }

  public void connect(int a, int b) {
    int rootA = getRoot(a);
    int rootB = getRoot(b);
    if (rootA == rootB) {
      return;
    }
    if (this.count[rootA] < this.count[rootB]) {
      this.parent[rootA] = rootB;
      this.count[rootB] += this.count[rootA];
    } else {
      this.parent[rootB] = rootA;
      this.count[rootA] += this.count[rootB];
    }
  }
}
