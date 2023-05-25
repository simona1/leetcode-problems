/**
 * LeetCode problem # 1475, 'Final Prices With a Special Discount in a Shop'
 * https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/
 */

import java.util.*;

class Solution {
    public int[] finalPrices(int[] prices) {
        Deque<Integer> dq = new ArrayDeque<>();
        int n = prices.length;
        int[] res = new int[n];

        for (int i = 0; i < n; ++i) {
            while(!dq.isEmpty() && prices[i] <= prices[dq.peek()]) {
                res[dq.pop()] -= prices[i];
            }
            res[i] = prices[i];
            dq.push(i);
        }
        return res;
    }
}
