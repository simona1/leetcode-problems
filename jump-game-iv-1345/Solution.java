/*
 * LeetCode problem # 1345, 'Jump Game IV'
 * https://leetcode.com/problems/jump-game-iv/
 */

import java.util.*;

class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;

        Map<Integer, List<Integer>> dupl = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            dupl.computeIfAbsent(arr[i], value -> new ArrayList<Integer>()).add(i);
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];
        int[] steps = new int[n];

        q.add(0);
        vis[0] = true;

        while (!q.isEmpty()) {
            int curr = q.remove();
            int prev = curr - 1;
            int next = curr + 1;
            if (prev >= 0 && !vis[prev]) {
                q.add(prev);
                vis[prev] = true;
                steps[prev] = steps[curr] + 1;
            }
            if (next < n && !vis[next]) {
                q.add(next);
                vis[next] = true;
                steps[next] = steps[curr] + 1;
            }
            List<Integer> others = dupl.get(arr[curr]);
            for (int other : others) {
                if (!vis[other]) {
                    q.add(other);
                    vis[other] = true;
                    steps[other] = steps[curr] + 1;
                }
            }
            dupl.put(arr[curr], new ArrayList<>());
        }
        return steps[n - 1];
    }
}
