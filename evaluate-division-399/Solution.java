
/**
 * LeetCode problem # 399, 'Evaluate Division'
 * https://leetcode.com/problems/evaluate-division/
 */

import java.util.*;

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> eq = equations.get(i);
            String dividend = eq.get(0);
            String divisor = eq.get(1);
            double qt = values[i];

            graph.computeIfAbsent(dividend, val -> new HashMap<>());
            graph.computeIfAbsent(divisor, val -> new HashMap<>());
            graph.get(dividend).put(divisor, qt);
            graph.get(divisor).put(dividend, 1 / qt);
        }

        int n = queries.size();
        double[] res = new double[n];
        for (int i = 0; i < n; i++) {
            List<String> query = queries.get(i);
            String dividend = query.get(0);
            String divisor = query.get(1);

            if (!graph.containsKey(dividend) || !graph.containsKey(divisor)) {
                res[i] = -1.0;
            } else if (dividend.equals(divisor)) {
                res[i] = 1.0;
            } else {
                Set<String> vis = new HashSet<>();
                res[i] = backtrack(graph, dividend, divisor, 1, vis);
            }
        }

        return res;
    }

    private double backtrack(Map<String, Map<String, Double>> graph, String curr, String target, double prod,
            Set<String> vis) {

        vis.add(curr);
        double res = -1.0;

        Map<String, Double> neigh = graph.get(curr);

        if (neigh.containsKey(target)) {
            res = prod * neigh.get(target);
        } else {
            for (Map.Entry<String, Double> pair : neigh.entrySet()) {
                String next = pair.getKey();
                if (vis.contains(next)) {
                    continue;
                }
                res = backtrack(graph, next, target, prod * pair.getValue(), vis);
                if (res != -1.0) {
                    break;
                }
            }
        }

        vis.remove(curr);
        return res;
    }
}
