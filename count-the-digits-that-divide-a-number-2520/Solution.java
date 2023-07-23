
/**
 * LeetCode problem # 2520, 'Count the Digits That Divide a Number'
 * https://leetcode.com/problems/count-the-digits-that-divide-a-number/
 */

class Solution {
    public int countDigits(int num) {
        int res = 0;
        int numCopy = num;
        while (num != 0) {
            int digit = num % 10;
            num /= 10;
            if (digit != 0 && numCopy % digit == 0) {
                ++res;
            }
        }
        return res;
    }
}