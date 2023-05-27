
/**
 * LeetCode problem # 1514, 'Path with Maximum Probability'
 * https://leetcode.com/problems/path-with-maximum-probability/
 */

import java.util.*;

class Pair {
    int edge;
    double prob;

    Pair(int edge, double p) {
        this.edge = edge;
        this.prob = p;

    }
}

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, List<Pair>> neighbors = new HashMap<>();

        int len = edges.length;
        for (int i = 0; i < len; ++i) {
            int a = edges[i][0];
            int b = edges[i][1];
            double p = succProb[i];
            neighbors.computeIfAbsent(a, val -> new ArrayList<>()).add(new Pair(b, p));
            neighbors.computeIfAbsent(b, val -> new ArrayList<>()).add(new Pair(a, p));
        }

        double[] visProbs = new double[n];
        visProbs[start] = 1.0;

        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {
            int curr = q.remove();
            List<Pair> neighList = neighbors.getOrDefault(curr, new ArrayList<>());
            for (Pair neigh : neighList) {
                int next = neigh.edge;
                double p = neigh.prob;
                double pathProb = visProbs[curr] * p;
                if (pathProb > visProbs[next]) {
                    visProbs[next] = pathProb;
                    q.add(next);
                }
            }

        }
        return visProbs[end];
    }
}
