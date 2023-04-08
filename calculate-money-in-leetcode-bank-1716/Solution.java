
/**
 * LeetCode problem # 1716, 'Calculate Money in Leetcode Bank'
 * https://leetcode.com/problems/calculate-money-in-leetcode-bank
 */

class Solution {
    public int totalMoney(int n) {

        int monday = 0;
        int res = 0;
        int amount = 1;

        for (int i = 1; i <= n; ++i) {
            res += amount;
            if (i % 7 == 0) {
                ++monday;
                amount = monday;
            }
            ++amount;
        }
        return res;
    }
}
