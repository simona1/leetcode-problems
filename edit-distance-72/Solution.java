
/**
 * LeetCode problem # 72, 'Edit Distance'
 * https://leetcode.com/problems/edit-distance
 */

import java.util.Arrays;

class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        if (n == 0) {
            return m;
        }
        if (m == 0) {
            return n;
        }
        int[][] dp = new int[n][m];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return editDistImpl(word1, word2, dp, n - 1, m - 1);
    }

    private int editDistImpl(String w1, String w2, int[][] dp, int i, int j) {
        if (i < 0) {
            return j + 1;
        }
        if (j < 0) {
            return i + 1;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (w1.charAt(i) == w2.charAt(j)) {
            dp[i][j] = editDistImpl(w1, w2, dp, i - 1, j - 1);
        } else {
            int prevMin = Math.min(editDistImpl(w1, w2, dp, i, j - 1), editDistImpl(w1, w2, dp, i - 1, j));
            prevMin = Math.min(prevMin, editDistImpl(w1, w2, dp, i - 1, j - 1));
            dp[i][j] = 1 + prevMin;
        }
        return dp[i][j];
    }
}