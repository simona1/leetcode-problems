/**
 * LeetCode problem # 516, 'Longest Palindromic Subsequence'
 * https://leetcode.com/problems/longest-palindromic-subsequence/
 */

class Solution {
    public int longestPalindromeSubseq(String s) {
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

/*
 * 
 * dp[i][j]: the longest subseq length for substring(i, j), where i and j are
 * the left and right indexes in the string
 * 
 * dp[i][i] = 1
 * 
 * if char at index i is the same as char at index j then: dp[i][j] = dp[i +
 * 1][j - 1] + 2 else: dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1])
 * 
 */