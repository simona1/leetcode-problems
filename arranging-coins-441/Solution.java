/**
 * LeetCode problem # 441, 'Arranging Coins'
 * https://leetcode.com/problems/arranging-coins/
 */

class Solution {
    public int arrangeCoins(int n) {
        long low = 0;
        long high = n;
        long mid;
        long curr;

        while (low <= high) {
            mid = low + (high - low) / 2;
            curr = mid * (mid + 1) / 2;

            if (curr == n) {
                return (int) mid;
            }
            if (n < curr) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (int) high;
    }
}