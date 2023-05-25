
/**
 * LeetCode problem # 837, 'New 21 Game'
 * https://leetcode.com/problems/new-21-game/
 */

import java.util.*;

class Solution {
    public double new21Game(int n, int k, int maxPts) {
        if (k == 0) {
            return 1.0;
        }

        Deque<Double> dq = new LinkedList<>();
        double total = 0.0;
        for (int i = k; i < k + maxPts; ++i) {
            double p = (i <= n) ? 1.0 : 0.0;
            dq.offerLast(p);
            total += p;
        }

        for (int i = k - 1; i >= 0; --i) {
            double p = total / maxPts;
            total = total - dq.pollLast() + p;
            dq.offerFirst(p);
        }

        return dq.peekFirst();
    }
}
