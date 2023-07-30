
/**
 * LeetCode problem # 664, 'Strange Printer'
 * https://leetcode.com/problems/strange-printer/
 */

class Solution {
    public int strangePrinter(String s) {
        int n = s.length();
        int[][] cache = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                cache[i][j] = -1;
            }
        }
        return solve(s, n, 0, n - 1, cache) + 1;
    }

    private int solve(String s, int n, int left, int right, int[][] cache) {
        if (cache[left][right] != -1) {
            return cache[left][right];
        }

        cache[left][right] = n;
        int index = -1;
        for (int i = left; i < right; ++i) {
            if (s.charAt(i) != s.charAt(right) && index == -1) {
                index = i;
            }

            if (index != -1) {
                cache[left][right] = Math.min(cache[left][right],
                        1 + solve(s, n, index, i, cache) + solve(s, n, i + 1, right, cache));
            }
        }

        if (index == -1) {
            cache[left][right] = 0;
        }
        return cache[left][right];
    }
}