
/**
 * LeetCode problem # 367, 'Valid Perfect Square'
 * https://leetcode.com/problems/valid-perfect-square/
 */

class Solution {
    public boolean isPerfectSquare(int num) {
        if (num < 2) {
            return true;
        }
        long left = 0;
        long right = num / 2;
        long mid;
        long squared;

        while (left <= right) {
            mid = right - (right - left) / 2;
            squared = mid * mid;
            if (squared == num) {
                return true;
            }
            if (squared > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}