
/**
 * LeetCode problem # 2646, 'Minimize the Total Price of the Trips'
 * https://leetcode.com/problems/minimize-the-total-price-of-the-trips
 */

import java.util.*;

class Solution {
    public int minimumTotalPrice(int n, int[][] edges, int[] price, int[][] trips) {

        Map<Integer, Set<Integer>> tree = buildTree(edges, n);

        int[] vis = new int[n];
        for (int[] trip : trips) {
            int start = trip[0];
            int end = trip[1];

            List<Integer> path = getPath(start, end, tree);
            for (int p : path) {
                vis[p]++;
            }
        }

        for (int i = 0; i < n; ++i) {
            price[i] *= vis[i];
        }
        makeRoot(tree, 0);

        int[][] cache = new int[n][2];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < 2; ++j) {
                cache[i][j] = -1;
            }

        }

        int maxSavings = solve(tree, price, 0, 0, cache);
        int totalSum = 0;

        for (int p : price) {
            totalSum += p;
        }

        return totalSum - maxSavings;
    }

    private void makeRoot(Map<Integer, Set<Integer>> tree, int node) {
        for (int kid : tree.get(node)) {
            tree.get(kid).remove(node);
            makeRoot(tree, kid);
        }

    }

    private int solve(Map<Integer, Set<Integer>> tree, int[] price, int node, int parentIsHalved, int[][] cache) {

        if (cache[node][parentIsHalved] >= 0) {
            return cache[node][parentIsHalved];
        }

        int opt1 = 0;
        for (int kid : tree.get(node)) {
            opt1 += solve(tree, price, kid, 0, cache);
        }
        if (parentIsHalved == 1) {
            cache[node][parentIsHalved] = opt1;
            return opt1;
        }

        int opt2 = price[node] / 2;
        for (int kid : tree.get(node)) {
            opt2 += solve(tree, price, kid, 1, cache);
        }
        int res = Math.max(opt1, opt2);
        cache[node][parentIsHalved] = res;
        return res;
    }

    public Map<Integer, Set<Integer>> buildTree(int[][] edges, int n) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            map.put(i, new HashSet<>());
        }

        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);

        }
        return map;
    }

    private List<Integer> getPath(int startNode, int endNode, Map<Integer, Set<Integer>> tree) {
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();

        q.add(startNode);
        map.put(startNode, null);

        while (!q.isEmpty()) {
            Integer curr = q.remove();
            Set<Integer> nextNodes = tree.get(curr);

            for (int next : nextNodes) {
                if (!map.containsKey(next)) {
                    map.put(next, curr);
                    q.add(next);
                }
            }
        }

        Stack<Integer> st = new Stack<>();
        st.push(endNode);
        while (true) {
            Integer prev = map.get(st.peek());
            if (prev == null) {
                break;
            }
            st.push(prev);
        }
        return st;
    }
}
