
/**
 * LeetCode problem # 2141, 'Maximum Running Time of N Computers'
 * https://leetcode.com/problems/maximum-running-time-of-n-computers/
 */

import java.util.*;

class Solution {
    public long maxRunTime(int n, int[] batteries) {
        Arrays.sort(batteries);
        int len = batteries.length;

        long reserve = 0;
        for (int i = 0; i < len - n; ++i) {
            reserve += batteries[i];
        }

        int[] running = Arrays.copyOfRange(batteries, len - n, len);
        for (int i = 0; i < n - 1; ++i) {
            long diff = (long) (running[i + 1] - running[i]);
            long next = i + 1;

            if (reserve < (next * diff)) {
                return running[i] + reserve / next;
            }

            reserve -= next * diff;
        }
        return running[n - 1] + reserve / n;
    }
}