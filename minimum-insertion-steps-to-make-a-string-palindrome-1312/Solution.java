/**
 * LeetCode problem # 1312, 'Minimum Insertion Steps to Make a String
 * Palindrome'
 * https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome
 */

class Solution {
    public int minInsertions(String s) {
        int lcs = longestPalindromeSubsequence(s);
        return s.length() - lcs;
    }

    public int longestPalindromeSubsequence(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; ++i) {
            dp[i][i] = 1;
        }

        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
