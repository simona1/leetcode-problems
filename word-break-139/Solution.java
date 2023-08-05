
/**
 * LeetCode problem # 139, 'Word Break'
 * https://leetcode.com/problems/word-break/
 */

import java.util.*;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); ++i) {
            for (String word : wordDict) {
                if (word.length() <= i) {
                    if (dp[i - word.length()]) {
                        if (s.substring(i - word.length(), i).equals(word)) {
                            dp[i] = true;
                            break;
                        }
                    }
                }
            }
        }

        for (int i = 1; i <= s.length(); ++i) {
            for (int j = 0; j < i; ++j) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}