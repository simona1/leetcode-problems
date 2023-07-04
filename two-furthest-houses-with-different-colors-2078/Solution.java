
/**
 * LeetCode problem # 2078, 'Two Furthest Houses With Different Colors'
 * https://leetcode.com/problems/two-furthest-houses-with-different-colors/
 */

class Solution {
    public int maxDistance(int[] colors) {
        int len = colors.length;
        int i = 0;
        int j = len - 1;
        int m = 0;
        int n = len - 1;

        while (colors[i] == colors[j]) {
            --j;
        }
        while (colors[m] == colors[n]) {
            ++m;
        }
        return Math.max(Math.abs(j - i), Math.abs(n - m));
    }
}