
/**
 * LeetCode problem # 1482, 'Minimum Number of Days to Make m Bouquets'
 * https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/
 */

import java.util.*;

class Solution {
    public int minDays(int[] bloomDay, long m, long k) {
        int n = bloomDay.length;
        if (m * k > n) {
            return -1;
        }
        int upperLimit = Arrays.stream(bloomDay).max().getAsInt() + 1;

        int lo = -1;
        int hi = upperLimit;

        while (lo + 1 != hi) {
            int mid = lo + (hi - lo) / 2;
            if (canMakeBouquet(bloomDay, m, k, mid)) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        return hi;
    }

    private boolean canMakeBouquet(int[] bloomday, long m, long k, int day) {
        int curr = 0;
        int total = 0;

        for (int i = 0; i < bloomday.length; ++i) {
            if (bloomday[i] <= day) {
                ++curr;
            } else {
                curr = 0;
            }
            if (curr == k) {
                ++total;
                curr = 0;
            }
        }
        return total >= m;
    }
}
