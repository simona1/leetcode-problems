
/**
 * LeetCode problem # 778, 'Swim in Rising Water'
 * https://leetcode.com/problems/swim-in-rising-water/
 */

import java.util.*;

class Solution {

    static int[] dr = new int[] { 1, -1, 0, 0 };
    static int[] dc = new int[] { 0, 0, 1, -1 };

    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int lo = grid[0][0];
        int hi = n * n;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if (!isPossible(grid, mid)) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    public boolean isPossible(int[][] grid, int t) {
        int n = grid.length;

        Set<Integer> vis = new HashSet<>();
        vis.add(0);

        Stack<Integer> stack = new Stack<>();
        stack.add(0);

        while (!stack.empty()) {
            int curr = stack.pop();
            int r = curr / n;
            int c = curr % n;

            if (r == n - 1 && c == n - 1) {
                return true;
            }

            for (int i = 0; i < 4; ++i) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                int next = nr * n + nc;

                if (0 <= nr && nr < n && 0 <= nc && nc < n && !vis.contains(next) && grid[nr][nc] <= t) {
                    stack.add(next);
                    vis.add(next);
                }
            }
        }
        return false;
    }
}