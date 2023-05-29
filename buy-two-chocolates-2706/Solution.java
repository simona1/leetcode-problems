
/**
 * LeetCode problem # 2706, 'Buy Two Chocolates'
 * https://leetcode.com/problems/buy-two-chocolates/
 */

import java.util.*;

class Solution {
    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        int a = prices[0];
        int b = prices[1];
        if (a + b <= money) {
            return money - (a + b);
        }
        return money;

    }
}
