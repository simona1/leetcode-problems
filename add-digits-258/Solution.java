
/**
 * LeetCode problem # 258, 'Add Digits' https://leetcode.com/problems/add-digits
 */

class Solution {
    public int addDigits(int num) {
        int res = 0;

        while (num > 0) {
            int digit = num % 10;
            System.out.println(res);
            res += digit;
            num /= 10;
        }

        return res < 10 ? res : addDigits(res);
    }
}