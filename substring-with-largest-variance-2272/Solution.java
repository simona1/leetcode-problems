
/**
 * LeetCode problem # 2272, 'Substring With Largest Variance'
 * https://leetcode.com/problems/substring-with-largest-variance/
 */

class Solution {
    public int largestVariance(String s) {
        int n = s.length();
        int maxVariance = 0;

        int[] freq = new int[26];

        for (int i = 0; i < n; ++i) {
            freq[s.charAt(i) - 'a']++;
        }

        for (int a = 0; a < 26; ++a) {
            for (int b = 0; b < 26; ++b) {
                if (a == b || freq[a] == 0 || freq[b] == 0) {
                    continue;
                }

                int[] nums = new int[n];

                for (int i = 0; i < n; ++i) {
                    int c = s.charAt(i) - 'a';
                    if (c == a) {
                        nums[i] = 1;
                    } else if (c == b) {
                        nums[i] = -1;
                    }
                }
                maxVariance = Math.max(maxVariance, solve(nums));
            }
        }
        return maxVariance;
    }

    private int solve(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];
        dp[0] = nums[0];

        for (int i = 1; i < n; ++i) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        }

        int curr = 0;
        int maxVariance = 0;
        for (int i = n - 1; i >= 0; --i) {
            curr = Math.max(curr + nums[i], nums[i]);
            if (nums[i] == -1) {
                maxVariance = Math.max(maxVariance, dp[i] + curr - nums[i]);
            }
        }
        return maxVariance;
    }
}