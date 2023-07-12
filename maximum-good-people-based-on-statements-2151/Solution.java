
/**
 * LeetCode problem # 2151, 'Maximum Good People Based on Statements'
 * https://leetcode.com/problems/maximum-good-people-based-on-statements/
 */

import java.util.*;

class Solution {

    private boolean isValid(boolean[] vis, int[][] statements) {
        int n = statements.length;
        for (int i = 0; i < n; ++i) {
            if (vis[i]) {
                int[] curr = statements[i];
                for (int j = 0; j < n; ++j) {
                    if (curr[j] == 2) {
                        continue;
                    }
                    if (curr[j] == 0 && vis[j]) {
                        return false;
                    }
                    if (curr[j] == 1 && !vis[j]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public int maximumGood(int[][] statements) {
        int n = statements.length;
        int res = 0;

        // generate the 2^n integers (2 <= n <= 15 so ok)
        for (int i = 0; i < (1 << n); ++i) {
            boolean[] vis = new boolean[n];

            int k = 0;
            int temp = i;
            while (temp != 0) {
                if (temp % 2 == 1) {
                    vis[k] = true;
                }
                temp >>= 1;
                ++k;
            }
            // System.out.println(Arrays.toString(vis));
            if (isValid(vis, statements)) {
                // # of set bits in the binary representation of i
                // (good people in current combo)
                res = Math.max(res, Integer.bitCount(i));
            }
        }
        return res;
    }
}
