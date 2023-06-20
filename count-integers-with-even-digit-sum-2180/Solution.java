
/**
 * LeetCode problem # 2180, 'Count Integers With Even Digit Sum'
 * https://leetcode.com/problems/count-integers-with-even-digit-sum/
 */

class Solution {
    public int countEven(int num) {
        int res = 0;
        for (int i = 1; i <= num; ++i) {
            if (i < 10 && i % 2 == 0) {
                ++res;
            } else {
                if (getDigitSum(i) % 2 == 0) {
                    ++res;
                }
            }
        }
        return res;
    }

    private int getDigitSum(int n) {
        String[] digits = String.valueOf(n).split("");

        int sum = 0;
        for (String digit : digits) {
            sum += Integer.parseInt(digit);
        }
        return sum;

    }
}