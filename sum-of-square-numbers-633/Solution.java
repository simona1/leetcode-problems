
/**
 * LeetCode problem # 633, 'Sum of Square Numbers'
 * https://leetcode.com/problems/sum-of-square-numbers/
 */

class Solution {
    public boolean judgeSquareSum(int c) {
        for (long a = 0; a * a <= c; ++a) {
            int b = c - (int) (a * a);
            if (binarySearch(0, b, b)) {
                return true;
            }
        }
        return false;
    }

    private boolean binarySearch(long low, long high, int n) {
        if (low > high) {
            return false;
        }

        long mid = low + (high - low) / 2;
        if (mid * mid == n) {
            return true;
        }
        if (mid * mid > n) {
            return binarySearch(low, mid - 1, n);
        }
        return binarySearch(mid + 1, high, n);
    }
}
