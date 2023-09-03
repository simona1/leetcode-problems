
/**
 * LeetCode problem # 62, 'Unique Paths'
 * https://leetcode.com/problems/unique-paths/
 */

class Solution {
    public int uniquePaths(int m, int n) {

        int a = m + n - 2;
        int b = m - 1;
        double res = 1;

        for (int i = 1; i <= b; ++i) {
            res *= ((a - b + i) / (double) i);
        }
        return (int) Math.round(res);
    }
}
