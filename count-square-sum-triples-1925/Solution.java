/**
 * LeetCode problem # 1925, 'Count Square Sum Triples'
 * https://leetcode.com/problems/count-square-sum-triples
 */

class Solution {
    public int countTriples(int n) {
        int res = 0;
        for (int a = 1; a <= n; ++a) {
            for (int b = 1; b <= n; ++b) {
                int curr = Math.max(a, b);
                for (int c = curr; c <= n; ++c) {
                    if (a * a + b * b == c * c) {
                        ++res;
                    }
                }
            }
        }
        return res;
    }
}