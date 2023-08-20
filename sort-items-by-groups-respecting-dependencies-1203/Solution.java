
/**
 * LeetCode problem # 1203, 'Sort Items by Groups Respecting Dependencies'
 * https://leetcode.com/problems/sort-items-by-groups-respecting-dependencies/
 */

import java.util.*;

class Solution {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        int groupId = m;
        for (int i = 0; i < n; ++i) {
            if (group[i] == -1) {
                group[i] = groupId;
                ++groupId;
            }
        }

        Map<Integer, List<Integer>> itemGraph = new HashMap<>();
        int[] itemIndegree = new int[n];
        for (int i = 0; i < n; ++i) {
            itemGraph.put(i, new ArrayList<>());
        }

        Map<Integer, List<Integer>> groupGraph = new HashMap<>();
        int[] groupIndegree = new int[groupId];
        for (int i = 0; i < groupId; ++i) {
            groupGraph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < n; ++i) {
            for (int j : beforeItems.get(i)) {
                itemGraph.get(j).add(i);
                itemIndegree[i]++;

                if (group[i] != group[j]) {
                    groupGraph.get(group[j]).add(group[i]);
                    groupIndegree[group[i]]++;
                }
            }
        }

        List<Integer> itemOrder = solve(itemGraph, itemIndegree);
        List<Integer> groupOrder = solve(groupGraph, groupIndegree);

        if (itemOrder.isEmpty() || groupOrder.isEmpty()) {
            return new int[0];
        }

        Map<Integer, List<Integer>> orderedGroups = new HashMap<>();
        for (Integer item : itemOrder) {
            orderedGroups.computeIfAbsent(group[item], k -> new ArrayList<>()).add(item);
        }

        List<Integer> res = new ArrayList<>();
        for (int groupIndex : groupOrder) {
            res.addAll(orderedGroups.getOrDefault(groupIndex, new ArrayList<>()));
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    private List<Integer> solve(Map<Integer, List<Integer>> graph, int[] indegree) {
        List<Integer> vis = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (Integer key : graph.keySet()) {
            if (indegree[key] == 0) {
                stack.add(key);
            }
        }

        while (!stack.isEmpty()) {
            Integer curr = stack.pop();
            vis.add(curr);

            for (Integer prev : graph.get(curr)) {
                indegree[prev]--;
                if (indegree[prev] == 0) {
                    stack.add(prev);
                }
            }
        }

        return vis.size() == graph.size() ? vis : new ArrayList<>();
    }
}