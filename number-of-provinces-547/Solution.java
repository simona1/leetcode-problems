
/**
 * LeetCode problem # 547, 'Number of Provinces'
 * https://leetcode.com/problems/number-of-provinces
 */

import java.util.*;

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int[] vis = new int[isConnected.length];
        int count = 0;

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < isConnected.length; ++i) {
            if (vis[i] == 0) {
                q.add(i);
                while (!q.isEmpty()) {
                    int curr = q.remove();
                    vis[curr] = 1;
                    for (int j = 0; j < isConnected.length; ++j) {
                        if (isConnected[curr][j] == 1 && vis[j] == 0) {
                            q.add(j);
                        }
                    }
                }
                ++count;
            }
        }
        return count;
    }
}
