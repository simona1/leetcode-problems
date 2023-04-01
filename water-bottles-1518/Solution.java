/**
 * LeetCode problem # 1518, 'Water Bottles'
 * https://leetcode.com/problems/water-bottles
 */

class Solution {

    // iterative
    public int numWaterBottles(int numBottles, int numExchange) {
        int res = 0;
        int empty = 0;

        while (numBottles > 0) {
            res += numBottles;

            empty += numBottles;

            numBottles = empty / numExchange;
            empty %= numExchange;

        }
        return res;
    }

    // recursive version with helper function
    public int numWaterBottlesRecursive(int numBottles, int numExchange) {
        return exchangeBottles(numBottles, numExchange, 0);
    }

    private int exchangeBottles(int numBottles, int numExchange, int empty) {
        if (numBottles == 0) {
            return 0;
        }
        empty += numBottles;
        return numBottles + exchangeBottles(empty / numExchange, numExchange, empty % numExchange);
    }
}
