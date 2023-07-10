
/**
 * LeetCode problem # 2551, 'Put Marbles in Bags'
 * https://leetcode.com/problems/put-marbles-in-bags/
 */

import java.util.*;

class Solution {
    public long putMarbles(int[] weights, int k) {
        int n = weights.length;
        PriorityQueue<Long> sm = new PriorityQueue<Long>((a, b) -> (int) (b - a));
        PriorityQueue<Long> lrg = new PriorityQueue<>();

        long sum1 = 0l;
        long sum2 = 0l;

        for (int i = 0; i < n - 1; ++i) {
            long pair = weights[i] + weights[i + 1];
            sm.add((long) pair);
            lrg.add((long) pair);

            sum1 += pair;
            sum2 += pair;

            if (sm.size() > k - 1) {
                sum1 -= sm.remove();
            }
            if (lrg.size() > k - 1) {
                sum2 -= lrg.remove();
            }
        }
        return sum2 - sum1;

    }
}