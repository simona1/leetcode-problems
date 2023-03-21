/**
 * LeetCode problem # 121, 'Best Time to Buy and Sell Stock'
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */

class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;

        for (int price : prices) {
            int potentialProfit = price - minPrice;
            maxProfit = Math.max(maxProfit, potentialProfit);
            minPrice = Math.min(minPrice, price);
        }
        return maxProfit < 0 ? 0 : maxProfit;
    }
}
