
/**
 * LeetCode problem # 50, 'Pow(x, n)'
 * 
 * https://leetcode.com/problems/powx-n
 */

class Solution {
    public double myPow(double x, int n) {
        long pow = n;
        if (pow < 0) {
            x = 1 / x;
            pow = -pow;
        }
        double res = 1;
        double curr = x;
        for (long i = pow; i > 0; i /= 2) {
            if (i % 2 == 1) {
                res = res * curr;
            }
            curr = curr * curr;
        }
        return res;
    }
}