/**
 * LeetCode problem # 674, 'Longest Continuous Increasing Subsequence'
 * https://leetcode.com/problems/longest-continuous-increasing-subsequence/
 */

class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int res = 0;
        int ptr = 0;

        for (int i = 0; i < nums.length; ++i) {
            if (i > 0 && nums[i - 1] >= nums[i]) {
                ptr = i;
            }
            res = Math.max(res, i - ptr + 1);
        }
        return res;
    }
}
